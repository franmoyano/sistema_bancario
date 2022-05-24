package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.constants.TipoCuenta;
import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.Cuenta;

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
	public void crearCuenta() {
		Cuenta cuenta = new Cuenta();
		cuentaDao.addCuenta(cuenta);
	}

}
