package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;

public interface ICuentaService {

	void dashboardCuenta(Cliente cliente);

	Integer actualizarCuenta(Cuenta cuenta);

	void crearCuenta(Integer idCliente);

	List<Cuenta> listarCuentasDeCliente(Integer id);
}
