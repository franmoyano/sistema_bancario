package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaDAO extends DAO implements ICuentaDAO {
    private List<Cuenta> cuentas;
    private static CuentaDAO instance;

    private CuentaDAO() {
        this.cuentas = new ArrayList<>();
    }

    public synchronized static CuentaDAO getInstance() {
        if (instance == null) {
            instance = new CuentaDAO();
        }
        return instance;
    }


    @Override
    public void addCuenta(Cuenta cuenta) {
        //TODO: completar metodo
    }

    @Override
    public void deleteCuenta(Cuenta cuenta) {
        //TODO: completar metodo
    }
}
