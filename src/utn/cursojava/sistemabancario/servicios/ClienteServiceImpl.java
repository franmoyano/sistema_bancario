package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.dao.IClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public class ClienteServiceImpl implements IClienteService {

	private IClienteDAO clienteDao;

	public ClienteServiceImpl() {
		this.clienteDao = ClienteDAO.getInstance();
	}

	@Override
	public void addCliente(Cliente cliente) {
//		if (validarEmail(cliente.getEmail())) {
//			clienteDao.addCliente(cliente);
//		}

		clienteDao.addCliente(cliente);
	}

	public void deleteCiente(String cuil) {
		clienteDao.deleteCliente(cuil);
	}

	// 31/03/1989
	public void validarFechaNacimiento(String fechaNacimiento) {
		// TODO: Validar que la edad sea mayor a 18 años

	}

	public Boolean validarEmail(String email) {
		// TODO: Validar que el email tenga un formato adecuado

		return Boolean.TRUE;
	}


	public List<Cliente> listarClientes(Integer nroSucursal) {
		return clienteDao.findClientsBySucursal(nroSucursal);
	}

	public List<Cliente> listarClientes() {
		return clienteDao.findClients();
	}

	@Override
	public List<Cuenta> listarCuentas() {
		return clienteDao.listarCuentas();
	}

	@Override
	public List<Cliente> findClients() {
		return clienteDao.findClients();
	}

	public Cuenta crearCuenta(TipoCuenta tipoCuenta) {
		return null;

	}

}
