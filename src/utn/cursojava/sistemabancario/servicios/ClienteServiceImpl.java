package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;
import java.util.Scanner;

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
		System.out.print("Cuil (sin guiones): ");
		String cuil;
		boolean salir;
		do {
			salir = true;
			cuil = input.nextLine();
			if(cuil.length() != 11 || !cuil.matches("[0-9]+")) {
				System.out.print("Ingrese un cuil valido: ");
				salir = false;
			}
		} while (!salir);

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
		System.out.println("\n**** BIENVENIDO, " +  cliente.getNombreApellido().toUpperCase() + " ****");
		cuentaService.dashboardCuenta(cliente);
	}
}
