package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO extends DAO implements ISucursalDAO {
    private List<Sucursal> sucursales;
    private static SucursalDAO instance;

    private SucursalDAO() {
        this.sucursales = new ArrayList<>();
    }

    public synchronized static SucursalDAO getInstance() {
        if (instance == null) {
            instance = new SucursalDAO();
        }
        return instance;
    }

    @Override
    public void addSucursal(Sucursal sucursal) {
        try {
            conectar();
            String query = "INSERT INTO sucursales(nombre, id_banco)" +
                    "VALUES(?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, sucursal.getNombre());
            statement.setInt(2, sucursal.getBancoId());
            statement.executeUpdate();

            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSucursal(Integer nroSucursal) {
        try {
            conectar();

            String query = "DELETE FROM sucursales WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, nroSucursal);
            statement.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public List<Sucursal> listarSucursales() {
        try {
            conectar();
            String query = "SELECT * FROM sucursales";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            Sucursal sucursal;
            while (result.next()) {
                sucursal = new Sucursal();
                sucursal.setNombre(result.getString("nombre"));
                sucursal.setId(result.getInt("id"));
                sucursales.add(sucursal);
            }
            return sucursales;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return null;
    }


    @Override
    public Sucursal findSucursalByNroSucursal(Integer nroSucursal) {
        //TODO: completar
        return null;
    }
}
