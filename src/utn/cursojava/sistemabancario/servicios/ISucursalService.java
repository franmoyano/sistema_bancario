package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

public interface ISucursalService {
    void addSucursal(Sucursal sucursal);

    Integer addSucursal(Integer bancoId);

    void deleteSucursal(Integer nroSucursal);

    List<Sucursal> listarSucursales();

    Sucursal findById(Integer id);
}
