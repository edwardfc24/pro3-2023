package recursividad;

import java.util.Date;

public class Ordenamiento {

    public long obtenerTiempo() {
        return new Date().getTime();
    }

    public void intercambiar(int[] arreglo, int reemplazado, int reemplazo) {
        int temporal = arreglo[reemplazado];
        arreglo[reemplazado] = arreglo[reemplazo];
        arreglo[reemplazo] = temporal;
    }

    public int generarNumeroAleatorio(int desde, int hasta) {
        return (int) (Math.random() * (hasta - desde + 1) + desde);
    }

    public int[] generarArreglo(int longitud) {
        int[] generado = new int[longitud];
        int limite = (int) (longitud * 1.5);
        for (int indice = 0; indice < generado.length; indice++) {
            generado[indice] = generarNumeroAleatorio(-limite, limite);
        }
        return generado;
    }

    public void ordenarSimple(int[] arreglo) {
        int cambios = 0;
        for (int posicion = 0; posicion < arreglo.length - 1; posicion++) {
            if (arreglo[posicion] > arreglo[posicion + 1]) {
                intercambiar(arreglo, posicion, posicion + 1);
                cambios++;
            }
        }
        if (cambios > 0) {
            //System.out.println("vuelta");
            ordenarSimple(arreglo);
        }
    }

    public void mostrarArreglo(int[] arreglo) {
        System.out.print("[ ");
        for (int posicion = 0; posicion < arreglo.length; posicion++) {
            if (posicion != 0) System.out.print(", ");
            System.out.print(arreglo[posicion]);
        }
        System.out.println(" ]");
    }


}
