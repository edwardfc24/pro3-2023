package observerrr;

public class _Main {
    public static void main(String[] args) {
        Tienda tienda1= new Tienda();
        Tienda almacen1= new Tienda();

        tienda1.suscribir(almacen1);
        almacen1.suscribir(tienda1);

        tienda1.notificar(8);
        tienda1.notificar(2);
        almacen1.notificar(4);

    }
}
