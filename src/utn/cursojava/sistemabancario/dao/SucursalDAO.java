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

            String query = "INSERT INTO sucursales(nombre) VALUES (?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, sucursal.getNombre());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteSucursal(Integer id) {
        try {
            conectar();

            String query = "DELETE FROM sucursales WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public List<Sucursal> listarSucursales() {
        //TODO: completar
        return null;
    }


    @Override
    public Sucursal findSucursalById(Integer id) {
        //TODO: completar
        return null;
    }
}
