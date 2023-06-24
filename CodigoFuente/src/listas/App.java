package listas;

public class App {
    public static void main(String[] args) {
        /*Lista listaSimple = new Lista();
        listaSimple.agregarNodo(1);
        listaSimple.agregarNodo("tres");
        listaSimple.agregarNodo(5);
        listaSimple.agregarNodo(7.0);
        listaSimple.agregarNodo(8);
        System.out.println(listaSimple.toString());
        System.out.println("Tamaño de la lista: " + listaSimple.getLongitud());
        int posicion = 11;
        System.out.println("El valor en la posición " + posicion + " es: " + listaSimple.obtenerValor(posicion));
        //listaSimple.eliminarValor(8);
        listaSimple.eliminarValorPorPosicion(-2);
        System.out.println(listaSimple.toString());*/
        ListaDoble listaDoble = new ListaDoble();
        listaDoble.agregarNodoAlFinal(1);
        listaDoble.agregarNodoAlFinal("tres");
        listaDoble.agregarNodoAlPrincipio("dos");
        System.out.println(listaDoble.toString());
        // Ahora probamos la lectura de archivos
        ManejadorArchivos manejador = new ManejadorArchivos();
        manejador.leerArchivo("D:/Prueba.txt");
        String rutaNueva = "D:/PruebaEscritura.txt";
        System.out.println();
        manejador.escribirArchivo(rutaNueva, "Esteas líneas se escribieron\ndesde el editor de código\n Saludos!!!!");
        manejador.leerArchivo(rutaNueva);
        System.out.println("Creando carpeta");
        manejador.escribirArchivo("D:/Prueba", null);
    }
}














