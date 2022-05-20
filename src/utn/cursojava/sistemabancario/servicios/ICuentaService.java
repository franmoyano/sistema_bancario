package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaService {

	Cuenta crearCuenta(TipoCuenta tipoCuenta);

	Double extraer(Double monto);

	void depositar(Double monto);
}
