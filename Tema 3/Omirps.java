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
                String reves = " ";
                 reves = omirp.toString(reves);
                
                 int i;
                for(i = reves.length()-1; i < 0; i--) {
                    reves = reves.charAt(i);
                }


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
