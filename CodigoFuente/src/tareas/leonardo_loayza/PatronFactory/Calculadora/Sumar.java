package Factory.Calculadora;

public class Sumar implements Operacion{
    @Override
    public void calcular(double a, double b) {
        System.out.println(a+b);
    }
    public Sumar(){

    }
}
