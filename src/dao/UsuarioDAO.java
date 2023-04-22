package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;
	private String usuarioRecebido;
	private String senhaRecebida;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Usuario> listar(){

			try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "SELECT id, nome, senha FROM USUARIOS";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				trasformarResultSetEmUsuario(usuarios, pstm);
			}
			return usuarios;
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	public List<Usuario> buscarNome(String nome) {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "SELECT NOME, SENHA FROM USUARIOS WHERE NOME = ?";
	
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, "nome");
				pstm.execute();
	
				trasformarResultSetEmUsuario(usuarios, pstm);
			}
			System.out.println(usuarios.toString());
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void trasformarResultSetEmUsuario(List<Usuario> usuarios, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Usuario usuario = new Usuario(rst.getInt(1), rst.getString(2), rst.getString(2));
				usuarios.add(usuario);
			}
		}
		
	}

	public Boolean autenticaUsario(String nomeDigitada, String senhaDigitada) {
		System.out.println("Usuario digitado: " + nomeDigitada + " , Senha digitada: "+ senhaDigitada);
		List<Usuario> usuarios = listar();
		for (Usuario usuario : usuarios) {
			
			usuarioRecebido = usuario.getNome();
			
			senhaRecebida = usuario.getSenha();
		}
	
		
		if(usuarioRecebido.equals(nomeDigitada)  && senhaRecebida.equals(senhaDigitada)) {
			return true;
		}else {
			return true;
		}
		
	}
}


