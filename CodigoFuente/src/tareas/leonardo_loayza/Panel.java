package tareas.leonardo_loayza;
/// ordenamiento QuickSort

import tareas.leonardo_loayza.QuickSort;

import javax.swing.*;
import java.awt.*;


// ordenamiento bubblesort


//clase panel

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable {

    private int ancho = 50;
    private int[] numeros = {6, 11, -2, 5, 7, -7, 1, 28, 10};     //  -7 -2 1 5 6 7 10 11 28
    private BubbleSort bubble = new BubbleSort(this);
    private QuickSort quick = new QuickSort(this);

    public Panel() {
        setLayout(null);
        this.setSize(600, 500);
        this.setPreferredSize(getSize());
        //llenarArray();
    }


    public void dibujarArray(Graphics g, int x, int y) {

        for (Integer num : numeros) {
            g.drawRect(x, y, ancho, num);
            x += ancho + 10;
        }
    }


    @Override
    public void run() {
        //quick.quickSort(numeros);
        bubble.metodoBubbleSort(numeros);
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


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        dibujarArray(g, 20, 200);
    }

}

