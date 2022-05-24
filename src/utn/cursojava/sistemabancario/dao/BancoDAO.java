package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancoDAO extends DAO implements IBancoDAO {

    private static BancoDAO instance;

    private BancoDAO() {
    }

    public static BancoDAO getInstance() {
        if(instance == null) {
            instance = new BancoDAO();
        }
        return instance;
    }

    @Override
    public void addBanco(Banco banco) {
        try {
            conectar();
            String query = "INSERT INTO bancos(nombre) VALUES(?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, banco.getNombre());
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteBancoById(Integer id) {

    }

    @Override
    public List<Banco> listarBancos() {
        try {
            conectar();
            String query = "SELECT * FROM bancos";
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            Banco banco;
            List<Banco> bancos = new ArrayList<>();
            while(result.next()) {
                banco = new Banco();
                banco.setNombre(result.getString("nombre"));
                bancos.add(banco);
            }
            return bancos;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return null;
    }

}
