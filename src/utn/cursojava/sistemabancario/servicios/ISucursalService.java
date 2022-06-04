package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

/**
 * Interfaz a implementar en {@link SucursalServiceImpl}
 */
public interface ISucursalService {

    /**
     * Agrega una sucursal ya definida
     * @param sucursal
     */
    void addSucursal(Sucursal sucursal);

    /**
     * Agrega una nueva sucursal
     * @param bancoId
     * @return numero entero, para verificar si se persistio de manera adecuada
     */
    Integer addSucursal(Integer bancoId);

    /**
     * Elimina una sucursal por id
     * @param nroSucursal
     */
    void deleteSucursal(Integer nroSucursal);

    /**
     * Listar sucursales
     * @return lista de todas las sucursales
     */
    List<Sucursal> listarSucursales();

    /**
     * Encontrar sucursal por id
     * @param id
     * @return Sucursal por id
     */
    Sucursal findById(Integer id);
}
