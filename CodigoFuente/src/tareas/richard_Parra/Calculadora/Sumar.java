package Patrones.Factory.Calculadora;

public class Sumar implements Operacion{
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}
