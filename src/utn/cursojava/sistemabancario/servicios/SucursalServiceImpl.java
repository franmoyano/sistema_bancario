package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.SucursalDAO;
import utn.cursojava.sistemabancario.modelo.Sucursal;

import java.util.List;
import java.util.Scanner;

public class SucursalServiceImpl implements ISucursalService {
    private SucursalDAO sucursalDao;

    public SucursalServiceImpl() {
        this.sucursalDao = SucursalDAO.getInstance();
    }

    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalDao.addSucursal(sucursal);
    }

    public void addSucursal() {
        Scanner input = new Scanner(System.in);
        System.out.print("*** CREANDO SUCURSAL ***" +
                "\nNombre: ");
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(input.nextLine());
        sucursalDao.addSucursal(sucursal);
    }

    @Override
    public void deleteSucursal(Integer id) {
        sucursalDao.deleteSucursal(id);
    }

    @Override
    public List<Sucursal> listarSucursales() {
        return sucursalDao.listarSucursales();
    }

    @Override
    public Sucursal findSucursalById(Integer id) {
        return sucursalDao.findSucursalById(id);
    }
}
