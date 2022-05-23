package utn.cursojava.sistemabancario.modelo;

import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
	// ATRIBUTOS
	private Integer id;
	private String domicilio;
	private Date altaCliente;
	private Integer sucursalId;
	private List<Cuenta> cuentas;

	public Cliente(String dni, String nombreApellido, String telefono, String email, String domicilio,
			List<Cuenta> cuentas, Date altaCliente) {
		super(dni, nombreApellido, telefono, email);
		this.domicilio = domicilio;
		this.cuentas = cuentas;
		this.altaCliente = altaCliente;
	}

	public Cliente() {
		super();
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Date getAltaCliente() {
		return altaCliente;
	}

	public void setAltaCliente(Date altaCliente) {
		this.altaCliente = altaCliente;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + getId() + " | Nombre: " + getNombreApellido() + " | Domicilio: " + getDomicilio() + "";
	}

}
