package Patrones.Factory.Calculadora;

public class AppCalculadora {
    public static void main(String[] args) {
        // crear una fabrica para realizar la suma, resta, multiplicacion y divicion.
        FabricaCalculadora FabricaSuma = new FabricaSumar();
        Operacion suma = FabricaSuma.crearOperacion();
        double resultado = suma.calcular(2,6);
        System.out.println("Suma: "  + resultado);
        System.out.println("-----------");
        /////////////////////////////////////////////////////
        FabricaCalculadora FabricaResta = new FabricaRestar();
        Operacion resta = FabricaResta.crearOperacion();
        double resultadoResta = resta.calcular(4,3);
        System.out.println("Resta: " + resultadoResta);
    }
}
