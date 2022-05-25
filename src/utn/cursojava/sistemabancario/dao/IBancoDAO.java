package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

public interface IBancoDAO {

    Integer addBanco(Banco banco);

    void deleteBancoById(Integer id);

    List<Banco> listarBancos();
}
