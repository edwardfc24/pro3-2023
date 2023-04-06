import java.util.Date;

public class metodos {
    public long obtenerTiempo() {
        return new Date().getTime();
    }
    public int generarNumeroAleatorio(int desde, int hasta) {
        return (int) (Math.random() * (hasta - desde + 1) + desde);
    }
    public int[] generarArreglo(int longitud) {
        int[] generado = new int[longitud];
        int limite = (int) (longitud * 1.5);
        for (int indice = 0; indice < generado.length; indice++) {
            generado[indice] = generarNumeroAleatorio(-limite, limite);
        }
        return generado;
    }
    public void mostrarArreglo(int[] arreglo) {
        System.out.print("[ ");
        for (int posicion = 0; posicion < arreglo.length; posicion++) {
            if (posicion != 0) System.out.print(", ");
            System.out.print(arreglo[posicion]);
        }
        System.out.println(" ]");
    }
    public static void dividirArr(int[] arreglo, int inicio , int fin ){
        if(inicio>=fin) return;
        int pivote= arreglo[inicio];
        int izquierda= inicio+1;                        //inicio
        int derecha  = fin   ;                          //fin
        while(izquierda <= derecha ){
            while(izquierda<=fin    && arreglo[izquierda]<pivote){
                izquierda++;
            }
            while(derecha>inicio   && arreglo[derecha]>=pivote){
                derecha--;
            }
            if (izquierda<derecha){
                int temp= arreglo[izquierda];
                arreglo[izquierda]= arreglo[derecha];
                arreglo[derecha]= temp;
                //izquierda++;
                //derecha--;
            }
        }
        if(derecha>inicio){
            int temp= arreglo[inicio];
            arreglo[inicio]= arreglo[derecha];
            arreglo[derecha]= temp;
        }
        dividirArr(arreglo, inicio, derecha-1);
        dividirArr(arreglo, derecha+1,fin);

    }
}
