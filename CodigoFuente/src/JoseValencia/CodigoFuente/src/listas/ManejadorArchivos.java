package listas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManejadorArchivos {
    public void leerArchivo(String ruta) {
        try {
            File archivo = new File(ruta);
            Scanner scanner = new Scanner(archivo);
            StringBuffer contenidoArchivo = new StringBuffer();
            while (scanner.hasNextLine()) {
                contenidoArchivo.append(scanner.nextLine());
                contenidoArchivo.append("\n");
            }
            scanner.close();
            System.out.println(contenidoArchivo);
        } catch (IOException error) {
            System.out.println("Ocurrió el siguiente error: " + error.getMessage());
        }
    }

    public void escribirArchivo(String ruta, String contenido) {
        try {
            File archivo = new File(ruta);
            if(contenido != null) {
                FileWriter escritor = new FileWriter(archivo);
                escritor.write(contenido);
                escritor.close();
            } else {
                archivo.mkdir();
            }
        } catch (IOException error) {
            System.out.println("Ocurrió el siguiente error: " + error.getMessage());
        }
    }
}
















