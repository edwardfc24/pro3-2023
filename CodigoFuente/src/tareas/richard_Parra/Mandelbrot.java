package tareas.richard_Parra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

public class Mandelbrot extends JFrame implements ActionListener {
    //private double centerX, centerY; // coordenadas del centro del plano complejo
    private double scale; // factor de escala del zoom
    private int ancho;
    private int alto;
    private int[][] pixeles;
    private JButton btnZoom = new JButton("zoom");
    private int _maximoIteraciones;

    public Mandelbrot(int cantidadIteraciones){
        this._maximoIteraciones = cantidadIteraciones;
        ancho = 0;
        alto = 0;
        scale = 1;
        setTitle("Mandelbrot Básico");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        double xMinimo = -2;
        double xMaximo = 2;
        double yMinimo = -2;
        double yMaximo = 2;
        // obtenemos los limites de un dibujo
        int ancho = getWidth();
        int alto = getHeight();
        // dibujar fractal
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                double xCalculado = xMinimo + (xMaximo - xMinimo) * x / ancho;
                double yCalculado = yMinimo + (yMaximo - yMinimo) * y / alto;
                int color = ejecutarMandelbrot(xCalculado, yCalculado);
                g.setColor(new Color(color));
                g.fillRect(x,y,1,1);
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
    public void iniciarComponentes(){
        setLayout(null);
        btnZoom.setBounds(10,10,100,30);

        this.add(btnZoom);
        btnZoom.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnZoom){
            scale *= 1.1; // aumenta el factor de escala en un 10%

            // redimensiona el fractal para ajustarlo a la nueva escala
            ancho = (int) (ancho * scale);
            alto = (int) (alto * scale);

            // vuelve a dibujar el fractal con las nuevas dimensiones y escala
            ejecutarMandelbrot(ancho,alto);
        }
    }
}
