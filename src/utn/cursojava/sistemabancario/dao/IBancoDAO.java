package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

public interface IBancoDAO {

    void addBanco(Banco banco);

    void deleteBancoById(Integer id);

    List<Banco> listarBancos();
}
