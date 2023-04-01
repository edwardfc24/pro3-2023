package tareas.leonardo_loayza;

import java.awt.*;

public class BubbleSort {

    private Panel panel;

    public BubbleSort(Panel fr) {
        this.panel = fr;
    }

    public void metodoBubbleSort(int[] arreglo) {

        int temporal;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j < (arreglo.length - i); j++) {
                if (arreglo[j - 1] > arreglo[j]) {
                    temporal = arreglo[j - 1];//0= 4  4=4
                    arreglo[j - 1] = arreglo[j]; // 4 = 7 == 7 =7
                    arreglo[j] = temporal; // 7 =4 4 =4
                    panel.setNumeros(arreglo);
                }
            }
        }
    }
}
