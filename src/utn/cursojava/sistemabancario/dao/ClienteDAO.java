package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("\nCLIENTE AGREGADO CON EXITO");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			desconectar();
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

	public List<Cliente> findClientes() {
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
	public Cliente findClienteById(Integer id) {
		try {
			conectar();
			String query = "SELECT * FROM clientes WHERE id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			Cliente cliente = new Cliente();
			while (result.next()) {
				cliente.setId(result.getInt("id"));
				cliente.setNombreApellido(result.getString("nombre_apellido"));
				cliente.setCuil(result.getString("cuil"));
				cliente.setDomicilio(result.getString("domicilio"));
				cliente.setSucursalId(result.getInt("id_sucursal"));
			}
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			desconectar();
		}
	}

	@Override
	public Cliente findClienteByCuil(String cuil) {
		try {
			conectar();
			String query = "SELECT * FROM clientes WHERE cuil = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, cuil);
			result = statement.executeQuery();
			Cliente cliente = new Cliente();
			while(result.next()) {
				cliente.setCuil(result.getString("cuil"));
				cliente.setId(result.getInt("id"));
				cliente.setNombreApellido(result.getString("nombre_apellido"));
				cliente.setSucursalId(result.getInt("id_sucursal"));
			}

			return cliente;
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
}
