package Mandelbrot.zoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MandelBrotZoom extends JFrame {
    private int _maximoIteraciones;
    private double xMin =  -2;   // limite real(-2,2)  a
    private double xMax = 2;
    private double yMin = -2;  // limite imaginario (-2i,2i)
    private double yMax = 2;

    private int _ancho = 800;
    private int _alto = 600;

    private double zoomAcercar = 0.5; // factor de hacer zoom un 50%
    private boolean estaHaciendoZoom = false;

    public MandelBrotZoom(int cantidadIteraciones) {
        this._maximoIteraciones = cantidadIteraciones;
        setTitle("Mandelbrot Básico");
        setSize(_ancho, _alto);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    estaHaciendoZoom = true;
                    double x = xMin + (xMax - xMin) * e.getX() / _ancho;
                    double y = yMin + (yMax - yMin) * e.getY() / _alto;
                    Acercarse(x, y);

                }
            }
        });

    }


    private void Acercarse(double x, double y) {
        double nuevoAncho = (xMax - xMin) * zoomAcercar;
        double nuevoAlto = (yMax - yMin) * zoomAcercar;
        xMin = x - nuevoAncho / 2;
        xMax = x + nuevoAncho / 2;
        yMin = y - nuevoAlto /2;
        yMax = y + nuevoAlto / 2;
        repaint();
    }


    private int ejecutarMandelbrot(double x, double y) {


        double realCalculado = x;

        double imaginarioCalculado = y;


        for (int iteracion = 0; iteracion < _maximoIteraciones; iteracion++) {

            double realCuadrado = realCalculado * realCalculado;

            double imaginarioCuadrado = imaginarioCalculado * imaginarioCalculado;


            if (realCuadrado + imaginarioCuadrado  > 4) {

                // - Si la condición anterior es verdadera, se devuelve el número actual de iteraciones.
                return iteracion;
            }
            // Si la condición anterior es falsa, se actualiza el valor de realCalculado.

            realCalculado = realCuadrado - imaginarioCuadrado + x;

            // Se actualiza el valor de imaginarioCalculado.
            imaginarioCalculado = 2 * realCalculado * imaginarioCalculado + y;
        }

        return _maximoIteraciones;
    }


    public void paint(Graphics g) {

        // Dibujar el fractal

        for (int x = 0; x < _ancho; x++) { // horizontal o columna x
            for (int y = 0; y < _alto; y++) { // vertical o fila y
                double xCalculado = xMin + (xMax - xMin) * x / _ancho;
                double yCalculado = yMin + (yMax - yMin) * y / _alto;

                int color = ejecutarMandelbrot(xCalculado, yCalculado);

                if (color == _maximoIteraciones) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        new MandelBrotZoom(1000);
    }


}
