package utn.cursojava.sistemabancario.dao;

import utn.cursojava.sistemabancario.modelo.Banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Integer addBanco(Banco banco) {
        try {
            conectar();
            String query = "INSERT INTO bancos(nombre) VALUES(?)";
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, banco.getNombre());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                return null;
            }

        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteBancoById(Integer id) {
    }

    @Override
    public Banco findById(Integer id) {
        try {
            conectar();
            Banco banco = new Banco();
            String query = "SELECT * FROM bancos WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();
            if(result.next()) {
                banco.setId(result.getInt("id"));
                banco.setNombre(result.getString("nombre"));
            }
            return banco;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            desconectar();
        }
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
                banco.setId(result.getInt("id"));
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
