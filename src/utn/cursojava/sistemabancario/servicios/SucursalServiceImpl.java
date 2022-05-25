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

    @Override
    public Integer addSucursal(Integer bancoId) {
        Sucursal sucursal = new Sucursal();
        Scanner input = new Scanner(System.in);
        System.out.println("\n*** CREANDO SUCURSAL ***");
        System.out.print("Nombre: ");
        sucursal.setNombre(input.nextLine());
        sucursal.setBancoId(bancoId);
        return sucursalDao.addSucursal(sucursal);
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
    public Sucursal findById(Integer id) {
        return sucursalDao.findSucursalByNroSucursal(id);
    }
}
