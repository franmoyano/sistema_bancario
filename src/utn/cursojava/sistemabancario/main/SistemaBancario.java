package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.servicios.MainService;

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
		MainService.optionSelector();
	}

}
