public class Ord {

    public static void quicksort(int[] lista, int izq, int der) {
        if (izq < der) {
            int pivote = particion(lista, izq, der);
            quicksort(lista, izq, pivote - 1);
            quicksort(lista, pivote + 1, der);
        }
    }

    public static int particion(int[] lista, int izq, int der) {
        int pivote = lista[izq];
        int i = izq + 1;
        int j = der;

        while (i <= j) {
            while (i <= j && lista[i] <= pivote) {
                i++;
            }

            while (i <= j && lista[j] > pivote) {
                j--;
            }

            if (i < j) {
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        int temp = lista[izq];
        lista[izq] = lista[j];
        lista[j] = temp;

        return j;
    }


}