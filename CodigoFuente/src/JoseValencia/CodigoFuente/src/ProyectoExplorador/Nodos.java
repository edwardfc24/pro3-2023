package ProyectoExplorador;

import listas.NodoDoble;

import java.io.File;

public class Nodos {
    private Object valor;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public Nodos(File archivo) {
        this.valor = archivo;
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
