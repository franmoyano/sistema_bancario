package utn.cursojava.sistemabancario.servicios;

public interface ICuentaService {
	public Double extraer(Double monto);

	public void depositar(Double monto);
}
