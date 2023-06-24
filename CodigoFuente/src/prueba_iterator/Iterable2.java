package prueba_iterator;

import listas.ListaDoble;
import patrones.Iterable;
import patrones.Iterator;

public class Iterable2<T> implements Iterable<T> {
    public ListaDoble lista;

    public Iterable2(){
        this.lista = new ListaDoble();
    }
    public void agregar(T item){
        this.lista.agregarNodoAlFinal(item);
    }
    @Override
    public Iterator<T> getIterador() {
        return new Iterador<>(this.lista);
    }
}
