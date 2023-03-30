package recursividad;

public class OrdenarApp {
    public static void main(String[] args) {    
        Ordenamiento algoritmo = new Ordenamiento();
        int[] desorden = algoritmo.generarArreglo(15000);
        long inicio = algoritmo.obtenerTiempo();
        algoritmo.ordenarSimple(desorden);
        long fin = algoritmo.obtenerTiempo();
        System.out.println("Tiemppo de ejecución en ms: " + (fin - inicio));
        algoritmo.mostrarArreglo(desorden);
    }
}
