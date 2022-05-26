package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteService {

	void addCliente(Cliente cliente);

	void addCliente(Integer sucursalId);

	void deleteCliente(String cuil);
	
	List<Cliente> listarClientesPorSucursal(Integer nroSucursal);
	
	List<Cuenta> listarCuentas();

	List<Cliente> findClientes();

	Cliente findClienteById();

	Cliente findClienteById(Integer id);

	void dashboardCliente(Cliente cliente);

}
