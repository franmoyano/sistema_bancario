package utn.cursojava.sistemabancario.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.Sucursal;

public class ClienteServiceImpl implements IClienteService {

	private ClienteDAO clienteDao;
	private SucursalServiceImpl sucursalService = new SucursalServiceImpl();
	private CuentaServiceImpl cuentaService = new CuentaServiceImpl();

	public ClienteServiceImpl() {
		this.clienteDao = ClienteDAO.getInstance();
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
	}

	@Override
	public void addCliente(Integer sucursalId) {
		Scanner input = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("\n*** CREANDO CLIENTE ***");
		System.out.print("Nombre y apellido: ");
		cliente.setNombreApellido(input.nextLine());
		System.out.print("Cuil (SIN GUIONES NI ESPACIOS): ");
		String cuil;
		do {
			cuil = input.nextLine();
			if(cuil.length() <= 10) {
				System.out.print("Ingrese un cuil valido: ");
			}
		} while (cuil.length() <= 10);

		cliente.setCuil(cuil);
		System.out.print("Domicilio: ");
		cliente.setDomicilio(input.nextLine());
		cliente.setSucursalId(sucursalId);
		clienteDao.addCliente(cliente);
	}

	@Override
	public void deleteCliente(String cuil) {
		clienteDao.deleteCliente(cuil);
	}

	@Override
	public List<Cliente> listarClientesPorSucursal(Integer nroSucursal) {
		return clienteDao.listarClientesPorSucursal(nroSucursal);
	}

	@Override
	public List<Cuenta> listarCuentas() {
		return clienteDao.listarCuentas();
	}

	@Override
	public List<Cliente> findClientes() {
		return clienteDao.findClientes();
	}

	@Override
	public Cliente findClienteById() {
		Scanner input = new Scanner(System.in);
		Integer id;
		System.out.print("\nIngrese el ID del cliente a seleccionar" +
				"\nID: ");
		id = input.nextInt();
		return clienteDao.findClienteById(id);
	}

	@Override
	public Cliente findClienteById(Integer id) {
		return clienteDao.findClienteById(id);
	}

	@Override
	public Cliente findClienteByCuil(String cuil) {
		return clienteDao.findClienteByCuil(cuil);
	}

	@Override
	public void dashboardCliente(Cliente cliente) {
		//TODO: mejorar metodo. Agregar funcionalidad para elegir cuenta en especifico
		Scanner input = new Scanner(System.in);
		List<Cuenta> cuentas = new ArrayList<>();
		Cuenta cuenta = new Cuenta();
		Double dinero;

		if(cuentaService.listarCuentasDeCliente(cliente.getId()).size() == 0) {
			System.out.println("Usted no tiene ninguna cuenta. Se le ha generado una CAJA DE AHORRO");
			cuentaService.crearCuenta(cliente.getId());
		}

		int opcion;
		boolean salir = false;
		cuentas = cuentaService.listarCuentasDeCliente(cliente.getId());
		cuenta = cuentas.get(0);


		System.out.println("\n**** BIENVENIDO, " +  cliente.getNombreApellido().toUpperCase() + " ****");
		//TODO: Pasar este menu a CuentaService
		do {
			try {

			System.out.print(
					"\n1) Consultar saldo" +
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
						System.out.println("CUENTA " + i
								+ " | "+ c.getTipoCuenta()
								+ " | SALDO: $" + c.getSaldo());
						i++;
					}
					break;
				case 2:
					//DEPOSITAR
					System.out.print("\n¿Cuanto dinero desea ingresar?" +
							"\nMonto: ");
					dinero = input.nextDouble();
					cuenta.setSaldo(cuenta.getSaldo() + dinero);
					cuentaService.actualizarCuenta(cuenta);
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
						cuentaService.actualizarCuenta(cuenta);
					}
					break;
				case 4:
					//TODO: TRANSFERIR
					break;
				case 5:
					//CONSULTAR DATOS DE CUENTA

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
}
