package patrones.singleton;

public class MainSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.obtenerInstancia();
        MySqlConnection baseDatos = MySqlConnection.obtenerInstancia();
        baseDatos.obtenerConexion();
    }
}
