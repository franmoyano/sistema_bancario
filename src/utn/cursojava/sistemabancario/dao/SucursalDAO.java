package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

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
        //TODO: completar metodo
    }

    @Override
    public void deleteSucursal(Sucursal sucursal) {
        //TODO: completar metodo
    }
}
