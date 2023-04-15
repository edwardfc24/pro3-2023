package tareas.leonardo_loayza;

import javax.swing.*;
import java.awt.*;
public class Sierpinsky extends JFrame {
    public Sierpinsky(){
        super("Alfombra de Sierpinski");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(false);
        setVisible (true);

    }
    private int dibujarSierpinski(Graphics g, int x, int y, int longitud , int ancho, int num) {
        if (num == 0) {
            return 1;
        }
        int temp = x;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    g.fillRect(x, y, longitud , ancho);
                }else
                    g.drawRect(x, y, longitud , ancho);
                dibujarSierpinski(g, x, y, longitud  / 3, ancho / 3, num - 1);
                x += longitud;
            }
            x = temp;
            y += ancho;
        }
        return 1;
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        this.dibujarSierpinski(g, 0, 0, this.getWidth(), this.getWidth(),2);
    }
    public static void main(String[] args) {
        new Sierpinsky();
    }
}