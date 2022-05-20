package utn.cursojava.sistemabancario.modelo;

public abstract class Cuenta {
	protected Integer id;
	protected Double saldo;
	protected String cbu;

	// Constructor
	public Cuenta() {
	}

	public Cuenta(Integer id, Double saldo, String cbu) {
		this.id = id;
		this.saldo = saldo;
		this.cbu = cbu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

}
