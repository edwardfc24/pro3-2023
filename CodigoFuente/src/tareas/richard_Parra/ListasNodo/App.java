package ListasNodo;

import ListasNodo.UI.Ventana;

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
        /*ListaDoble listaDoble = new ListaDoble();
        listaDoble.agregarNodoAlFinal(1);
        listaDoble.agregarNodoAlFinal("tres");
        listaDoble.agregarNodoAlPrincipio("dos");
        System.out.println(listaDoble.toString());
        //int pos = 0;
        //System.out.println("El valor en la posicion " + pos + " es: " + listaDoble.obtenerValorListaDoble(pos));
        //listaDoble.eliminarValorListaD(3);
        //listaDoble.eliminarValorPosicionListaD(2);
        System.out.println(listaDoble.toString());
        // prueba
        ManejadorArchivos manejador = new ManejadorArchivos();
        manejador.leerArchivo("C:\\Users\\Richard-P\\prueba.txt.txt");
        String rutaNueva = "C:\\Users\\Richard-P\\pruebaEscritura.txt.txt";
        System.out.println();
        manejador.escribirArchivo(rutaNueva, "estas lineas se escribieron");
        manejador.leerArchivo(rutaNueva);*/
        Ventana ventana = new Ventana();
    }
}
