package utn.cursojava.sistemabancario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	// Atributos
	private Integer id;
	private String nombre;

	private List<Cliente> listaClientes;
	private List<Empleado> listaEmpleados;

	public Sucursal(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaEmpleados = new ArrayList<Empleado>();
	}

	public Sucursal() {

	}

	// METODOS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> clientes) {
		this.listaClientes = clientes;
	}

}
