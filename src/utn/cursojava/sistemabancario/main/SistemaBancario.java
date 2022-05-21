package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Sucursal;
import utn.cursojava.sistemabancario.servicios.ClienteServiceImpl;
import utn.cursojava.sistemabancario.servicios.CuentaServiceImpl;
import utn.cursojava.sistemabancario.servicios.IClienteService;
import utn.cursojava.sistemabancario.servicios.SucursalServiceImpl;

import java.util.List;

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

	public static void main(String[] args) {
		ClienteServiceImpl clienteService = new ClienteServiceImpl();
		CuentaServiceImpl cuentaService = new CuentaServiceImpl();
		SucursalServiceImpl sucursalService = new SucursalServiceImpl();

		System.out.println("Punto de inicio del Sistema Bancario");

//		LISTAR SUCURSALES: OK
//		List<Sucursal> sucursales = sucursalService.listarSucursales();
//		for(Sucursal sucursal : sucursales) {
//			System.out.println(sucursal.getNumSucursal() + ") " + sucursal.getNombre());
//		}

//		AGREGAR SUCURSAL: OK
//		sucursalService.addSucursal();
//
//		AGREGAR CLIENTE: OK
//		clienteService.addCliente();
//
//		ELIMINAR CLIENTE POR CUIL: OK
//		clienteService.deleteCliente("1341349134");

//		LISTAR CLIENTES: OK
		List<Cliente> clientes = clienteService.listarClientes();
		for(Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
}
