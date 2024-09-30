import java.util.Scanner;

public class Omirps {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int omirp;

        System.out.println("Introduce un número: ");
        omirp = sc.nextInt();
        boolean primo = true;

        for(int i = 0; i <= omirp; i++) {
            for(int j = 2; j <= omirp/2;) {
                if(omirp % j == 0) {
                    primo = false;
                break;
                }
            }
            if (primo) {
                // DAR la Vuelta al número

            }
        }
        // Comprobaciones para el funcionamiento de los primos.
        /*if (primo) {
            System.out.println("Es primo" + omirp);
        } else {
            System.out.println("No es primo" + omirp);
        }*/
    }
}
