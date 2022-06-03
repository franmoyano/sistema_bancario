package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

/**
 * Interfaz con metodos para implementar en ClienteServiceImpl
 */
public interface IClienteService {

	/**
	 * @param cliente cliente ya modelado
	 */
	void addCliente(Cliente cliente);

	/**
	 * Agrega un cliente con las validaciones pertinentes
	 * @param sucursalId
	 */
	void addCliente(Integer sucursalId);

	/**
	 * Elimina cliente por cuil
	 * @param cuil
	 */
	void deleteCliente(String cuil);

	/**
	 * @param nroSucursal numero de sucursal en la cual buscar los clientes
	 * @return lista de clientes segmentados por sucursal
	 */
	List<Cliente> listarClientesPorSucursal(Integer nroSucursal);

	/**
	 * @return todos los clientes registrados
	 */
	List<Cliente> findClientes();

	/**
	 * Busca cliente por id. Los datos se solicitan en este metodo.
	 * @return cliente por id
	 */
	Cliente findClienteById();

	/**
	 * @param id id del cliente a buscar
	 * @return cliente por id
	 */
	Cliente findClienteById(Integer id);

	/**
	 * @param cuil cuil del cliente a buscar
	 * @return cliente por cuil
	 */
	Cliente findClienteByCuil(String cuil);

	/**
	 * Menu de opciones del cliente especifico
	 * @param cliente
	 */
	void dashboardCliente(Cliente cliente);

}
