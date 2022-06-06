package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.servicios.MainService;

/**
 * <h1>Sistema Bancario</h1>
 * <h3>Funcionalidades:</h3>
 * <ul>
 *     <li>Creacion de banco</li>
 *     <li>Creacion de sucursales</li>
 *     <li>Creacion de cliente, con sus respectivas cuentas</li>
 * </ul>
 * @author Franco Moyano
 * @version 2.3 05/06/2022
 */
public class SistemaBancario {

	public static void main(String[] args) {
		MainService.optionSelector();
	}

}
