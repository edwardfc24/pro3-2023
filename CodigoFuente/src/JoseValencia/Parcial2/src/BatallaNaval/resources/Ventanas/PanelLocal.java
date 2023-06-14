package BatallaNaval.resources.Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLocal extends JPanel {
    public int getContadorBarcos() {
        return contadorBarcos;
    }

    public void setContadorBarcos(int contadorBarcos) {
        this.contadorBarcos = contadorBarcos;
    }
    private int contadorBarcos;

    public PanelLocal(){
        contadorBarcos= 4;
        this.setLayout(new GridLayout(5, 7));
        this.setSize(400, 300);

        JButton[][] botones = new JButton[5][7];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setBackground(Color.blue);
                this.add(botones[i][j]);
            }
        }
        /*////////
        //JButton[][] botones = new JButton[5][7];

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                JButton boton = new JButton();
                //boton.setBackground(Color.WHITE);
                botones[fila][columna] = boton;

                this.add(botones[fila][columna]);

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boton.setEnabled(false);
                        int botonPresionado = obtenerNumeroBotonPresionado(botones, boton);
                        if (botonPresionado == 1) {
                            desactivarBotones(botones, 5);
                        } else if (botonPresionado == 2) {
                            desactivarBotones(botones, 3);
                        } else if (botonPresionado == 3) {
                            boton.setEnabled(true);
                        }
                    }
                });


            }
        }
        */
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                contadorBarcos--;
                System.out.println(contadorBarcos);

                source.setEnabled(false); // Deshabilitar el botón actual
                source.setBackground(Color.yellow);
                desactivarSiguienteBoton(botones, obtenerFilaBoton(botones, source), obtenerColumnaBoton(botones, source));
                /////******queriahacer algo, no me acuerodo que ******/////
                if(source.getBackground() == Color.yellow){
                }
            }

        };
        System.out.println(contadorBarcos);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                botones[i][j].addActionListener(actionListener);
            }
        }
    }

    private static void desactivarBotones(JButton[][] botones, int cantidad) {
        int contador = 0;
        for (int fila = 0; fila < botones.length; fila++) {
            for (int columna = 0; columna < botones[fila].length; columna++) {
                if (botones[fila][columna].isEnabled()) {
                    botones[fila][columna].setEnabled(false);
                    botones[fila][columna].setBackground(Color.BLUE);

                    contador++;
                    if (contador == cantidad) {
                        return;
                    }
                }
            }
        }
    }

    private static int obtenerNumeroBotonPresionado(JButton[][] botones, JButton boton) {
        int contador = 0;
        for (int fila = 0; fila < botones.length; fila++) {
            for (int columna = 0; columna < botones[fila].length; columna++) {
                contador++;
                if (botones[fila][columna] == boton) {
                    return contador;
                }
            }
        }
        return -1; // Botón no encontrado
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
            botones[fila + 1][columna + 1].setBackground(Color.yellow);
            botones[fila + 1][columna + 1].setEnabled(false);
        }

    }


}
