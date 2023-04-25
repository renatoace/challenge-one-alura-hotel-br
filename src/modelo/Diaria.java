package modelo;

public class Diaria {
	
	private Integer id;
	private Double valorDiaria;
	
	
	public Diaria(Integer id, Double valorDiaria) {
		
		this.id = id;
		this.valorDiaria = valorDiaria;
	}


	public Diaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getValorDiaria() {
		return valorDiaria;
	}


	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
		

}
