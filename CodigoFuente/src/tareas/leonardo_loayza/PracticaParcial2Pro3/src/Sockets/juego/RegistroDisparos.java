package Sockets.juego;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class RegistroDisparos extends JFrame {
    private JTextArea textArea;
    private List<String> jugadas;

    public RegistroDisparos() {
        super("Registro de Disparos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 400);
        jugadas = new ArrayList<>();
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);
    }

    public void registrarJugada(String jugador, int fila, int columna) {
        String jugada = jugador + " está disparando en la posición " + fila + "," + columna;
        textArea.append(jugada + "\n");
    }
    public void mostrarRegistro() {
        for (String jugada : jugadas) {
            System.out.println(jugada);
        }
    }

}
