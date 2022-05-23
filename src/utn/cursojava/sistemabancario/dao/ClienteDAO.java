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
			String query = "INSERT INTO clientes (cuil, nombre_apellido, domicilio, id_sucursal)" +
					"VALUES(?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, cliente.getCuil());
			statement.setString(2, cliente.getNombreApellido());
			statement.setString(3, cliente.getDomicilio());
			statement.setInt(4, cliente.getSucursalId());
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
			conectar();
			String query = "SELECT nombre_apellido, cuil FROM clientes";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			Cliente cliente = null;
			clientes.clear();

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
	public List<Cliente> listarClientesPorSucursal(Integer idSucursal) {
		try {
			conectar();

			String query = "SELECT id, cuil, nombre_apellido, domicilio, id_sucursal FROM clientes WHERE id_sucursal = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, idSucursal);
			result = statement.executeQuery();
			Cliente cliente = null;
			clientes.clear();

			while (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setCuil(result.getString(2));
				cliente.setNombreApellido(result.getString(3));
				cliente.setDomicilio(result.getString(4));
				cliente.setSucursalId(result.getInt(5));
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

	public List<Cuenta> listarCuentas() {
		return this.cuentas;
	}

}
