package utn.cursojava.sistemabancario.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.modelo.CajaDeAhorro;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;

public class ClienteDAO extends DAO implements IClienteDAO {

	private List<Cliente> clientes;
	private List<Cuenta> cuentas;

	private static ClienteDAO instance;

	private ClienteDAO() {
		this.clientes = new ArrayList<>();
		this.cuentas = new ArrayList<>();

		Cuenta cajaDeAhorro = new CajaDeAhorro(TipoCuenta.CAJA_AHORRO.getNroCuenta(), Double.valueOf("0.0"),
				"10000000000000012423432423423", "P");
		cuentas.add(cajaDeAhorro);

		Cuenta cuentaCorriente = new CuentaCorriente(TipoCuenta.CUENTA_CORRIENTE.getNroCuenta(), Double.valueOf("0.0"),
				"10000000000000012423432423423");
		cuentas.add(cuentaCorriente);

	}

	public synchronized static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	@Override
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);

		String query = "INSERT INTO clientes (cuil, nombre_apellido)" +
				"VALUES('" + cliente.getDni() + "', '" + cliente.getNombreApellido() + "');";

		crearModificarEliminar(query);
	}

	@Override
	public void deleteCliente(String cuil) {
		String query = "DELETE FROM clientes WHERE cuil = '" + cuil + "'";
		crearModificarEliminar(query);
	}

	public List<Cliente> findClients() {
		try {
			String query = "SELECT nombre_apellido, cuil FROM clientes";
			consultarBase(query);
			Cliente cliente = null;
			List<Cliente> clientes = new ArrayList<>();
			while (result.next()) {
				cliente = new Cliente();
				cliente.setNombreApellido(result.getString(1));
				cliente.setDni(result.getString(2));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
