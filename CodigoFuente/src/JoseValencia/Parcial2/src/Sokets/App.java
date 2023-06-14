package Sokets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try{
            //elegir un buen puerto
            //  este es el puerto donde escuichara nuestro servidor
            //utilizar logger
            ServerSocket servidor = new ServerSocket(8080);
            System.out.println("servidor levantado...");// cambiar a log con uno de info
            Socket soket= servidor.accept();//apertura el canal y espera conexiones
            System.out.println("cliente conectado");
            //establecer flujos de entrada y salida para el soket
            BufferedReader entrada = new BufferedReader(new InputStreamReader(soket.getInputStream())); // scanner de entrada
            PrintWriter salida = new PrintWriter(soket.getOutputStream(), true); //salida
            //leer los mensajes enviados por el cliente (entrada)
            String mensaje = entrada.readLine();
            System.out.println("mensaje recibido"+ mensaje );
            // en el proyecto recibimos la posicion de un disparo, si es que hay un barco tenemos que devolver e
            String respuesta = "mensaje exitoso , la conexion funciona ";
            salida.println(respuesta);

            //solo cerrar si ya no se quiere recibir o enviar mensaje
            soket.close();
            servidor.close();
        }catch (IOException error){
            error.printStackTrace();
        }
    }
}
