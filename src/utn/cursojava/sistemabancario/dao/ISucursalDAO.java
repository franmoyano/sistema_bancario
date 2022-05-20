package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

public interface ISucursalDAO {
    void addSucursal(Sucursal sucursal);

    void deleteSucursal(Sucursal sucursal);
}
