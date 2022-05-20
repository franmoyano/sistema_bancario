package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;

public class SucursalServiceImpl implements ISucursalService {
    private SucursalDAO sucursalDao;

    public SucursalServiceImpl() {
        this.sucursalDao = SucursalDAO.getInstance();
    }

    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalDao.addSucursal(sucursal);
    }

    @Override
    public void deleteSucursal(Integer nroSucursal) {
        sucursalDao.deleteSucursal(nroSucursal);
    }

    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalDao.listarSucursales();
    }

    @Override
    public Sucursal findSucursalByNroSucursal(Integer nroSucursal) {
        return sucursalDao.findSucursalByNroSucursal(nroSucursal);
    }
}
