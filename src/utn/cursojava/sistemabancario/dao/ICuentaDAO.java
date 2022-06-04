package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;

/**
 * A implementar en {@link CuentaDAO}
 */
public interface ICuentaDAO {

    /**
     * Encontrar cuenta por CBU
     * @param cbu
     * @return cuenta
     */
    Cuenta findCuentaByCBU(String cbu);

    /**
     * Actualizar cuenta (deposito, extraccion, transferencias, actualizaciones de saldo)
     * @param cuenta
     * @return numero entero, para verificar correcta actualizacion de cuenta
     */
    Integer actualizarCuenta(Cuenta cuenta);

    /**
     * Agregar cuenta
     * @param cuenta
     */
    void addCuenta(Cuenta cuenta);

    /**
     * Eliminar cuenta
     * @param cuenta
     */
    void deleteCuenta(Cuenta cuenta);

    /**
     * Listar cuentas por cliente
     * @param idCliente
     * @return
     */
    List<Cuenta> listarCuentasDeCliente(Integer idCliente);
}
