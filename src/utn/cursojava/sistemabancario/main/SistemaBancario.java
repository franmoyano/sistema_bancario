package utn.cursojava.sistemabancario.main;

import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;
import utn.cursojava.sistemabancario.servicios.ClienteServiceImpl;
import utn.cursojava.sistemabancario.servicios.IClienteService;

/**
 * Tomando como punto de partida el diagrama de Clases del sistema de Gestión
 * Bancaria construya una aplicación que permita realizar las siguientes
 * operaciones:
 * 
 * 
 * **********MENU PRINCIPAL********** <br>
 * 1) Agregar Cliente<br>
 * 2) Agregar cuenta a Cliente<br>
 * 3) Listar Clientes por sucursal<br>
 * 4) Listar Clientes de una sucursal<br>
 * 5) Extraer dinero<br>
 * 6) Consultar Saldo<br>
 * 7) Realizar Deposito<br>
 * 8) Realizar transferencias<br>
 * 9) Eliminar una sucursal<br>
 * 
 * @author Benjamin Silvestre
 *
 */
public class SistemaBancario {

	// private IClienteService clienteService;

	public static void main(String[] args) {
		IClienteService clienteService = new ClienteServiceImpl();

		System.out.println("Punto de inicio del Sistema Bancario");
		// TODO: Dar de alta una caja de ahorro
		Cuenta cuenta = clienteService.crearCuenta(TipoCuenta.CAJA_AHORRO);

		List<Cuenta> cuentas = new ArrayList<>();

		Cliente cliente = new Cliente("42974433", "Franco Moyano", "11-1512-4578", "francocortina@gmail.com",
				"La Plata", cuentas, null);

		CuentaCorriente cuentaCorriente = new CuentaCorriente(null, null, null);
		cliente.getCuentas().add(cuentaCorriente);

		clienteService.addCliente(cliente);

		List<Cliente> clientes = clienteService.findClients();

		System.out.println("\nNombre y Apellido | DNI \n");
		for (Cliente cliente2 : clientes) {
			System.out.println(cliente2.getNombreApellido() + " " + cliente2.getDni());
			System.out.println("");
		}
	}

}
