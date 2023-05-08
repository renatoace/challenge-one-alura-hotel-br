package controller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservasController {
	
	private ReservaDAO reservaDao;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDao = new ReservaDAO(connection);
	}

	public void salvar(Reserva reserva) {
		this.reservaDao.salvar(reserva);
		
	}
	
	public List<Reserva> busca(){
		return this.reservaDao.buscar();	
	}

	public List<Reserva> buscaNumero(Integer id) {
		System.out.println("Passei por aqui no controller reserva "+id);
		return this.reservaDao.buscaNumero(id);
	}

	public void editar(Date dataEntrada, Date dataSaida, Double valor, String formaPagamento, Integer id) {
		System.out.println("Editadando reserva!");
		this.reservaDao.editar(dataEntrada, dataSaida, valor, formaPagamento, id);
		
	}

	public void deletar(Integer id) {
		System.out.println("Deletando a reserva de número: "+id);
		this.reservaDao.deletar(id);
		
	}

	

}
