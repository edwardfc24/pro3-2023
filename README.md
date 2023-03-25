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
aqui esta el codigo referente de la tarea:
public class tarea1 {

    public static void main(String[] args) {
        System.out.println("EJERCICIO FIBONACCI");
        System.out.println("el numero de la serie fibonacci correspondiente es " + devolverFibonacciRecursividad(15));
    }
    public static int devolverFibonacciRecursividad(int numero){
        if(numero == 1) {  // 0 es "a"                                       posicion 1 2 3 4 5 6 7 8
            return 0;   // el valor 1 es el resultado de la primer serie de fibonacci 0/1/1/2/3/5/8/13/21/34/55/89/144/233/377
        }if (numero == 2){                   //                                       a b c
            return 1;     // 1 es "b"                                                   a b c
        }       //                                                                        a b c
        return devolverFibonacciRecursividad(numero -1) + devolverFibonacciRecursividad(numero -2);
        //  siempre toma el valor b va a tomar el valor de c y a el de b
    }
}
                        -----aqui va el codigo -----

    public static void main(String[] args) {

        System.out.println("el fibonacci al indice  : "+fibonacciRecursivo(9));
    }
    public static int fibonacciRecursivo(int limite){
        if (limite ==1) {
            return 0;
        } if (limite == 2){
            return 1;
        }
            return fibonacciRecursivo(limite-1)  +  fibonacciRecursivo(limite-2);

        }
