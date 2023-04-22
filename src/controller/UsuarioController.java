package controller;

import java.sql.Connection;
import java.util.List;

import dao.UsuarioDAO;
import factory.ConnectionFactory;
import modelo.Usuario;

public class UsuarioController {

	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.usuarioDao = new UsuarioDAO(connection);
	}
	
	

	public List<Usuario> listar() {
		
		return this.usuarioDao.listar();
		
	}
	
	public List<Usuario> buscarNome(String nome){
		return this.usuarioDao.buscarNome(nome);
	}
	
	public Boolean autenticacaoUsario(String usuarioDigitado, String senhaDigitada) {
		System.out.println("Usuario autenticano!");
		
		return this.usuarioDao.autenticaUsario(usuarioDigitado, senhaDigitada);
		
	}
	
	


}
