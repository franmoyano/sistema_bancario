package utn.cursojava.sistemabancario.dao;

import java.sql.*;
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
	}

	@Override
	public void deleteCliente(String cuil) {
		// TODO: eliminar cliente por cuil

	}

	public List<Cliente> findClients() {
		String url = "jdbc:mysql://localhost:3306/sistema_bancario";
		String userName = "root";
		String password = "root";

		Connection con;
		try {
			// 1) Register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2) Create the connection object
			con = DriverManager.getConnection(url, userName, password);

			// 3) Create the Statement object
			Statement stmt = con.createStatement();

			// 4) Ejecución de Query
			ResultSet rs = stmt.executeQuery("select NRO_CLIENTE, CUIL, NOMBRE_APELLIDO from CLIENTES");

			Cliente cliente;
			while (rs.next()) {
				cliente = new Cliente();
				Integer nroCliente = rs.getInt(1);
				cliente.setDni(rs.getString(2));// xx-xxxxxxxx-x, TODO: seteear cuil con formato esperado por el objeto
				// cliente
				cliente.setNombreApellido(rs.getString(3));

				clientes.add(cliente);
			}

			// 5) Cerrar la conexion
			con.close();
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			System.out.println(e);
		} finally {

		}

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
