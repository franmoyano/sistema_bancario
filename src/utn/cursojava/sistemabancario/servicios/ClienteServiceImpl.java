package utn.cursojava.sistemabancario.servicios;

import java.util.List;
import java.util.Scanner;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.Sucursal;

public class ClienteServiceImpl implements IClienteService {

	private ClienteDAO clienteDao;
	private SucursalServiceImpl sucursalService = new SucursalServiceImpl();

	public ClienteServiceImpl() {
		this.clienteDao = ClienteDAO.getInstance();
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
	}

	@Override
	public void addCliente(Integer sucursalId) {
//		if(sucursalService.listarSucursales().size() == 0) {
//			System.out.println("\nPara ingresar clientes, debe crear al menos una sucursal." +
//					"\nUsted esta siendo redirigido...");
//			sucursalService.addSucursal();
//		}
		Scanner input = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("\n*** CREANDO CLIENTE ***");
		System.out.print("Nombre y apellido: ");
		cliente.setNombreApellido(input.nextLine());
		System.out.print("Cuil (SIN GUIONES NI ESPACIOS): ");
		cliente.setCuil(input.nextLine());
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


}
