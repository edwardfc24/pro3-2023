# Programación III - Grupo B
Este repositorio contiene el avance de la materia y los  proyectos de ejemplo
Todos deben subir un cambio en la documentación
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