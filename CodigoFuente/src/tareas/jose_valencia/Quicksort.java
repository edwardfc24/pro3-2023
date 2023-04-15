import javax.swing.*;

public class Quicksort {
    public static void main(String[] args) {
        metodos metodo= new metodos();
        int[] miarray= metodo.generarArreglo(5);
        metodo.mostrarArreglo(miarray);
        System.out.println("pasamos a ordenarlo");
        int inicio= 0;
        int fin= miarray.length-1;


        metodos.dividirArr(miarray, 0, miarray.length-1);
        metodo.mostrarArreglo(miarray);

        System.out.println(metodo.obtenerTiempo());


        JFventana ventana = new JFventana(miarray);
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.add(ventana);
        frame.setVisible(true);
    }
}
