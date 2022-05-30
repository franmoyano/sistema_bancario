package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CuentaServiceImpl implements ICuentaService {

	private CuentaDAO cuentaDao;

	public CuentaServiceImpl() {
		this.cuentaDao = CuentaDAO.getInstance();
	}

	@Override
	public void dashboardCuenta(Cliente cliente) {
		Scanner input = new Scanner(System.in);
		List<Cuenta> cuentas = listarCuentasDeCliente(cliente.getId());
		Cuenta cuenta = new Cuenta();
		Double dinero;
		int opcion;
		boolean salir = false;

		if(cuentas.size() == 0) {
			System.out.println("Usted no tiene ninguna cuenta. Se le ha generado una CAJA DE AHORRO");
			crearCuenta(cliente.getId());
		}
		cuentas = listarCuentasDeCliente(cliente.getId());
		cuenta = cuentas.get(0);

		do {
			try {

				System.out.print(
						"1) Consultar saldo" +
								"\n2) Depositar" +
								"\n3) Extraer" +
								"\n4) Transferir" +
								"\n5) Consultar datos de cuenta" +
								"\n6) Volver" +
								"\n\nOPCION: ");
				opcion = input.nextInt();
				switch (opcion) {
					case 1:
						//CONSULTAR SALDO
						int i = 1;
						for(Cuenta c : cuentas) {
							System.out.println("SALDO: $" + c.getSaldo());
							i++;
						}
						break;
					case 2:
						//DEPOSITAR
						System.out.print("\n¿Cuanto dinero desea ingresar?" +
								"\nMonto: ");
						dinero = input.nextDouble();
						cuenta.setSaldo(cuenta.getSaldo() + dinero);
						actualizarCuenta(cuenta);
						break;
					case 3:
						//EXTRAER
						System.out.print("\n¿Cuanto dinero desea extraer?" +
								"\nMonto: ");
						dinero = input.nextDouble();
						if(dinero > cuenta.getSaldo()) {
							System.out.println("¡No puede extraer mas que su saldo actual!");
						} else {
							cuenta.setSaldo(cuenta.getSaldo() - dinero);
							actualizarCuenta(cuenta);
						}
						break;
					case 4:
						System.out.print("\nTRANSFERIR" +
								"\nIngresa el cbu de la cuenta destino: ");
						String cbu = input.next();
						Cuenta cuenta2 = cuentaDao.findCuentaByCBU(cbu);

						//Verifico que no se transfiera a la misma cuenta
						if(!cbu.equals(cuenta.getCbu()) && cuenta2.getId() != null) {
							System.out.print("Ingrese el monto a transferir: ");
							dinero = input.nextDouble();
							if(dinero <= cuenta.getSaldo()) {
								cuenta.setSaldo(cuenta.getSaldo() - dinero);
								cuenta2.setSaldo(cuenta2.getSaldo() + dinero);
								cuentaDao.actualizarCuenta(cuenta);
								cuentaDao.actualizarCuenta(cuenta2);
								System.out.println("\nTRANSFERENCIA EXITOSA");
							} else {
								System.out.println("Debe ingresar un monto correcto!");
							}
						} else {
							System.out.println("El CBU no se encuentra registrado en ninguna cuenta existente");
						}
						break;
					case 5:
						//CONSULTAR DATOS DE CUENTA
						System.out.println("\nDATOS DE CUENTA" +
								"\nTitular: " + cliente.getNombreApellido().toUpperCase() +
								"\nCBU: " + cuenta.getCbu() +
								"\nSaldo: $" + cuenta.getSaldo() +
								"\nTipo cuenta: " + cuenta.getTipoCuenta());
						break;
					case 6:
						salir = true;
						System.out.println("SALIENDO...");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debe ingresar datos numericos, enteros o decimales (con coma)");
				input.next();
			}
		} while(!salir);
	}

	@Override
	public List<Cuenta> listarCuentasDeCliente(Integer id) {
		return cuentaDao.listarCuentasDeCliente(id);
	}

	@Override
	public Integer actualizarCuenta(Cuenta cuenta) {
		return cuentaDao.actualizarCuenta(cuenta);
	}

	@Override
	public void crearCuenta(Integer idCliente) {
		Scanner input = new Scanner(System.in);
		Cuenta cuenta = new Cuenta();
		cuenta.setClienteId(idCliente);
		cuenta.setTipoCuenta(TipoCuenta.CA.toString());
		cuentaDao.addCuenta(cuenta);
	}



}
