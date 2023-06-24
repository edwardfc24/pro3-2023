package listas;

public class NodoDoble {
    private Object valor;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(Object valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
