package Factory.Calculadora;

public class AppCalculadora {
    public static void main(String[] args) {
        FabricaSumar fabricaSumar = new FabricaSumar();
        Operacion sumar = fabricaSumar.crearOperacion();

        Cliente cliente = new Cliente(fabricaSumar);

        cliente.ordenarOperacion();
    }
}
