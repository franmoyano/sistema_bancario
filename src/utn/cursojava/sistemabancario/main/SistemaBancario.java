package utn.cursojava.sistemabancario.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.constants.TipoMoneda;
import utn.cursojava.sistemabancario.exceptions.MenorACeroException;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;
import utn.cursojava.sistemabancario.servicios.ClienteServiceImpl;
import utn.cursojava.sistemabancario.servicios.CuentaServiceImpl;
import utn.cursojava.sistemabancario.servicios.IClienteService;
import utn.cursojava.sistemabancario.servicios.SucursalServiceImpl;

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

	static ClienteServiceImpl clienteService = new ClienteServiceImpl();
	static CuentaServiceImpl cuentaService = new CuentaServiceImpl();
	static SucursalServiceImpl sucursalService = new SucursalServiceImpl();

	public static void main(String[] args) {
		System.out.println(clienteService.hashCode());
		System.out.println("\n**** SISTEMA BANCARIO ****" +
				"\n1) Agregar cliente" +
				"\n2) Agregar cuenta a cliente" +
				"\n3) Listar todos los clientes" +
				"\n4) Listar clientes de una sucursal" +
				"\n5) Extraer dinero" +
				"\n6) Consultar saldo" +
				"\n7) Depositar" +
				"\n8) Realizar transferencia" +
				"\n9) Eliminar una sucursal");
		Scanner input = new Scanner(System.in);
		int opcion;
		boolean salir = false;
		do {
			try {
				System.out.print("\nOPCION: ");
				opcion = input.nextInt();
				if(opcion <= 0) {
					throw new MenorACeroException();
				}
				salir = true;
				menu(opcion);
			} catch (InputMismatchException e) {
				System.out.println("¡¡Debe ingresar una opción numérica!!");
				input.next();
			} catch (MenorACeroException e) {
				System.out.println(e.getMessage());
			}
		} while(!salir);



		//clienteService.deleteCliente("1341349134");
	}


	/**
	 *
	 * @param opcion
	 * Todos los metodos implementados deben modularizarse aun mas. Version en desarrollo
	 */
	public static void menu(int opcion) {
		switch (opcion) {
			case 1:
				clienteService.addCliente();
				break;
			case 2:

				break;
			case 3:
				List<Cliente> clientes = clienteService.listarClientes();
				for(Cliente cl : clientes) {
					System.out.println(cl.getNombreApellido());
				}
				break;
			case 4:
				List<Cliente> clientes2 = clienteService.listarClientesPorSucursal(2);
				for(Cliente cl : clientes2) {
					System.out.println(cl.getNombreApellido());
				}
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 9:
				sucursalService.deleteSucursal(7);
				break;
			case 10:
				sucursalService.addSucursal();
				break;
		}
	}
}
