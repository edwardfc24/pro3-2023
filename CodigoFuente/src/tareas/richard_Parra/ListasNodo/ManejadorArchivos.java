package ListasNodo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManejadorArchivos {

    public void leerArchivo(String ruta){
        try {
            File archivo = new File(ruta);
            Scanner scanner = new Scanner(archivo);
            StringBuffer contenidoArchivo = new StringBuffer();
            while (scanner.hasNextLine()){
                contenidoArchivo.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(contenidoArchivo.toString());
        }catch (IOException error){
            System.out.println("Ocurrio el siguiente error: " + error.getMessage());
        }

    }
    public void escribirArchivo(String ruta, String contenido){
        try {
            File archivo = new File(ruta);
            FileWriter escritor = new FileWriter(archivo);
            escritor.write(contenido);
            escritor.close();
        }catch (IOException error){
            System.out.println("Ocurrio el siguiente error: " + error.getMessage());
        }

    }
    public void eliminarArchivo(String ruta){
        File archivo = new File(ruta);
        if(!archivo.delete()) System.out.println("se elimino satisfactoriamente");
    }

    //toma una ruta y crea un directorio en la ruta especificada.
    public void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }
}
