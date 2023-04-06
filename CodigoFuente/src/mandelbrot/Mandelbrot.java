package mandelbrot;

import javax.swing.*;
import java.awt.*;

public class Mandelbrot extends JFrame {
    private int _maximoIteraciones;

    public Mandelbrot(int cantidadIteraciones) {
        this._maximoIteraciones = cantidadIteraciones;
        setTitle("Mandelbrot Básico");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        double xMin = -2;
        double xMax = 2;
        double yMin = -2;
        double yMax = 2;
        // Obtenemos los l[imites de dibujo
        int ancho = getWidth();
        int alto = getHeight();
        // Dibujar el fractal
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                double xCalculado = xMin + (xMax - xMin) * x / ancho;
                double yCalculado = yMin + (yMax - yMin) * y / alto;
                int color = ejecutarMandelbrot(xCalculado, yCalculado);
                g.setColor(new Color(color));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    private int ejecutarMandelbrot(double x, double y) {
        // Primero fijamos la constante imaginaria
        double realCalculado = x;
        double imaginarioCalculado = y;
        //NumeroComplejo c = new NumeroComplejo(x, y);
        // Inicializamos el numero complejo con0
        //NumeroComplejo z = new NumeroComplejo(0, 0);
        // Inicializamos el bucle que busca llegar al maximo numero de iteraciones
        for (int iteracion = 0; iteracion < _maximoIteraciones; iteracion++) {
            double realCuadrado = realCalculado * realCalculado;
            double imaginarioCuadrado = imaginarioCalculado * imaginarioCalculado;
            if (realCuadrado + imaginarioCuadrado > 4) {
                return iteracion;
            }
            realCalculado = realCuadrado - imaginarioCuadrado + x;
            imaginarioCalculado = 2 * realCalculado * imaginarioCalculado + y;
        }
        return 255;
    }
}

















