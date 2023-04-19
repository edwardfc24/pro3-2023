package primer_parcial;

import java.util.Arrays;

public class Solucion {
    public static void main(String[] args) {
        int[] numeros = {25, 16, 31, -2, 7, -13, 5};
        System.out.println("Suma: " + sumarLista(numeros));
        System.out.println("El mayor número del arreglo es: " + buscarMayor(numeros, numeros.length - 1));
        System.out.println("La potencia de 3 elevado a 3 es: " + calcularPotecia(3, 3));
        dibujarArbol(7,6,1);
    }

    public static int sumarLista(int[] lista) {
        if (lista.length == 1)
            return lista[0];
        int[] recortado = Arrays.copyOfRange(lista, 1, lista.length);
        return lista[0] + sumarLista(recortado);
    }

    public static int buscarMayor(int[] lista, int posicion) {
        if (posicion == 0)
            return lista[posicion];
        int maximo = buscarMayor(lista, posicion - 1);
        if (lista[posicion] > maximo)
            return lista[posicion];
        else
            return maximo;
    }

    public static int calcularPotecia(int base, int exponente) {
        if (exponente == 0)
            return 1;
        return base * calcularPotecia(base, exponente - 1);
    }

    public static void dibujarArbol(int niveles, int espacios, int figuras) {
        if (niveles > 0) {
            // Primero dibujamos espacios
            for (int i = 0; i < espacios; i++) {
                System.out.print(" ");
            }
            // Después dibujamos numerales
            for (int i = 0; i < figuras; i++) {
                System.out.print("# ");
            }
            System.out.println("");
            dibujarArbol(niveles-1, espacios -1, figuras +1);
        }
    }
}


















