package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Diaria;
import modelo.Usuario;

public class DiariaDAO {

	private Connection connection;
	
	public DiariaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Diaria> listar(){

		try {
		List<Diaria> diarias = new ArrayList<Diaria>();
		String sql = "SELECT * FROM valor_diaria";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			trasformarResultSetEmDiaria(diarias, pstm);
		}
		return diarias;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

	public Double pegarValorDiaria() {
		List<Diaria> listar = listar();
		Double valor = null;
		for (Diaria diaria : listar) {
			valor = diaria.getValorDiaria();
		}
		System.out.println(valor);
		return valor;
	}
	
	private void trasformarResultSetEmDiaria(List<Diaria> diarias, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Diaria diaria = new Diaria(rst.getInt(1), rst.getDouble(2));
				diarias.add(diaria);
			}
		}
		
	}
}
