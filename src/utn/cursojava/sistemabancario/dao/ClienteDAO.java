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
		clientes = new ArrayList<>();
		cuentas = new ArrayList<>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
		}
	}

	public List<Cliente> listarClientes() {
		try {
			conectar();
			String query = "SELECT * FROM clientes";
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			Cliente cliente;
			clientes.clear();
			while (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNombreApellido(result.getString("nombre_apellido"));
				cliente.setCuil(result.getString("cuil"));
				cliente.setDomicilio(result.getString("domicilio"));
				cliente.setSucursalId(result.getInt("id_sucursal"));
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
		try {
			conectar();
			String query = "SELECT * FROM clientes WHERE id_sucursal = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, nroSucursal);
			result = statement.executeQuery();
			Cliente cliente;
			clientes.clear();
			while (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt("id"));
				cliente.setNombreApellido(result.getString("nombre_apellido"));
				cliente.setCuil(result.getString("cuil"));
				cliente.setDomicilio(result.getString("domicilio"));
				cliente.setSucursalId(result.getInt("id_sucursal"));
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
