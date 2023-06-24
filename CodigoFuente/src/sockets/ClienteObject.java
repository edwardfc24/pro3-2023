package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteObject {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    private void recibirRespuesta() throws IOException {
        String respuesta = this.entrada.readLine();
        System.out.println(respuesta);
    }

    public void enviarMensaje(String mensaje, String servidor, int puerto) {
        try {
            socket = new Socket(servidor, puerto);
            System.out.println("Conexion realizada");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            // Gestion mensajes
            salida.println(mensaje);
            this.recibirRespuesta();
            this.desconectarServidor();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void desconectarServidor() {
        try {
            this.entrada.close();
            this.salida.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
















