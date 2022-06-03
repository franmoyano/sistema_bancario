package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;

public interface ICuentaService {

	/**
	 * Menu de cuenta
	 * @param cliente
	 */
	void dashboardCuenta(Cliente cliente);

	/**
	 * Actualiza cuenta (sirve tanto para deposito, transferencia y extraccion)
	 * @param cuenta
	 * @return
	 */
	Integer actualizarCuenta(Cuenta cuenta);

	/**
	 * Crea cuenta recibiendo el id del cliente propietario de la misma
	 * @param idCliente
	 */
	void crearCuenta(Integer idCliente);

	/**
	 * @param id
	 * @return cuentas de cliente especifico
	 */
	List<Cuenta> listarCuentasDeCliente(Integer id);
}
