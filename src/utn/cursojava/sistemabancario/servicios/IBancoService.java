package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

public interface IBancoService {
    void addBanco();

    void addBanco(Banco banco);

    void deleteBancoById(Integer id);

    List<Banco> listarBancos();
}
