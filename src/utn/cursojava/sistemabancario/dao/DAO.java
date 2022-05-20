package utn.cursojava.sistemabancario.dao;

import java.sql.*;

public abstract class DAO {
    protected Connection connection = null;
    protected ResultSet result = null;
    protected Statement statement = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "sistema_bancario";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectar() {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
            connection = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void desconectar() {
        try {
            if(result != null) {
                result.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    protected void crearModificarEliminar(String query) {
        try {
            conectar();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    protected void consultarBase(String query) {
        try {
            conectar();
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
