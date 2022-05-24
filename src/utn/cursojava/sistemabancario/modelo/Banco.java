package utn.cursojava.sistemabancario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	// Atributos
	private Integer id;
	private String nombre;
	private List<Sucursal> sucursales;
	private List<Cuenta> cuentas;

	public Banco(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sucursales = new ArrayList<>();
		this.cuentas = new ArrayList<>();
	}

	public Banco() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	

}
