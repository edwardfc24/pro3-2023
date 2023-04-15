package tareas.richard_Parra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

public class Mandelbrot extends JFrame implements ActionListener {
    private int[][] pixeles;
    double xMinimo = -2;
    double xMaximo = 2;
    double yMinimo = -2;
    double yMaximo = 2;
    JPanel panelBotones = new JPanel();
    private JButton btnZoom = new JButton("Zoom");
    private JButton btnAlejarse = new JButton("Alejarse");
    private int _maximoIteraciones;

    public Mandelbrot(int cantidadIteraciones){
        this._maximoIteraciones = cantidadIteraciones;
        setTitle("Mandelbrot Básico");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        // Agregar botones de zoom
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        // Establece el tamaño del botón
        btnZoom.setPreferredSize(new Dimension(100, 50));
        btnAlejarse.setPreferredSize(new Dimension(100,50));

        btnZoom.addActionListener(this);
        btnAlejarse.addActionListener(this);

        panelBotones.add(btnZoom);
        panelBotones.add(btnAlejarse);

        add(panelBotones, BorderLayout.NORTH);
        panelBotones.setLayout(new FlowLayout());
    }

    @Override
    public void paint(Graphics g) {
        // obtenemos los limites de un dibujo
        int ancho = getWidth();
        int alto = getHeight();
        // dibujar fractal
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                double xCalculado = xMinimo + (xMaximo - xMinimo) * x / ancho;
                double yCalculado = yMinimo + (yMaximo - yMinimo) * y / alto;
                int color = ejecutarMandelbrot(xCalculado, yCalculado);
                if (color == 255){
                    g.setColor(Color.ORANGE);
                }else{
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, 1, 1);
            }
        }
        //repaint();
    }


    private int ejecutarMandelbrot(double x, double y){
        //primero fijamos la constante imaginaria
        double realCalculado = x;
        double imaginarioCalculado = y;
        //NumeroComplejo c = new NumeroComplejo(x, y);
        //inicializamos el numero complejo con 0
        //NumeroComplejo z = new NumeroComplejo(0,0);
        // inicializamos el bucle que busca llegar al maximo de iteraciones
        for (int iteracion = 0; iteracion < _maximoIteraciones; iteracion++) {
            double realCuadrado  = realCalculado * realCalculado;
            double imaginarCuadrada = imaginarioCalculado * imaginarioCalculado;
            if (realCuadrado + imaginarCuadrada > 4){
                return iteracion;
            }
            realCalculado = realCuadrado - imaginarCuadrada + x;
            imaginarioCalculado = 2 * realCalculado * imaginarioCalculado + y;
        }
        return 255;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // calcular los nuevos limites del fractal
        double nuevoXMin = xMinimo;
        double nuevoXMax = xMaximo;
        double nuevoYMin = yMinimo;
        double nuevoYMax = yMaximo;
        if (e.getSource() == btnZoom){// Si se presionó el botón de acercar
            double factor = 0.1;
            nuevoXMin += (xMaximo - xMinimo) * factor;
            nuevoXMax -= (xMaximo - xMinimo) * factor;
            nuevoYMin += (yMaximo - yMinimo) * factor;
            nuevoYMax -= (yMaximo - yMinimo) * factor;
        } else if (e.getSource() == btnAlejarse){// Si se presionó el botón de disminuir
            double factor = 0.1;
            nuevoXMin -= (xMaximo - xMinimo) * factor;
            nuevoXMax += (xMaximo - xMinimo) * factor;
            nuevoYMin -= (yMaximo - yMinimo) * factor;
            nuevoYMax += (yMaximo - yMinimo) * factor;
        }
        // Actualizar los límites del fractal
        xMinimo = nuevoXMin;
        xMaximo = nuevoXMax;
        yMinimo = nuevoYMin;
        yMaximo = nuevoYMax;

        repaint();
    }
}
