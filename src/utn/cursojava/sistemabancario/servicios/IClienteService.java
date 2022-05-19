package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteService {

	public void addCliente(Cliente cliente);

	void deleteCliente(String cuil);

	public List<Cliente> listarClientes();
	
	public List<Cliente> listarClientes(Integer nroSucursal);
	
	public List<Cuenta> listarCuentas();

	public List<Cliente> findClients();
	
	public Cuenta crearCuenta (TipoCuenta tipoCuenta) ;

}
