package pila_cola;

public class Pila<T> {
    private Nodo<T> cima;

    public void apilar(T valor) {
        Nodo<T> ultimo = new Nodo<>(valor);
        ultimo.setSiguiente(cima);
        cima = ultimo;
    }

    public T tomarElemento() { // pop() o desapilar()
        T ultimo = null;
        if (cima == null) {
            System.out.println("La pila está vacía");
        } else {
            ultimo = cima.getValor();
            cima = cima.getSiguiente();
        }
        return ultimo;
    }

    public T verCima() { // peek()
        T ultimo = null;
        if (cima == null) {
            System.out.println("La pila está vacía");
        } else {
            ultimo = cima.getValor();
        }
        return ultimo;
    }
}













