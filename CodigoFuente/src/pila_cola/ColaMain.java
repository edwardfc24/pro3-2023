package pila_cola;

import java.util.PriorityQueue;
import java.util.Queue;

public class ColaMain {
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        cola.encolar("Hola");
        cola.encolar("como");
        cola.encolar("estas");
        while (cola.verPrimero() != null) {
            System.out.println(cola.tomarElemento());
        }
        System.out.println("///////////////////////////");
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Hola");
        queue.add("como");
        queue.add("estas");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}














