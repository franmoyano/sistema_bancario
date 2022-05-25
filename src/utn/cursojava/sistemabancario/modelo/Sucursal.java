package utn.cursojava.sistemabancario.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	private Integer id;
	private String nombre;
	private Integer bancoId;

	private List<Cliente> listaClientes;
	private List<Empleado> listaEmpleados;

	public Sucursal(String nombre, Integer id, Integer bancoId) {
		this.nombre = nombre;
		this.id = id;
		this.bancoId = bancoId;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaEmpleados = new ArrayList<Empleado>();
	}

	public Sucursal(){

	}

	// METODOS

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

	public Integer getBancoId() {
		return bancoId;
	}

	public void setBancoId(Integer bancoId) {
		this.bancoId = bancoId;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> clientes) {
		this.listaClientes = clientes;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Nombre: " + nombre;
	}
}
