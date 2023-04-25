package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Hostepe;

public class HospedeDao {
	
	private Connection connection;
	
	public HospedeDao(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Hostepe hospede) {
		try {
			String sql = "INSERT INTO HOSPEDES (NOME, SOBRENOME, DATANASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, hospede.getNome()); 
			pstm.setString(2,hospede.getSobrenome());
			pstm.setDate(3, new java.sql.Date (hospede.getDataNascimento().getTime()));// convertendo um Date java para Date sql
			pstm.setString(4, hospede.getNacionalidade());
			pstm.setString(5, hospede.getTelefone());
			pstm.setInt(6, hospede.getIdReserva());

			pstm.execute();

			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					hospede.setId(rst.getInt(1));
				}
			}
		}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
