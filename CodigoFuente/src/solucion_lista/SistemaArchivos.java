package solucion_lista;

public class SistemaArchivos {
    private int longitud;
    private Nodo raiz;
    private Nodo cola;

    public SistemaArchivos() {
        this.longitud = 0;
        this.raiz = null;
        this.cola = null;
    }

    public int getLongitud() {
        return longitud;
    }

    public void agregarNodoAlPrincipio(Nodo nuevoNodo) {
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.raiz);
            this.raiz.setAnterior(nuevoNodo);
            this.raiz = nuevoNodo;
        }
    }

    public void agregarNodoAlFinal(Nodo nuevoNodo) {
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
        int nivel = 0;
        Nodo temporal = null;
        if (raiz == null) {
            text.append("[VACIO]");
        } else {
            temporal = this.raiz;
        }
        while (temporal != null) {
            if (temporal.isEsCarpeta()) {
                nivel++;
                text.append("\t" + temporal.getNombre()).append("\n");
                text.append("\t\t");
                text.append(temporal.getDatos().toString());
            } else {
                text.append(temporal.getNombre()).append(" -> ");
            }
            temporal = temporal.getSiguiente();
        }
        return text.toString();
    }
}