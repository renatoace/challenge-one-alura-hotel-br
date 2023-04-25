package controller;

import java.sql.Connection;

import dao.ReservaDao;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaController {
	
	private ReservaDao reservaDao;
	
	public ReservaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDao = new ReservaDao(connection);
	}

	public void salvar(Reserva reserva) {
		this.reservaDao.salvar(reserva);
		
	}

	

}
