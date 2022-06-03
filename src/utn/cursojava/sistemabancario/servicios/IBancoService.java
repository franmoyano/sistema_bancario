package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.util.List;

/**
 * Esta interfaz establece los criterios que debera tener la implementacion "BancoServiceImpl"
 */
public interface IBancoService {

    /**
     * @return devuelve el id del banco luego de insertarse en la DB
     */
    Integer addBanco();

    /**
     * Se elimina un banco por id
     * @param id
     */
    void deleteBancoById(Integer id);

    /**
     * @param id
     * @return devuelve un banco por id
     */
    Banco findById(Integer id);

    /**
     * @return lista de bancos en db
     */
    List<Banco> listarBancos();
}
