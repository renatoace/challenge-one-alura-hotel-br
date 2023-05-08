package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Reserva;

public class ReservaDAO {

	private Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Reserva reserva) {
		try {
			String sql = "INSERT INTO RESERVAS (DataEntrada, DataSaida, Valor, FormaPagamento) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setDate(1, new java.sql.Date(reserva.getDataEntrada().getTime()));// convertendo um Date java para
																						// Date sql
				pstm.setDate(2, new java.sql.Date(reserva.getDataSaida().getTime()));
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

	public List<Reserva> buscar() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {

			String sql = "SELECT id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				trasformarResultSetEmReserva(reservas, pstm);
			}
			return reservas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void trasformarResultSetEmReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getDouble(4),
						rst.getString(5));

				reservas.add(reserva);
			}
		}

	}

	public List<Reserva> buscaNumero(Integer id) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		try {

			String sql = "SELECT id, DataEntrada, DataSaida, Valor, FormaPagamento FROM reservas WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setInt(1, id);
				pstm.execute();

				trasformarResultSetEmReserva(reservas, pstm);
			}
			return reservas;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editar(Date dataEntrada, Date dataSaida, Double valor, String formaPagamento, Integer id) {

		System.out.println("Editando reserva no banco de dados!!! no DAO");
		try {
			try (PreparedStatement pstm = connection.prepareStatement(
					"UPDATE reservas SET DATAENTRADA = ?, DATASAIDA = ?, VALOR = ?, FORMAPAGAMENTO = ? WHERE ID = ?")) {
				pstm.setDate(1, (java.sql.Date) dataEntrada);
				pstm.setDate(2, (java.sql.Date) dataSaida);
				pstm.setDouble(3, valor);
				pstm.setString(4, formaPagamento);
				pstm.setInt(5, id);
				pstm.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletar(Integer id) {
		try {
			try(PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE ID = ?")) {
			stm.setInt(1, id);
			stm.execute();
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
