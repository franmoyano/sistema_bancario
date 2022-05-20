package utn.cursojava.sistemabancario.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;
import utn.cursojava.sistemabancario.servicios.ClienteServiceImpl;
import utn.cursojava.sistemabancario.servicios.CuentaServiceImpl;
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
		ClienteServiceImpl clienteService = new ClienteServiceImpl();
		CuentaServiceImpl cuentaService = new CuentaServiceImpl();


		System.out.println("Punto de inicio del Sistema Bancario");
		// TODO: Dar de alta una caja de ahorro
		Cuenta cuenta = cuentaService.crearCuenta(TipoCuenta.CAJA_AHORRO);

		List<Cuenta> cuentas = new ArrayList<>();


		//BLOQUE PARA INGRESAR USUARIO MANUALMENTE
//		Scanner input = new Scanner(System.in);
//		System.out.print("Ingrese los datos del nuevo cliente" +
//				"\nNombre y apellido: ");
//		String nombreApellido = input.nextLine();
//		System.out.print("DNI: ");
//		String dni = input.nextLine();
//
//		Cliente cliente = new Cliente(dni, nombreApellido, "11-1512-4578", "francocortina@gmail.com",
//				"San Rafael", cuentas, null);
//
//		CuentaCorriente cuentaCorriente = new CuentaCorriente(null, null, null);
//		cliente.getCuentas().add(cuentaCorriente);
//
//		clienteService.addCliente(cliente);

		List<Cliente> clientes = clienteService.findClients();

		//clienteService.deleteCliente("42974433");
		System.out.println("\nNombre y Apellido\t\t\tDNI");
		for (Cliente cliente2 : clientes) {
			System.out.println(cliente2.getNombreApellido() + "\t\t\t" + cliente2.getCuil());
		}
	}

}
