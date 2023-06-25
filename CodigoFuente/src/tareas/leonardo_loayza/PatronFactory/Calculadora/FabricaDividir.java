package Factory.Calculadora;

public class FabricaDividir extends FabricaCalculadora{
    @Override
    Operacion crearOperacion() {
        return new Dividir();
    }
}
