package utn.cursojava.sistemabancario.dao;

import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.CajaDeAhorro;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;

public class ClienteDAO implements IClienteDAO {

	private List<Cliente> clientes;
	private List<Cuenta> cuentas;

	public ClienteDAO() {
		this.clientes = new ArrayList<>();
		this.cuentas = new ArrayList<>();

		Cuenta cajaDeAhorro = new CajaDeAhorro(TipoCuenta.CAJA_AHORRO.getNroCuenta(), Double.valueOf("0.0"),
				"10000000000000012423432423423", "P");
		cuentas.add(cajaDeAhorro);

		Cuenta cuentaCorriente = new CuentaCorriente(TipoCuenta.CUENTA_CORRIENTE.getNroCuenta(), Double.valueOf("0.0"),
				"10000000000000012423432423423");
		cuentas.add(cuentaCorriente);

	}

	@Override
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);

	}

	@Override
	public void deleteCliente(String cuil) {
		// TODO Auto-generated method stub

	}

	public List<Cliente> findClients() {
		return clientes;
	}

	public List<Cliente> findClientsBySucursal(Integer nroSucursal) { // nroSucursal:1
		List<Cliente> clientePorSucursal = new ArrayList<>();

		// SELECT * FROM CLIENTES where id_sucursal = 1
		for (Cliente cliente : clientes) {
			if (cliente.getSucursalId().equals(nroSucursal)) {
				clientePorSucursal.add(cliente);
			}

		}
		return clientePorSucursal;
	}

	public List<Cuenta> listarCuentas() {
		return this.cuentas;
	}

}
