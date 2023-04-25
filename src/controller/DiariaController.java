package controller;

import java.sql.Connection;

import dao.DiariaDao;
import factory.ConnectionFactory;

public class DiariaController {

	private DiariaDao diariaDao;

	public DiariaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.diariaDao = new DiariaDao(connection);
	}

	public double valorDiaria() {
		return diariaDao.pegarValorDiaria();

	}

}
