# Programación III - Grupo B
Este repositorio contiene el avance de la materia y los  proyectos de ejemplo
Todos deben subir un cambio en la documentación

public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n) {
        if(n == 1) {
            return 0;
        } else if(n == 2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }