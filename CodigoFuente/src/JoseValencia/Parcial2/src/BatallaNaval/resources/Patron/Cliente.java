package BatallaNaval.resources.Patron;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente {
    private static final Logger logger = LogManager.getLogger(Cliente.class);
    public static void main(String[] args) {

        ClienteObject cliente = new ClienteObject();
        cliente.enviarMensaje("Jugada 1: A,5", "localhost", 8080);

        /*
        ////////////////////////////botones negros
        JFrame frame = new JFrame("Panel de Botones Negros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(5, 7));
        JButton[][] botones = new JButton[5][7];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.BLACK);
                panel.add(botones[i][j]);
            }
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        */
        //////////////**********botones normales*********************
        JFrame frame = new JFrame("Panel de Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(5, 7));
        JButton[][] botones = new JButton[5][7];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                botones[i][j] = new JButton("(" + i + ", " + j + ")");
                botones[i][j].setBackground(Color.red);
                panel.add(botones[i][j]);
            }
        }

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                System.out.println("Botón seleccionado: " + source.getText());

                source.setEnabled(false); // Deshabilitar el botón actual
                desactivarSiguienteBoton(botones, obtenerFilaBoton(botones, source), obtenerColumnaBoton(botones, source));
            }
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                botones[i][j].addActionListener(actionListener);
            }
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);




    }
    private static int obtenerFilaBoton(JButton[][] botones, JButton boton) {
        for (int fila = 0; fila < botones.length; fila++) {
            for (int columna = 0; columna < botones[fila].length; columna++) {
                if (botones[fila][columna] == boton) {
                    return fila-1;
                }
            }
        }
        return -1; // Botón no encontrado
    }

    private static int obtenerColumnaBoton(JButton[][] botones, JButton boton) {
        for (int fila = 0; fila < botones.length; fila++) {
            for (int columna = 0; columna < botones[fila].length; columna++) {
                if (botones[fila][columna] == boton) {
                    return columna;
                }
            }
        }
        return -1; // Botón no encontrado
    }

    private static void desactivarSiguienteBoton(JButton[][] botones, int fila, int columna) {
        if (fila < botones.length - 1 || (fila == botones.length - 1 && columna < botones[fila].length - 1)) {
            botones[fila + 1][columna + 1].setEnabled(true);
            botones[fila + 1][columna + 1].setSelected(true);
            botones[fila + 1][columna + 1].setEnabled(false);
        }
    }

}
