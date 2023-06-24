package recursividad;

public class Practicas {

    public static void main(String[] args) {
        String[] prueba = {"chau", "a", "los", "primeros", "puntos"};
        //recorreArreglo(prueba, 0);
        // hacerManilla(10, 1);
        String mensaje = "Al reves";
        //System.out.println(invertirPalabras(mensaje));
        System.out.println(invertirMensaje(mensaje, 0, ""));
    }

    // A través de un método recursivo recorrer un arreglo y mostrar su contenido
    public static void recorreArreglo(String[] mensaje, int posicion) {
        if (posicion < mensaje.length) {
            System.out.println(mensaje[posicion]);
            recorreArreglo(mensaje, posicion + 1);
        }
    }

    public static void hacerManilla(int longitud, int posicion) {
        if (posicion <= longitud) {
            if (posicion % 2 == 1)
                System.out.println(" # ");
            else
                System.out.println("# #");
            hacerManilla(longitud, posicion + 1);
        }
    }

    public static String invertirPalabras(String mensaje) {
        if (mensaje.length() == 1)
            return mensaje;
        return invertirPalabras(mensaje.substring(1)) + mensaje.substring(0, 1);
    }

    public static String invertirMensaje(String mensaje, int posicion, String invertido) {
        if (posicion < mensaje.length()) {
            invertido += mensaje.substring(posicion, posicion + 1);
            return invertirMensaje(mensaje, posicion + 1, invertido);
        }
        return invertido;
    }


}