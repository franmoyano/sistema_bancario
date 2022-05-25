package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.BancoDAO;
import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;
import java.util.Scanner;

public class BancoServiceImpl implements IBancoService {
    private BancoDAO bancoDAO;

    public BancoServiceImpl() {
        this.bancoDAO = BancoDAO.getInstance();
    }

    /**
     *
     * @return Devuelve el ID del NUEVO BANCO, luego de ser insertado en la BBDD
     */
    @Override
    public Integer addBanco() {
        Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        System.out.print("\n*** CREANDO BANCO ***" +
                "\nIngrese el nombre: ");
        banco.setNombre(input.nextLine());
        return bancoDAO.addBanco(banco);
    }

    @Override
    public void addBanco(Banco banco) {
        bancoDAO.addBanco(banco);
    }

    @Override
    public Banco findById(Integer id){
        return bancoDAO.findById(id);
    }

    @Override
    public void deleteBancoById(Integer id) {
        bancoDAO.deleteBancoById(id);
    }

    @Override
    public List<Banco> listarBancos() {
        return bancoDAO.listarBancos();
    }
}
