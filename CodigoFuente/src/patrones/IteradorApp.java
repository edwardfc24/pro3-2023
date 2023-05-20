package patrones;

public class IteradorApp {
    public static void main(String[] args) {
        MiLista<String> coleccion = new MiLista<>();
        coleccion.agregar("Richard");
        coleccion.agregar("Paulinha");
        coleccion.agregar("Yamila");

        Iterator<String> caminante = coleccion.getIterador();
        while (caminante.tieneSiguiente()) {
            String item = caminante.getSiguiente();
            System.out.println(item);
        }
    }
}
