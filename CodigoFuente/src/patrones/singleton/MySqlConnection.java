package patrones.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static MySqlConnection instancia;
    private Connection conexion;

    private MySqlConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/testDb";
            String user = "root";
            String password = "SuperUsuar10";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static MySqlConnection obtenerInstancia(){
        if(instancia == null){
            instancia = new MySqlConnection();
        }
        return instancia;
    }
    public Connection obtenerConexion()
    {
        return conexion;
    }
}
