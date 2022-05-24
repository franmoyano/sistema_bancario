package utn.cursojava.sistemabancario.servicios;

import java.util.List;
import java.util.Scanner;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.dao.IClienteDAO;
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

	public void addCliente() {
		if(sucursalService.listarSucursales().size() == 0) {
			System.out.println("\nPara ingresar clientes, debe crear al menos una sucursal." +
					"\nUsted esta siendo redirigido...");
			sucursalService.addSucursal();
		}
		Scanner input = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("*** CREANDO CLIENTE ***");
		System.out.print("Nombre y apellido: ");
		cliente.setNombreApellido(input.nextLine());
		System.out.print("Cuil (SIN GUIONES NI ESPACIOS): ");
		cliente.setCuil(input.nextLine());
		System.out.print("Domicilio: ");
		cliente.setDomicilio(input.nextLine());
		System.out.print("Nro Sucursal: ");
		cliente.setSucursalId(input.nextInt());
		clienteDao.addCliente(cliente);
	}

	@Override
	public void deleteCliente(String cuil) {
		clienteDao.deleteCliente(cuil);
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteDao.listarClientes();
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
	public List<Cliente> findClients() {
		return clienteDao.listarClientes();
	}



}
