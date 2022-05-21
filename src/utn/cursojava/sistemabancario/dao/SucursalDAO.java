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
            String query = "INSERT INTO sucursales(nombre)" +
                    "VALUES(?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, sucursal.getNombre());
            statement.executeUpdate();

            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSucursal(Integer nroSucursal) {
        //TODO: completar
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
                sucursal.setNumSucursal(result.getInt("id"));
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
