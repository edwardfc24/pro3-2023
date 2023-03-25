# Programación III - Grupo B
Este repositorio contiene el avance de la materia y los  proyectos de ejemplo
Todos deben subir un cambio en la documentación
- Richard Parra Zegarra
-----------------------------------------------------------------------------
package Principal;

import java.util.Date;

public class CuentaRegresiva {
    public static void main(String[] args) {
        long tiempoInicio = new Date().getTime();
        //cuentaRegresa(5);
        //cuentaMenos(15000);
        //System.out.println(devolverFibonacci(7));
        System.out.println(numerosfibonacci(7));
        long tiempoFinal = new Date().getTime();
        System.out.println("Tiempo de ejecucion (ms): " + (tiempoFinal - tiempoInicio));
    }
    public static void cuentaRegresa(int lim){
        for (int i = lim; i > 0; i--) {
            System.out.println(i);
        }
    }
    public static void cuentaMenos(int numero){
        System.out.println(numero);
        if (numero > 1){
            //return (numero - 1);
            cuentaMenos(numero - 1);
        }
    }
    public static int devolverFibonacci(int number){
        int baseA = 0;
        int baseB = 1;
        int fibonacci = 0;
        int contador = 2;
        if (number == 1)
            return baseA;
        if (number == 2)
            return baseB;
        while(contador < number){
            fibonacci = baseA + baseB;
            baseA = baseB;
            baseB = fibonacci;
            contador++;
        }
        return fibonacci;
    }
    public static int numerosfibonacci(int numero){
        if (numero == 1)
            return 0;
        if (numero == 2)
            return 1;
        return numerosfibonacci(numero - 1) + numerosfibonacci(numero - 2);
        //return numero;
    }
}
