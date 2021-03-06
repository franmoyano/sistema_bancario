package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO extends DAO implements ICuentaDAO {
    private List<Cuenta> cuentas;
    private static CuentaDAO instance;

    private CuentaDAO() {
        this.cuentas = new ArrayList<>();
    }

    public synchronized static CuentaDAO getInstance() {
        if (instance == null) {
            instance = new CuentaDAO();
        }
        return instance;
    }

    @Override
    public Cuenta findCuentaByCBU(String cbu) {
        try {
            conectar();
            String query = "SELECT * FROM cuentas WHERE cbu = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, cbu);
            result = statement.executeQuery();
            Cuenta cuenta = new Cuenta();
            if(result.next()) {
                cuenta.setCbu(result.getString("cbu"));
                cuenta.setTipoCuenta(result.getString("tipo_cuenta"));
                cuenta.setClienteId(result.getInt("id_cliente"));
                cuenta.setSaldo(result.getDouble("saldo"));
                cuenta.setId(result.getInt("id"));
            }
            return cuenta;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
    }

    @Override
    public Integer actualizarCuenta(Cuenta cuenta) {
        try {
            conectar();
            String query = "UPDATE cuentas SET saldo = ? WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setDouble(1, cuenta.getSaldo());
            statement.setInt(2, cuenta.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
    }

    @Override
    public void addCuenta(Cuenta cuenta) {
        try {
            conectar();
            String query = "INSERT INTO cuentas(cbu, saldo, id_cliente, tipo_cuenta, tipo_moneda) VALUES(?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, cuenta.getCbu());
            statement.setDouble(2, 0.0);
            statement.setInt(3, cuenta.getClienteId());
            statement.setString(4, cuenta.getTipoCuenta());
            statement.setString(5, cuenta.getTipoMoneda());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteCuenta(Cuenta cuenta) {
        try {
            conectar();
            String query = "DELETE FROM cuentas WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, cuenta.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public List<Cuenta> listarCuentasDeCliente(Integer idCliente) {
        try {
            conectar();
            String query = "SELECT * FROM cuentas WHERE id_cliente = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idCliente);
            result = statement.executeQuery();
            List<Cuenta> cuentas = new ArrayList<>();
            Cuenta cuenta;
            while(result.next()) {
                cuenta = new Cuenta();
                cuenta.setId(result.getInt("id"));
                cuenta.setSaldo(result.getDouble("saldo"));
                cuenta.setCbu(result.getString("cbu"));
                cuenta.setTipoCuenta(result.getString("tipo_cuenta"));
                cuenta.setTipoMoneda(result.getString("tipo_moneda"));
                cuentas.add(cuenta);
            }
            return cuentas;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
    }
}
