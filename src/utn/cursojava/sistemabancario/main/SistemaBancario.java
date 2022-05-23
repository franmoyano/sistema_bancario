package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.servicios.ClienteServiceImpl;
import utn.cursojava.sistemabancario.servicios.CuentaServiceImpl;
import utn.cursojava.sistemabancario.servicios.SucursalServiceImpl;

import java.util.List;
import java.util.Scanner;

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
		Scanner input = new Scanner(System.in);
		Integer opcion = input.nextInt();
		menu(opcion);
	}

	static void menu(Integer opcion) {
		switch (opcion) {
			case 1:
				clienteService.addCliente();
				break;
			case 2:
				break;
			case 3:
				clienteService.listarClientes();
				List<Cliente> c1 = clienteService.listarClientes();
				for(Cliente c : c1) {
					System.out.println(c.getNombreApellido());
				}
				break;
			case 4:
				List<Cliente> c2 = clienteService.listarClientesPorSucursal(5);
				for(Cliente c : c2) {
					System.out.println(c.getNombreApellido());
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				sucursalService.deleteSucursal(5);
				break;
			case 10:
				sucursalService.addSucursal();
				break;
		}
	}
}
