package mandelbrot;

public class NumeroComplejo {
    private double real;
    private double imaginario;

    public NumeroComplejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public double obtenerValorAbsoluto() {
        return Math.sqrt((real * real) + (imaginario * imaginario));
    }

    public NumeroComplejo obtenerCuadrado() {
        double realCalculado = (real * real) - (imaginario * imaginario);
        double imaginarioCalculado = 2 * real * imaginario;
        return new NumeroComplejo(realCalculado, imaginarioCalculado);
    }

    public NumeroComplejo sumarComplejos(NumeroComplejo extension) {
        double realCalculado = real + extension.real;
        double imaginarioCalculado = imaginario + extension.imaginario;
        return new NumeroComplejo(realCalculado, imaginarioCalculado);
    }
}













