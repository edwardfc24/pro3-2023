package patrones;

import java.util.List;

public class MiIterador<T> implements Iterator<T> {
    private List<T> lista;
    private int indice;

    public MiIterador(List<T> lista) {
        this.lista = lista;
        this.indice = 0;
    }

    @Override
    public boolean tieneSiguiente() {
        return this.indice < lista.size();
    }

    @Override
    public T getSiguiente() {
        T objeto = lista.get(this.indice);
        this.indice++;
        return objeto;
    }
}
