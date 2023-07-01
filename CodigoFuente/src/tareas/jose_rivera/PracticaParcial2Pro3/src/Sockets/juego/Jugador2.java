package Sockets.juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Jugador2 extends JFrame implements ActionListener {

    private Color colorActual = Color.RED;
    private JButton[][] botones;
    private List<Barco> barcos;
    private RegistroDisparos registroDisparos;
    private int barcosRestantes;
    String jugada = "";

    public Jugador2() {
        super("Matriz de Botones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(650, 700);
        setLocationRelativeTo(null);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);

        add(panelBotones);

        botones = new JButton[10][10];
        barcos = new ArrayList<>(); // Inicialización de la lista de barcos
        registroDisparos = new RegistroDisparos();
        barcosRestantes = barcos.size();

        int tamanio_botones = 50;
        int xmargen = 1;
        int ymargen = 1;

        for (int fila = 0; fila < 10; fila++) {
            for (int colum = 0; colum < 10; colum++) {
                JButton boton = new JButton();

                int x = xmargen + colum * (tamanio_botones + xmargen);
                int y = ymargen + fila * (tamanio_botones + ymargen);

                boton.setBounds(x, y, tamanio_botones, tamanio_botones);

                String nombreImagen = "src/Sockets/juego/Imagen/mar.jpg";
                ImageIcon icono = new ImageIcon(nombreImagen);
                boton.setIcon(icono);
                boton.setMargin(new Insets(0, 0, 0, 0));
                boton.addActionListener(this);
                panelBotones.add(boton);
                botones[fila][colum] = boton;
            }
        }

        // Creación de los barcos y asignación de botones
        Barco barco1 = new Barco(1);
        barco1.agregarBotones(obtenerBotones(5, 0, 5, 1), "src/Sockets/juego/Imagen/barco5.png");
        barcos.add(barco1);

        Barco barco2 = new Barco(1);
        barco2.agregarBotones(obtenerBotones(2, 5, 4, 1), "src/Sockets/juego/Imagen/barco4.png");
        barcos.add(barco2);

        Barco barco3 = new Barco(1);
        barco3.agregarBotones(obtenerBotones(2, 7, 3, 1), "src/Sockets/juego/Imagen/barco3.jpg");
        barcos.add(barco3);

        Barco barco4 = new Barco(1);
        barco4.agregarBotones(obtenerBotones(6, 4, 2, 1), "src/Sockets/juego/Imagen/barco2.png");
        barcos.add(barco4);

        Barco barco5 = new Barco(1);
        barco5.agregarBotones(obtenerBotones(8, 0, 1, 1), "src/Sockets/juego/Imagen/barco1.png");
        barcos.add(barco5);

        JButton botonRestablecer = new JButton("Restablecer");
        botonRestablecer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restablecerBotones();
            }
        });
        botonRestablecer.setBounds(xmargen, ymargen + 10 * (tamanio_botones + ymargen), tamanio_botones * 5, tamanio_botones);
        panelBotones.add(botonRestablecer);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        boolean barcoEncontrado = false;
        for (Barco barco : barcos) {
            if (barco.contieneBoton(boton)) {
                barcoEncontrado = true;
                break;
            }
        }

        if (barcoEncontrado) {
            boton.setBackground(Color.GREEN);
            boton.setEnabled(false);
            boton.setIcon(null);
            System.out.println("El botón contiene un barco.");

            boolean todosBarcosCompletos = true;
            for (Barco b : barcos) {
                if (!b.isCompleto()) {
                    todosBarcosCompletos = false;
                    break;
                }
            }

            if (todosBarcosCompletos) {
                registroDisparos.mostrarRegistro();
                JOptionPane.showMessageDialog(null, "¡GANASTE! ¿Quieres jugar de nuevo?");
                int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Nuevo juego", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    restablecerBotones();
                } else {
                    System.exit(0);
                }
            }
        } else {
            boton.setBackground(Color.RED);
            boton.setEnabled(false);
            boton.setIcon(new ImageIcon("src/Sockets/juego/Imagen/mar.jpg"));
            System.out.println("El botón no contiene un barco.");
        }

        String jugada = obtenerJugada(boton);
        String[] partes = jugada.split(",");
        int fila = partes[0].charAt(0) - 'A';
        int columna = Integer.parseInt(partes[1]) - 1;
        registroDisparos.registrarJugada("Jugador 2", fila, columna);
    }


    public void restablecerBotones() {
        colorActual = Color.RED;
        for (int fila = 0; fila < 10; fila++) {
            for (int colum = 0; colum < 10; colum++) {
                JButton boton = botones[fila][colum];
                boton.setBackground(null);
                boton.setIcon(new ImageIcon("src/Sockets/juego/Imagen/mar.jpg"));
                boton.setEnabled(true);
            }
        }
    }

    private List<JButton> obtenerBotones(int x, int y, int ancho, int alto) {
        List<JButton> listaBotones = new ArrayList<>();
        for (int fila = y; fila < y + alto; fila++) {
            for (int colum = x; colum < x + ancho; colum++) {
                listaBotones.add(botones[fila][colum]);
            }
        }
        return listaBotones;
    }

    private String obtenerJugada(JButton boton) {
        int fila = -1;
        int columna = -1;
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (botones[i][j] == boton) {
                    fila = i;
                    columna = j;
                    break;
                }
            }
        }
        char letraFila = (char) (fila + 'A');
        int numeroColumna = columna + 1;
        return letraFila + "," + numeroColumna;
    }

    public static void main(String[] args) {
        new Jugador2();
    }
}
