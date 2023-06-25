package Factory.Calculadora;

public class Cliente {
    public double a;
    public double b;
    private Operacion operacion;

    public Cliente(FabricaCalculadora calculadora) {
        this.operacion = calculadora.crearOperacion();
    }

    public void ordenarOperacion(){
        operacion.calcular(a,b);
    }
}
