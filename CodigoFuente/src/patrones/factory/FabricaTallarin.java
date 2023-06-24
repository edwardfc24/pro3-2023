package patrones.factory;

public class FabricaTallarin extends FabricaComida {
    @Override
    ProductoComida crearComida() {
        return new Tallarin();
    }
}
