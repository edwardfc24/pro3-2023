package tareas.Jesus_Supayave;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class AppSierpinski {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("--------");
        frame.setResizable(false);
        frame.add(new sierpinski(), BorderLayout.CENTER); //(de borde) proporciona un esquema más complejo de colocación de los Componentes en un panel
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        Color color1= Color.BLUE;
        Color color2= Color.RED;
        Color color3= Color.ORANGE;

        Color color4 = Color.BLACK;
        Color color5 = Color.YELLOW;
        Color color6 = Color.GREEN;

        System.out.println("Elige el color del relleno de la figura a realizar: ");
        Scanner leer = new Scanner(System.in);

        System.out.println("Elige el color del fondo de la figura a realizar: ");
        Scanner fondo = new Scanner(System.in);

        String elegidos = leer.nextLine();
        if(elegidos.equals("azul")){
            Color colorRelleno = color1;
        }
        if(elegidos.equals("rojo")){
            Color colorRelleno = color2;
        }
        if (elegidos.equals("naranja")){
            Color colorRelleno= color3;
        }

        String elegifo = fondo.nextLine();
        if (elegidos.equals("negro")){
            Color colorFondo = color4;
        }
        if (elegidos.equals("amarillo")){
            Color colorFondo = color5;
        }
        if (elegidos.equals("verde")){
            Color colorFondo = color6;
        }
    }
}


