package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

public interface ISucursalDAO {
    Integer addSucursal(Sucursal sucursal);

    void deleteSucursal(Integer nroSucursal);

    Sucursal findSucursalByNroSucursal(Integer nroSucursal);

    List<Sucursal> listarSucursales();
}
