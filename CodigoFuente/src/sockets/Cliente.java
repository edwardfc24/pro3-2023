package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try{
            // Conectar el cliente al servidor
            Socket socket = new Socket("localhost",8080);
            System.out.println("Conexión exitosa!");
            // Establecer los flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            // Se envia el mensaje al servidor
            String mensaje =  " Esta brujería funciona";
            salida.println(mensaje);
            // Esperamos y leemos la respuesta del servidor
            String respuesta = entrada.readLine();
            System.out.println("Mensaje del servidor: " + respuesta);
            // Al finalizar el uso, cerrar el socket
            socket.close();
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}












