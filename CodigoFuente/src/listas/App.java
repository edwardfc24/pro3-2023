package listas;

public class App {
    public static void main(String[] args) {
        Lista listaSimple = new Lista();
        listaSimple.agregarNodo(1);
        listaSimple.agregarNodo("tres");
        listaSimple.agregarNodo(5);
        listaSimple.agregarNodo(7.0);
        System.out.println(listaSimple.toString());
        System.out.println("Tamaño de la lista: " + listaSimple.getLongitud());
        int posicion = 11;
        System.out.println("El valor en la posición " + posicion + " es: " + listaSimple.obtenerValor(posicion));
    }
}














