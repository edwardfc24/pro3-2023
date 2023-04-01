package tareas.mateo_suarez;

import java.awt.*;
import javax.swing.*;

public class Quicksort extends JFrame {
    public static void main(String args[]) {
        Quicksort application = new Quicksort();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static int colocar(int arreglo[], int reemplazado, int temporal) {
        int indice;
        int pivote;
        int valor_pivote;
        int temp;
        pivote = reemplazado;
        valor_pivote = arreglo[pivote];
        for (indice = reemplazado + 1; indice <= temporal; indice++) {
            if (arreglo[indice] > valor_pivote) {
                pivote++;
                temp = arreglo[indice];
                arreglo[indice] = arreglo[pivote];
                arreglo[pivote] = temp;
            }
        }
        temp = arreglo[reemplazado];
        arreglo[reemplazado] = arreglo[pivote];
        arreglo[pivote] = temp;
        return pivote;
    }

    public Quicksort() {
        super("GRAFICO");
        setSize(520, 520);
        setVisible(true);
    }

    public static void Quicksort(int arreglo[], int reemplazado, int temporal) {
        int pivote;
        if (reemplazado < temporal) {
            pivote = colocar(arreglo, reemplazado, temporal);
            Quicksort(arreglo, reemplazado, pivote - 1);
            Quicksort(arreglo, pivote + 1, temporal);
        }
    }

    public void stop(int tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (Exception err) {
        }
    }

    public void paint(Graphics grafico_escalonado) {
        int A[] = new int[470];
        int p = 0;
        int q = 469;
        super.paint(grafico_escalonado);
        grafico_escalonado.setColor(Color.RED);
        grafico_escalonado.drawLine(50, 0, 30, 470);
        grafico_escalonado.drawLine(50, 470, 500, 470);
        for (int y = 0; y < 469; y++) {
            stop(50);
            int valor = 1 + (int) (Math.random() * 469);
            A[y] = valor;
            grafico_escalonado.setColor(Color.RED);
            grafico_escalonado.drawLine(30 + y, 470, 30 + y, valor);
            System.out.print(" Arreglo escalonado Desordenado " + "<" + A[y] + ">");
            System.out.print("\n");
        }
        grafico_escalonado.setColor(Color.black);
        grafico_escalonado.fillRect(0, 0, 520, 520);
        grafico_escalonado.setColor(java.awt.Color.black);
        Quicksort(A, p, q);
        for (int x = 0; x < 469; x++) {
            stop(50);
            grafico_escalonado.setColor(Color.blue);
            grafico_escalonado.drawLine(30 + x, 470, 30 + x, A[x]);
            System.out.print(" Arreglo escalonado Ordenado " + "<" + A[x] + ">");
            System.out.print("\n");
        }

    }

}