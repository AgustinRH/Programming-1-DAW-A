import java.util.Scanner;

public class Eratostenes {
    public static void main (String [] args) {

        
        // Hacemos un bucle para comprobar todos los números desde el 2 al 2000
        for (int numero = 2; numero < 1000; numero++) {
            boolean primo = true;

            //Comprobamos si el número es primo o no. Debemos usar el cuadrado de ese numero ya que si usamos la variable número entraría y saldría del bucle.
            for (int j = 2; j <= numero/2; j++) {
                if (numero % j == 0) {
                    primo = false;
                    break;
                }
            }
            if(primo) {
                System.out.println(numero);
            }
        }
    }
}
