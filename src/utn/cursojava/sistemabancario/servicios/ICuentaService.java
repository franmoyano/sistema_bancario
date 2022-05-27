package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;

public interface ICuentaService {

	void crearCuenta(Integer idCliente);

	Double extraer(Double monto);

	void depositar(Double monto);

	List<Cuenta> listarCuentasDeCliente(Integer id);
}
