package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Hospede;

public class HospedeDAO {

	private Connection connection;

	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Hospede hospede) {
		try {
			String sql = "INSERT INTO HOSPEDES (NOME, SOBRENOME, DATANASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) VALUES (?, ?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, hospede.getNome());
				pstm.setString(2, hospede.getSobrenome());
				pstm.setDate(3, new java.sql.Date(hospede.getDataNascimento().getTime()));// convertendo um Date java
																							// para Date sql
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

	public List<Hospede> buscar() {
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			String sql = "SELECT id, nome, sobrenome, dataNascimento, nacionalidade, telefone, id_Reserva FROM HOSPEDES";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				trasformarResultSetEmHosprede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private void trasformarResultSetEmHosprede(List<Hospede> hospedes, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4),
						rst.getString(5), rst.getString(6), rst.getInt(7));
				hospedes.add(hospede);
			}
		}

	}

	public List<Hospede> buscarSobreNome(String sobreNome) {
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			String sql = "SELECT * FROM HOSPEDES WHERE SOBRENOME >= ? ";
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, sobreNome);
				pstm.execute();

				trasformarResultSetEmHosprede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void editar(String nome, String sobreNome, Date dataNascimento, String nacionalidade, String telefone,
			Integer id) {
		System.out.println("editando hospedes no banco de dados!!! no DAO");
		try (PreparedStatement pstm = connection.prepareStatement(
				"UPDATE hospedes h SET h.NOME = ?, h.SOBRENOME = ?, h.DATANASCIMENTO = ?, h.NACIONALIDADE = ?, h.TELEFONE = ? WHERE ID = ?")) {
			pstm.setString(1, nome);
			pstm.setString(2, sobreNome);
			pstm.setDate(3, (java.sql.Date) dataNascimento);
			pstm.setString(4, nacionalidade);
			pstm.setString(5, telefone);
			pstm.setInt(6, id);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Integer id) {
		try {
			try (PreparedStatement stm = connection.prepareStatement("DELETE FROM hospedes WHERE ID = ?")) {
				stm.setInt(1, id);
				stm.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
