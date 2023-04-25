package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDao {

	private Connection connection;

	public ReservaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Reserva reserva) {
		try {
			String sql = "INSERT INTO RESERVAS (DataEntrada, DataSaida, Valor, FormaPagamento) VALUES (?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setDate(1,new java.sql.Date (reserva.getDataEntrada().getTime()));// convertendo um Date java para Date sql 
			pstm.setDate(2,new java.sql.Date (reserva.getDataSaida().getTime()));
			pstm.setDouble(3, reserva.getValor());
			pstm.setString(4, reserva.getFormaPagamento());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					reserva.setId(rst.getInt(1));
				}
			}
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Reserva> listar(){

		try {
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "SELECT * FROM Reserva";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			trasformarResultSetEmReserva(reservas, pstm);
		}
		return reservas;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	private void trasformarResultSetEmReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(2),rst.getDouble(3),rst.getString(4));
				reservas.add(reserva);
			}
		}
		
	}


}
