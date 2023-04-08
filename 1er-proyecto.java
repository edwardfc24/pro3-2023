//
///// ordenamiento QuickSort
//
//public class QuickSort {
//    private Panel panel;
//    private int[] arreglo;
//    private int length;
//
//    public QuickSort(Panel fr) {
//        this.panel = fr;
//    }
//
//    public void quickSort(int[] array) {
//        if (array == null || array.length == 0) {
//            return;
//        }
//        this.arreglo = array;
//        length = array.length;
//        quickSort(0, length - 1);
//
//    }
//
//    private void quickSort(int indiceMenor, int indiceMayor) {
//        int i = indiceMenor;
//        int j = indiceMayor;
//        int pivot = arreglo[indiceMenor + (indiceMayor - indiceMenor) / 2];
//        while (i <= j) {
//            while (arreglo[i] < pivot) {
//                i++;
//            }
//            while (arreglo[j] > pivot) {
//                j--;
//            }
//            if (i <= j) {
//                intercambiar(i, j);
//                i++;
//                j--;
//            }
//        }
//        if (indiceMenor < j)
//            quickSort(indiceMenor, j);
//        if (i < indiceMayor)
//            quickSort(i, indiceMayor);
//    }
//
//    private void intercambiar(int i, int j) {
//        int temp = arreglo[i];
//        arreglo[i] = arreglo[j];
//        arreglo[j] = temp;
//        panel.setNumeros(arreglo);
//    }
//}
//
//
//// ordenamiento bubblesort
//
//public class BubbleSort {
//
//    private Panel panel;
//
//    public BubbleSort(Panel fr) {
//        this.panel = fr;
//    }
//
//    public void metodoBubbleSort(int[] arreglo) {
//
//        int temporal;
//        for (int i = 0; i <arreglo.length ; i++) {
//            for (int j = 1; j < (arreglo.length - i); j++) {
//                if (arreglo[j - 1] > arreglo[j]) {
//                    temporal = arreglo[j - 1];//0= 4  4=4
//                    arreglo[j - 1] = arreglo[j]; // 4 = 7 == 7 =7
//                    arreglo[j] = temporal; // 7 =4 4 =4
//                    panel.setNumeros(arreglo);
//                }
//            }
//        }
//    }
//}
//
//
//
////clase panel
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.Arrays;
//
//public class Panel extends JPanel implements Runnable {
//
//    private int  ancho = 50;
//    private int[] numeros = {6,11,-2,5,7,-7,1,28,10};     //  -7 -2 1 5 6 7 10 11 28
//    private BubbleSort bubble = new BubbleSort(this);
//    private QuickSort quick = new QuickSort(this);
//
//    public Panel() {
//        setLayout(null);
//        this.setSize(600, 500);
//        this.setPreferredSize(getSize());
//        //llenarArray();
//    }
//
//
//    public void dibujarArray(Graphics g, int x, int y) {
//
//        for (Integer num: numeros) {
//            g.drawRect(x, y, ancho, num);
//            x += ancho + 10;
//        }
//    }
//
//
//    @Override
//    public void run() {
//        quick.quickSort(numeros);
//        //bubble.bubbleSort(numeros);
//    }
//
//    public void setNumeros(int[] numeros) {
//        this.numeros = numeros;
//        repaint();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(Arrays.toString(numeros));
//    }
//
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        dibujarArray(g, 20, 200);
//    }
//
//}
//
//
/////Clase principal
//
//import javax.swing.*;
//public class Main extends JFrame {
//    private JPanel panel = new Panel();
//    public Main() {
//        init();
//        Thread hilo = new Thread((Runnable) panel);
//        hilo.start();
//    }
//    private void init() {
//        setLayout(null);
//        this.setSize(600,500);
//        this.setTitle("Primera Tarea");
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.getContentPane().add(panel);
//        this.setLocationRelativeTo(null);
//    }
//
//    public static void main(String[] args) {
//        Main main = new Main();
//        main.setVisible(true);
//    }
//}

