package solucion_lista;

public class App {
    public static void main(String[] args) {
        Nodo archivo1 = new Nodo("prueba.txt", "Este es un contenido de prueba", false);
        Nodo carpeta1 = new Nodo("miCarpeta", null, true);
        Nodo archivo2 = new Nodo("prueba2.txt", "Este archivo esta en una subcarpeta", false);
        carpeta1.getDatos().agregarNodoAlFinal(archivo2);
        //System.out.println(archivo1.toString());
        //System.out.println(carpeta1.toString());
        SistemaArchivos carpetas = new SistemaArchivos();
        carpetas.agregarNodoAlFinal(archivo1);
        carpetas.agregarNodoAlFinal(carpeta1);
        System.out.println(carpetas.toString());

    }
}
