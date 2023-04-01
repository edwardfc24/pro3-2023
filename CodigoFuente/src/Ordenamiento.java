import java.util.Date;
public class Ordenamiento{


    public long obtenerTiempo(){
        return  new Date().getTime();
    }

    public void Intercambiar (int []arreglo, int izq, int der){

        int pivote = arreglo[izq];
        int inicio = izq;               //busqueda de izq a der(abajo hacia arriba)
        int fin = der;                  //busqueda de der a izq (arriba hacia abajo)


        while(inicio < fin){                        // no se crucen en la busqueda
            while (arreglo[izq] < pivote && inicio < fin) inicio++; {   // elemento mayor al pivote
                while (arreglo[der]> pivote ) der--; {
                    if( inicio < fin){
                        int temporal = arreglo[inicio];
                        arreglo[inicio] = arreglo[der];
                        arreglo[der] = temporal;
                    }
                }
                arreglo[izq] = arreglo[der];
                arreglo[der] = pivote;
            }
            if(izq < fin-inicio)
                Intercambiar(arreglo, izq, pivote +1);
            if (fin + inicio < der)
                Intercambiar(arreglo, pivote -1, der);
        }
    }


}










