package utn.cursojava.sistemabancario.modelo;

import utn.cursojava.sistemabancario.constants.TipoCuenta;

import java.util.UUID;

public class Cuenta {
	private Integer id;
	private Double saldo;
	private String cbu;
	private TipoCuenta tipoCuenta;
	private TipoMoneda tipoMoneda;

	// Constructor
	public Cuenta() {

		this.cbu = String.valueOf(Math.round(Math.random() * 100000000000000L));
	}

	public Cuenta(Integer id, Double saldo, String cbu, TipoCuenta tipoCuenta, TipoMoneda tipoMoneda) {
		this.id = id;
		this.saldo = saldo;
		this.cbu = cbu;
		this.tipoCuenta = tipoCuenta;
		this.tipoMoneda = tipoMoneda;
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

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
}
