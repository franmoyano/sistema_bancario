package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaDAO {

    void addCuenta(Cuenta cuenta);

    void deleteCuenta(Cuenta cuenta);
}
