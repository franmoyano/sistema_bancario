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
	}

	public synchronized static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	@Override
	public void addCliente(Cliente cliente) {
		try {
			conectar();
			String query = "INSERT INTO clientes (cuil, nombre_apellido, domicilio)" +
					"VALUES(?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, cliente.getCuil());
			statement.setString(2, cliente.getNombreApellido());
			statement.setString(3, cliente.getDomicilio());
			statement.executeUpdate();
			desconectar();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCliente(String cuil) {
		try {
			conectar();

			String query = "DELETE FROM clientes WHERE cuil = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, cuil);
			statement.executeUpdate();

			desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listarClientes() {
		try {
			String query = "SELECT nombre_apellido, cuil FROM clientes";
			//consultarBase(query);  TODO: crear metodo
			Cliente cliente = null;
			List<Cliente> clientes = new ArrayList<>();
			while (result.next()) {
				cliente = new Cliente();
				cliente.setNombreApellido(result.getString(1));
				cliente.setCuil(result.getString(2));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			desconectar();
		}
	}

	@Override
	public List<Cliente> listarClientesPorSucursal(Integer nroSucursal) {
		return null;
	}

	public List<Cuenta> listarCuentas() {
		return this.cuentas;
	}

}
