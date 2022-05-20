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
		try {
			conectar();
			String query = "INSERT INTO clientes (cuil, nombre_apellido, domicilio)" +
					"VALUES(?, ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, "20429744335");
			statement.setString(2, "Luquitas Moyano");
			statement.setString(3, "Suter S/N");
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCliente(String cuil) {
		String query = "DELETE FROM clientes WHERE cuil = '" + cuil + "'";
		//crearModificarEliminar(query); TODO: crear metodo
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
