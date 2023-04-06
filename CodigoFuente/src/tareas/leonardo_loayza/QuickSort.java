package tareas.leonardo_loayza;

import java.awt.*;

public class QuickSort {

    private Panel panel;
    private int[] arreglo;
    private int length;

    public QuickSort(Panel fr) {
        this.panel = fr;
    }

    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.arreglo = array;
        length = array.length;
        quickSort(0, length - 1);

    }

    private void quickSort(int indiceMenor, int indiceMayor) {
        int i = indiceMenor;
        int j = indiceMayor;
        int pivot = arreglo[indiceMenor + (indiceMayor - indiceMenor) / 2];
        while (i <= j) {
            while (arreglo[i] < pivot) {
                i++;
            }
            while (arreglo[j] > pivot) {
                j--;
            }
            if (i <= j) {
                intercambiar(i, j);
                i++;
                j--;
            }
        }
        if (indiceMenor < j)
            quickSort(indiceMenor, j);
        if (i < indiceMayor)
            quickSort(i, indiceMayor);
    }

    private void intercambiar(int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
        panel.setNumeros(arreglo);
    }
}
