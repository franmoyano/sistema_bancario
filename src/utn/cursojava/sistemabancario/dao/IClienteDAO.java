package utn.cursojava.sistemabancario.dao;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteDAO {

	public void addCliente(Cliente cliente);

	public void deleteCliente(String cuil);

	public List<Cliente> findClients();

	public List<Cliente> findClientsBySucursal(Integer nroSucursal);

	public List<Cuenta> listarCuentas();
}
