# Programación III - Grupo B
Este repositorio contiene el avance de la materia y los  proyectos de ejemplo
Todos deben subir un cambio en la documentación
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
