package Patrones.Factory.Calculadora;

public class Dividir implements Operacion{
    @Override
    public double calcular(double a, double b) {
        return a / b;
    }
}
