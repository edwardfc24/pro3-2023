package Patrones.Factory.Calculadora;

public class Restar implements Operacion{
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}
