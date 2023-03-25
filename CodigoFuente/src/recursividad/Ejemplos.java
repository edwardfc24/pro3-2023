package recursividad;


import java.util.Date;

public class Ejemplos {
    public static void main(String[] args) {
        long tiempoInicio = new Date().getTime();
        // cuentaRegresiva(15000);
        //cuentaRegresivaRecursiva(15000);
        //System.out.println(devolverFibonacci(12));
        //System.out.println(devolverFibonacciRecursivo(120));
        // System.out.println(esPalindromo("216559855"));
        //System.out.println(esPalindromoRecursivo("1234432156"));
        System.out.println(factorial(6));
        long tiempoFinal = new Date().getTime();
        System.out.println("Tiempo de Ejecución (ms): " + (tiempoFinal - tiempoInicio));
    }

    public static void cuentaRegresiva(int limite) {
        for (int i = limite; i > 0; i--) {
            System.out.println(i);
        }
    }

    public static void cuentaRegresivaRecursiva(int limite) {
        System.out.println(limite);
        if (limite > 1)
            cuentaRegresivaRecursiva(limite - 1);
    }

    public static int devolverFibonacci(int numero) {
        int baseA = 0;
        int baseB = 1;
        int fibonacci = 0;
        int conteoFibonacci = 2;
        if (numero == 1)
            return baseA;
        if (numero == 2)
            return baseB;
        while (conteoFibonacci < numero) {
            fibonacci = baseA + baseB;
            baseA = baseB;
            baseB = fibonacci;
            conteoFibonacci++;
        }
        return fibonacci;
    }

    public static long devolverFibonacciRecursivo(int posicion) {
        if (posicion == 1)
            return 0;
        if (posicion == 2)
            return 1;
        return devolverFibonacciRecursivo(posicion - 1) + devolverFibonacciRecursivo(posicion - 2);
    }

    public static boolean esPalindromo(String objeto) {
        String reverso = "";
        for (int pos = objeto.length(); pos > 0; pos--) {
            reverso += objeto.substring(pos - 1, pos);
        }
        return objeto.toLowerCase().equals(reverso.toLowerCase());
    }

    public static boolean esPalindromoRecursivo(String palabra) {
        if (palabra.length() <= 1)
            return true;
        String primerLetra = palabra.substring(0, 1);
        String ultimaLetra = palabra.substring(palabra.length() - 1);
        if (!primerLetra.toLowerCase().equals(ultimaLetra.toLowerCase()))
            return false;
        return esPalindromoRecursivo(palabra.substring(1, palabra.length() - 1));
    }

    public static int factorial(int numero) {
        if (numero == 0)//if(0 <= numero && numero <= 1)
            return 1;
        return numero * factorial(numero - 1);
    }
}

















