package listas;

public class Lista {
    private int longitud;

    public int getLongitud() {
        return longitud;
    }

    private Nodo raiz;

    public Lista() {
        this.longitud = 0;
        this.raiz = null;
    }

    public void agregarNodo(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        // Primero verificamos que la raiz no esté vacía, si lo está asignamos el nodo
        if (this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {
            // Si la raiz no está vacía, declaramos un temporal para guardar el elemento de estudio
            Nodo temporal = raiz;
            // Buscamos aquel nodo que no tenga fijado un nodo siguiente
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            // Una vez ubicado, le asignamos el nodo nuevo
            temporal.setSiguiente(nuevoNodo);
        }
        this.longitud++;
    }

    @Override
    public String toString() {
        StringBuffer text = new StringBuffer();
        Nodo temporal = null;
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

    public Object obtenerValor(int indice) {
        Nodo temporal = this.raiz;
        if (indice >= 0) {
            int contador = 0;

            while (contador < indice) {
                if (temporal != null) {
                    temporal = temporal.getSiguiente();
                    contador++;
                } else {
                    return "El índice buscado no se encuentra en la lista";
                }
            }
            return temporal.getValor();
        }
        return "El índice no puede ser negativo";
    }
    public void eliminarValor(Object eliminado){
        
    }
}

















