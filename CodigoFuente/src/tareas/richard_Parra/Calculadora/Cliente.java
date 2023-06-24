package Patrones.Factory.Calculadora;

public class Cliente {
    private Operacion operacion;

    public Cliente(FabricaCalculadora calculadora){
        operacion = calculadora.crearOperacion();
    }

    public void ordenarOperacion(){
        operacion.calcular(0,0);

    }
}
