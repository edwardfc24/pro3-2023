package tareas.leonardo_loayza;

import javax.swing.*;

public class Main extends JFrame {
    private JPanel panel = new Panel();

    public Main() {
        init();
        Thread hilo = new Thread((Runnable) panel);
        hilo.start();
    }

    private void init() {
        setLayout(null);
        this.setSize(600, 500);
        this.setTitle("Primera Tarea");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
