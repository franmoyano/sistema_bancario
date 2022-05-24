package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaService {

	void crearCuenta();

	Double extraer(Double monto);

	void depositar(Double monto);
}
