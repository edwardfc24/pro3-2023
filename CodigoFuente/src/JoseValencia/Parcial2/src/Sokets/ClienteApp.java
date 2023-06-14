package Sokets;

public class ClienteApp {
    public static void main(String[] args) {
        ClienteObject1 cliente = new ClienteObject1();
        cliente.enviarMensaje("Jugada 1: A,5", "localhost", 8080);
        cliente.enviarMensaje("Jugada 2: C,1", "localhost", 8080);    }
}
