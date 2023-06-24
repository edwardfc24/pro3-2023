package Patrones.Factory.Calculadora;

public class FabricaRestar extends FabricaCalculadora{
    @Override
    Operacion crearOperacion() {
        return new Restar();
    }
}
