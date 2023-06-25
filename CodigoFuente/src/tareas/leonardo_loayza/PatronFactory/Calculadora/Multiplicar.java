package Factory.Calculadora;

public class Multiplicar implements Operacion{
    @Override
    public void calcular(double a, double b) {
        System.out.println(a*b);
    }
}
