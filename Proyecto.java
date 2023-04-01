-- clase panel
package Interfaz;

import MetodoQuickSort.MetodoBurbuja;
import MetodoQuickSort.Ordenamiento;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable {
    private int ancho = 50;
    //private int[] numeros = new int[10];
    private int[] numeros = {6,11,-2,5,7,-7,1,28,10};

    private MetodoBurbuja burbuja = new MetodoBurbuja(this);
    private Ordenamiento ordenamiento = new Ordenamiento(this);

    public Panel() {
        setLayout(null);
        this.setSize(1000, 500);
        this.setPreferredSize(getSize());
        //llenarArray();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        dibujarArray(g, 20, 400);

    }

    public void dibujarArray(Graphics g, int x, int y) {
        for (Integer num: numeros) {
            g.drawRect(x, y, ancho, num);
            x += ancho + 10;
        }
    }

    /*private void llenarArray() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }
    }*/

    @Override
    public void run() {
        ordenamiento.ordenarSimple(numeros);
        //burbuja.bubbleSort(numeros);
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
        repaint();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(numeros));
    }
}
-- ordenamiento quicksort
package MetodoQuickSort;

import Interfaz.Panel;

import java.util.Date;

public class Ordenamiento {
    private Panel panel;
    private int length;

    public Ordenamiento(Panel fr) {
        this.panel = fr;
    }
    public long obtenerTiempo(){
        return new Date().getTime();
    }

    // int[] arreglo, indice, indice
    public void intercambiar(int[] arreglo, int reemplazado, int reemplazo){
        int temporal = arreglo[reemplazado];
        arreglo[reemplazado] = arreglo[reemplazo];
        arreglo[reemplazo] = temporal;
        panel.setNumeros(arreglo);
    }
    public int numeroAleatorio(int desde, int hasta){
        return (int) (Math.random() * (hasta - desde + 1) + desde);
    }
    public int[] generarArreglo(int longitud){
        int[] generado = new int[longitud];
        int limite = (int) (longitud * 1.5);
        for (int indice = 0; indice < generado.length; indice++) {
            generado[indice] = numeroAleatorio(-limite, limite);
        }
        return generado;
    }
    public void ordenarSimple(int[] arreglo){
        int cambios = 0;
        //  1 2 3 4
        //  5 8 3
        // arregloA = {5,89,-4,6,-8}
        // cualquier valor de los mencionados esta dentro de arregloA
        // arrreglo [1]
        for (int pos = 0; pos < arreglo.length - 1; pos++) {
            if (arreglo[pos] > arreglo[pos + 1]){
                // intercambiar(1, pos+1, 1) = una posicion ++ cambio
                intercambiar(arreglo, pos,pos + 1);
                // estamos en 2 que es igual a 8, si cambios es igual + 1 (2+1) igual 3
                // si 3 no cumple con la primera condicion va ser 3 (cambios++) igual a 3 + 1
                cambios++;
            }
        }
        if (cambios > 0){
            ordenarSimple(arreglo);
        }
    }
    public void mostrarArreglo(int[] arreglo){
        System.out.print("[ ");
        for (int posicion = 0; posicion < arreglo.length; posicion++) {
            if (posicion != 0)
                System.out.print(", ");
            System.out.print(arreglo[posicion]);
        }
        System.out.println(" ]");
    }
    public void dividirArreglo(int[] arreglo, int inicio, int fin){
        int pivote = arreglo[arreglo.length - 1];
        for (int posi = 0; posi < arreglo.length; posi++) {
            if (arreglo[posi] < pivote){
                intercambiar(arreglo, inicio, fin);
            }
        }
    }
    public void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int posPivote = particion(arreglo, inicio, fin);
            quickSort(arreglo, inicio, posPivote - 1);
            quickSort(arreglo, posPivote + 1, fin);
        }
    }

    public int particion(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[inicio];
        int i = inicio + 1;
        for (int j = inicio + 1; j <= fin; j++) {
            if (arreglo[j] < pivote) {
                intercambiar(arreglo, i, j);
                i++;
            }
        }
        intercambiar(arreglo, inicio, i - 1);
        return i - 1;
    }
    /*public void OrdenarQuicksort(int[] numero){
        int pivote = numero[numero.length - 1];
        for (int pos = 0; pos < numero.length - 1; pos++) {
            if (numero[pos] < pivote){

            }
        }
    }*/
}
-- metodo burbuja
package MetodoQuickSort;

import Interfaz.Panel;

public class MetodoBurbuja {
    private Panel panel;

    public MetodoBurbuja(Panel panel) {
        this.panel = panel;
    }

    public void bubbleSort(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    panel.setNumeros(array);
                }
            }
        }
    }
}
-- ventana
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaQuickSort extends JFrame{

    private JPanel panel = new Panel();

    public VentanaQuickSort(){
        iniciarComponentes();
        Thread hilo = new Thread((Runnable) panel);
        hilo.start();
    }
    public void iniciarComponentes(){
        this.setSize(2000, 2000);
        this.setTitle("Primera Tarea");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        VentanaQuickSort ventana = new VentanaQuickSort();
        ventana.setVisible(true);
    }
}
