package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

/**
 * Interfaz a implementar en {@link BancoDAO}
 */
public interface IBancoDAO {

    /**
     * Agregar un banco
     * @param banco
     * @return numero entero para validar persistencia del banco
     */
    Integer addBanco(Banco banco);

    /**
     * Encontrar banco por id
     * @param id
     * @return banco
     */
    Banco findById(Integer id);

    /**
     * Eliminar banco por id
     * @param id
     */
    void deleteBancoById(Integer id);

    /**
     * Listar bancos
     * @return Lista de bancos
     */
    List<Banco> listarBancos();
}
