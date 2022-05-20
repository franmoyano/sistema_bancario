package utn.cursojava.sistemabancario.modelo;

public abstract class Persona {

	// Atributos
	protected String cuil;
	protected String nombreApellido;
	protected String telefono;
	protected String email;

	// Constructor
	public Persona(String cuil, String nombreApellido, String telefono, String email) {
		this.cuil = cuil;
		this.nombreApellido = nombreApellido;
		this.telefono = telefono;
		this.email = email;
	}

	public Persona() {

	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
