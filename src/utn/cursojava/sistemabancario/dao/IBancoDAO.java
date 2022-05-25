package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

public interface IBancoDAO {

    Integer addBanco(Banco banco);

    Banco findById(Integer id);

    void deleteBancoById(Integer id);

    List<Banco> listarBancos();
}
