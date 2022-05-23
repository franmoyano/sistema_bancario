package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

public interface ISucursalDAO {
    void addSucursal(Sucursal sucursal);

    void deleteSucursal(Integer nroSucursal);

    Sucursal findSucursalById(Integer id);

    List<Sucursal> listarSucursales();
}
