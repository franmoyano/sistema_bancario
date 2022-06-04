package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

/**
 * A implementar en {@link SucursalDAO}
 */
public interface ISucursalDAO {

    /**
     * Agregar sucursal
     * @param sucursal
     * @return numero entero, para verificar correcta insercion en base de datos
     */
    Integer addSucursal(Sucursal sucursal);

    /**
     * Eliminar sucursal por id
     * @param nroSucursal
     */
    void deleteSucursal(Integer nroSucursal);

    /**
     * Encontrar sucursal por id
     * @param nroSucursal
     * @return sucursal
     */
    Sucursal findSucursalByNroSucursal(Integer nroSucursal);

    /**
     * Listar sucursales
     * @return lista de todas las sucursales
     */
    List<Sucursal> listarSucursales();
}
