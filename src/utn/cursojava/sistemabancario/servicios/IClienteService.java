package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteService {

	void addCliente(Cliente cliente);

	void deleteCliente(String cuil);

	List<Cliente> listarClientes();
	
	List<Cliente> listarClientesPorSucursal(Integer nroSucursal);
	
	List<Cuenta> listarCuentas();

	List<Cliente> findClients();

}
