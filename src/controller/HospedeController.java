package controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

public class HospedeController {
	private HospedeDAO hospedeDao;
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.hospedeDao = new HospedeDAO(connection);
	}

	public void salvar(Hospede hospede) {
		this.hospedeDao.salvar(hospede);
		
	}

	public List<Hospede> buscar() {
		return this.hospedeDao.buscar();
	}

	public List<Hospede> buscarSobreNome(String sobreNome) {
		return this.hospedeDao.buscarSobreNome(sobreNome);
	}

	public void editar(String nome, String sobreNome, Date dataNascimento, String nacionalidade, String telefone, Integer id) {
		System.out.println("Editando dados do hospede");
		this.hospedeDao.editar(nome, sobreNome, dataNascimento, nacionalidade, telefone,id);		
	}

	public void deletar(Integer id) {
		System.out.println("Apagando dados do hospede!!");
		this.hospedeDao.deletar(id);
		
	}
	
	

}
