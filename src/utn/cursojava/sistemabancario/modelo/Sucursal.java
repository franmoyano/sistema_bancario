package utn.cursojava.sistemabancario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	// Atributos
	private String nombre;
	private Integer numSucursal;

	private List<Cliente> listaClientes;
	private List<Empleado> listaEmpleados;

	public Sucursal(String nombre, Integer numSucursal) {
		this.nombre = nombre;
		this.numSucursal = numSucursal;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaEmpleados = new ArrayList<Empleado>();
	}

	// METODOS

	public String getNombre() {
		return nombre;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void setNumSucursal(Integer numSucursal) {
		this.numSucursal = numSucursal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumSucursal() {
		return numSucursal;
	}

	public void setNumSucursal(int numSucursal) {
		this.numSucursal = numSucursal;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> clientes) {
		this.listaClientes = clientes;
	}

}
