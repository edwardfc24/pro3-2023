package Factory.Calculadora;

public class Restar implements Operacion{
    @Override
    public void calcular(double a, double b) {
        System.out.println(a-b);
    }
}