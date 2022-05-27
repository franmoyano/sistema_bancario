package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;

public interface ICuentaDAO {

    Integer actualizarCuenta(Cuenta cuenta);

    void addCuenta(Cuenta cuenta);

    void deleteCuenta(Cuenta cuenta);

    List<Cuenta> listarCuentasDeCliente(Integer idCliente);
}
