package utn.cursojava.sistemabancario.dao;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

/**
 * A implementar en {@link ClienteDAO}
 */
public interface IClienteDAO {

	/**
	 * Agregar cliente
	 * @param cliente
	 */
	void addCliente(Cliente cliente);

	/**
	 * Eliminar cliente por cuil
	 * @param cuil
	 */
	void deleteCliente(String cuil);

	/**
	 * Listar todos los clientes
	 * @return
	 */
	List<Cliente> findClientes();

	/**
	 * Encontrar cliente por id
	 * @param id
	 * @return cliente
	 */
	Cliente findClienteById(Integer id);

	/**
	 * Encontrar cliente por cuil
	 * @param cuil
	 * @return cliente
	 */
	Cliente findClienteByCuil(String cuil);

	/**
	 * Listar clientes por numero de sucursal
	 * @param nroSucursal
	 * @return lista de clientes
	 */
	List<Cliente> listarClientesPorSucursal(Integer nroSucursal);
}
