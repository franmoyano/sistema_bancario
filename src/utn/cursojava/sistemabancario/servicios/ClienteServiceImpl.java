package utn.cursojava.sistemabancario.servicios;

import java.util.ArrayList;
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
		Scanner input = new Scanner(System.in);
		List<Cuenta> cuentas = new ArrayList<>();
		Cuenta cuenta = new Cuenta();

		if(cuentaService.listarCuentasDeCliente(cliente.getId()).size() == 0) {
			System.out.println("Usted no tiene ninguna cuenta. Se le ha generado una CAJA DE AHORRO");
			cuentaService.crearCuenta(cliente.getId());
		}

		System.out.println("\n**** BIENVENIDO, " +  cliente.getNombreApellido().toUpperCase() + " ****" +
				"\n1) Consultar saldo" +
				"\n2) Depositar" +
				"\n3) Extraer" +
				"\n4) Transferir" +
				"\n5) Volver" +
				"\n\nOPCION: ");
		int opcion = input.nextInt();
		switch (opcion) {
			case 1:
				//TODO: CONSULTAR SALDO
				break;
			case 2:
				//TODO: DEPOSITAR
				break;
			case 3:
				//TODO: EXTRAER
				break;
			case 4:
				//TODO: TRANSFERIR
		}
	}
}
