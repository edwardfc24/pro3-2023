package prueba_iterator;

import patrones.Iterator;
import patrones.MiLista;

import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        Iterable2<Object> coleccion = new Iterable2<>();
        coleccion.agregar(new Vendedor("Richard", new Date(), 50));
        coleccion.agregar(new Vendedor("Paulinha", new Date(), 35));
        coleccion.agregar(new Vendedor("Yamila", new Date(), 0));

        Iterator<Object> caminante = coleccion.getIterador();
        while (caminante.tieneSiguiente()) {
            Object item = caminante.getSiguiente();
            System.out.println(item);
        }
    }
}
