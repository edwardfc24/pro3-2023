package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Estes es el puerto donde escuchara nuestro servidor
            ServerSocket servidor = new ServerSocket(8080);
            System.out.println("Servidor levantado. Esperando conexiones...");
            Socket socket = servidor.accept(); // Apertura el canal y espera conexiones
            System.out.println("Cliente conectado");
            // Establecer flujos de entrada y salida para el socket
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);
            // Leer los mensajes enviados por el cliente  (Entrada)
            String mensaje = entrada.readLine();
            System.out.println("Mensaje recibido: " + mensaje);
            // Enviar respuesta al cliente
            String respuesta = "Mensaje exitoso, La conexión funciona";
            salida.println(respuesta);
            // Toca el turno de cerrar el socket y el servidor
            // Sólo cerrar si ya no se quieren recibir o enviar más mensajes
            socket.close();
            servidor.close();
        } catch (IOException error){
            error.printStackTrace();
        }
    }
}












