package tareas.Jesus_Supayave;

import javax.swing.*;
import java.awt.*;

public class Sierpinski extends JPanel {
    private final int dimencion = 513;
    private final int margen = 20;
    static Color colorRelleno;

    static Color colorFondo;
    private  int limite = dimencion;

    public sierpinski(){
        setPreferredSize(new Dimension(dimencion + 2 * margen, dimencion + 2 * margen)); // tamaño preferido
        setBackground(colorFondo);
        setForeground(colorRelleno);
        new Timer(2000 , (ActiveEvent ) -> { //Permite programar una serie de threads(hilos) para que se ejecuten al cabo de cierto tiempo
            limite /= 3;
            if(limite <= 3)
                limite = dimencion;
            repaint();  //repintar
        }).start(); //método especial que invoca a run()
    }
    void dibujarAlfombra(Graphics2D g , int x, int y, int  size){         //void porque no tiene retorno
        if(size< limite){

            size /= 3;

            for (int i = 0; i < 9; i++) {
                if( i == 4){
                    g.fillRect(x+ size , y + size, size, size); //fillRect dibuja el rectángulo pintando su interior del color seleccionado
                } else {
                    dibujarAlfombra (g, x + (i % 3) * size, y + (i / 3) * size, size);
                }
            }
        }
    }

    public void paintComponent(Graphics gg){
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //define y administra colecciones de claves y valores asociados
        g.translate(margen,margen); //mueve cada elemento una distancia dada en una dirección también dada
        dibujarAlfombra(g,0,0,dimencion);
    }
}
