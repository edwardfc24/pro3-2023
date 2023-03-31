import java.util.Scanner;
public class tarea2 {

        public static void main(String[] args) {

            System.out.println("ingrese un numero: ");
            Scanner tcd = new Scanner(System.in);
            int numero = tcd.nextInt();
            tcd.close();
            System.out.println("su numero de fibonacci es : " + fibonacci_recursividad(numero));
            System.out.println("Y su sucesion fibonacc es : ");
            for (int i = 0; i < numero; i++) {

                System.out.print(" " + fibonacci_recursividad(i));
            }
        }
        public static int fibonacci_recursividad(int numero) {
            if ((numero == 0) || (numero == 1))
                return numero;
            else
                return fibonacci_recursividad(numero - 1) + fibonacci_recursividad(numero - 2);
        }

    }
