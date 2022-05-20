package utn.cursojava.sistemabancario.dao;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteDAO {

	void addCliente(Cliente cliente);

	void deleteCliente(String cuil);

	List<Cliente> findClients();

	List<Cliente> findClientsBySucursal(Integer nroSucursal);

	List<Cuenta> listarCuentas();
}
