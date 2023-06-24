package Patrones.Factory.Calculadora;

public class FabricaMultiplicar extends FabricaCalculadora{
    @Override
    Operacion crearOperacion() {
        return new Multiplicar();
    }
}
