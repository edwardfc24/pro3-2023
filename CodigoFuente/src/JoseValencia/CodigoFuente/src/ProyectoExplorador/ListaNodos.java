package ProyectoExplorador;

import listas.NodoDoble;

import java.io.File;

public class ListaNodos {
    private int longitud;
    private NodoDoble raiz;
    private NodoDoble cola;

    public ListaNodos() {
        this.longitud = 0;
        this.raiz = null;
        this.cola = null;
    }

    public int getLongitud() {
        return longitud;
    }

    public void agregarNodoAlPrincipio(/*Object*/ File archivo) {
        NodoDoble nuevoNodo = new NodoDoble(archivo);
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.raiz);
            this.raiz.setAnterior(nuevoNodo);
            this.raiz = nuevoNodo;
        }
    }

    public void agregarNodoAlFinal(/*Object*/File archivo) {
        NodoDoble nuevoNodo = new NodoDoble(archivo);
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(this.cola);
            this.cola.setSiguiente(nuevoNodo);
            this.cola = nuevoNodo;
        }
    }

    @Override
    public String toString() {
        StringBuffer text = new StringBuffer();
        NodoDoble temporal = null;
        if (raiz == null) {
            text.append("[VACIO]");
        } else {
            temporal = this.raiz;
        }
        while (temporal != null) {
            text.append(temporal.getValor()).append(" -> ");
            temporal = temporal.getSiguiente();
        }
        return text.toString();
    }
}
