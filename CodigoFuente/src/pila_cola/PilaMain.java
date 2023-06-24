package pila_cola;

import java.util.Stack;

public class PilaMain {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>();
        pila.apilar("Hola");
        pila.apilar("como");
        pila.apilar("estas");
        while (pila.verCima() != null) {
            System.out.println(pila.tomarElemento());
        }
        System.out.println("///////////////////////////");
        Stack<String> stack = new Stack<>();
        stack.add("Hola");
        stack.add("como");
        stack.add("estas");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}















