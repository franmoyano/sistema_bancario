package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.Cuenta;

import java.util.List;
import java.util.Scanner;

public class CuentaServiceImpl implements ICuentaService {

	private CuentaDAO cuentaDao;

	public CuentaServiceImpl() {
		this.cuentaDao = CuentaDAO.getInstance();
	}

	@Override
	public Double extraer(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositar(Double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cuenta> listarCuentasDeCliente(Integer id) {
		return cuentaDao.listarCuentasDeCliente(id);
	}

	@Override
	public void crearCuenta(Integer idCliente) {
		Scanner input = new Scanner(System.in);
		Cuenta cuenta = new Cuenta();

//		System.out.println("\n*** CREANDO CUENTA ***");
		cuenta.setClienteId(idCliente);
		cuenta.setTipoCuenta(TipoCuenta.CA);
		cuentaDao.addCuenta(cuenta);
	}



}
