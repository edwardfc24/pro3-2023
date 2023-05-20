package prueba_iterator;

import listas.ListaDoble;
import patrones.Iterator;

public class Iterador<T> implements Iterator<T> {
    private ListaDoble lista;
    private int indice;

    public Iterador(ListaDoble lista) {
        this.lista = lista;
        this.indice = 0;
    }

    @Override
    public boolean tieneSiguiente() {
        return this.indice < lista.getLongitud();
    }

    @Override
    public T getSiguiente() {
        T objeto = (T) lista.obtenerValor(this.indice);
        this.indice++;
        return objeto;
    }
}
