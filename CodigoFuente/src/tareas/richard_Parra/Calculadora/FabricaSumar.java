package Patrones.Factory.Calculadora;

public class FabricaSumar extends FabricaCalculadora{
    @Override
    Operacion crearOperacion() {
        return new Sumar();
    }
}
