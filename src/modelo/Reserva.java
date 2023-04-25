package modelo;

import java.util.Date;

public class Reserva {
	
	private Integer id;
	private Date dataEntrada;
	private Date dataSaida;
	private Double valor;
	private String formaPagamento;
	
	
	public Reserva(Integer id, Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}



	public Reserva(Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}





	public Reserva() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public Date getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	

}
