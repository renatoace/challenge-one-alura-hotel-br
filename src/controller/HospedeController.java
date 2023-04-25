package controller;

import java.sql.Connection;

import dao.HospedeDao;
import factory.ConnectionFactory;
import modelo.Hostepe;

public class HospedeController {
	private HospedeDao hospedeDao;
	
	public HospedeController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.hospedeDao = new HospedeDao(connection);
	}

	public void salvar(Hostepe hospede) {
		this.hospedeDao.salvar(hospede);
		
	}

}
