package utn.cursojava.sistemabancario.dao;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteDAO {

	void addCliente(Cliente cliente);

	void deleteCliente(String cuil);

	List<Cliente> findClientes();

	Cliente findClienteById(Integer id);

	Cliente findClienteByCuil(String cuil);

	List<Cliente> listarClientesPorSucursal(Integer nroSucursal);

	List<Cuenta> listarCuentas();
}
