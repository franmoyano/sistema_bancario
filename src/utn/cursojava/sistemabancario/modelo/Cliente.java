package utn.cursojava.sistemabancario.modelo;

import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
	// ATRIBUTOS
	private String domicilio;
	private Date altaCliente;
	// private Sucursal sucursal;
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

	@Override
	public String toString() {
		return getNombreApellido() + " | " + getDomicilio();
	}

}
