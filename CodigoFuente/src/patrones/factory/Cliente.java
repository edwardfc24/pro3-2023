package patrones.factory;

public class Cliente {
    private ProductoComida comida;

    public Cliente(FabricaComida fabrica) {
        comida = fabrica.crearComida();
    }

    public void ordenarComida() {
        comida.preparar();
        comida.cocinar();;
        comida.servir();
    }
}
