package controller;

import java.sql.Connection;

import dao.DiariaDAO;
import factory.ConnectionFactory;

public class DiariaController {

	private DiariaDAO diariaDao;

	public DiariaController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.diariaDao = new DiariaDAO(connection);
	}

	public double valorDiaria() {
		return diariaDao.pegarValorDiaria();

	}

}
