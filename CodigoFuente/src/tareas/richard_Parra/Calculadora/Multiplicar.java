package Patrones.Factory.Calculadora;

public class Multiplicar implements Operacion{
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}
