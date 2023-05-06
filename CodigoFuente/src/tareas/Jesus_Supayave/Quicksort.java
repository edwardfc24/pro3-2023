package tareas.Jesus_Supayave;

public class Quicksort {
    public static void main(String[] args) {

        //Ordenamiento metodo = new Ordenamiento();
        //int [] alterado = metodo.GenerarArreglo(10);
        //  long inicio = metodo.obtenerTiempo();
        //metodo.ordenarSimple(alterado);
        //long fin = metodo.obtenerTiempo();
        // metodo.mostrarArre(alterado);
        //System.out.print("tiempo de ejecucion en ms: " + (fin - inicio));

        int[] lista = {-3, 7, -2, 9, -1, 0,  8, 6, 5, 4};
        Ord.quicksort(lista, 0, lista.length - 1);

        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
    }
    }
}
