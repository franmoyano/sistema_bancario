package utn.cursojava.sistemabancario.modelo;

public class Cuenta {
	private Integer id;
	private Double saldo;
	private String cbu;
	private Integer clienteId;
	private String tipoCuenta;
	private TipoMoneda tipoMoneda;

	// Constructor
	public Cuenta() {

		this.cbu = String.valueOf(Math.round(Math.random() * 100000000000000L));
	}

	public Cuenta(Integer id, Double saldo, String cbu, String tipoCuenta, TipoMoneda tipoMoneda, Integer clienteId) {
		this.id = id;
		this.saldo = saldo;
		this.cbu = cbu;
		this.tipoCuenta = tipoCuenta;
		this.tipoMoneda = tipoMoneda;
		this.clienteId = clienteId;
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

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
}
