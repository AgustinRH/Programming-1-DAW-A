import java.util.Scanner;

public class Programa2 {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        boolean control = true;
        int num, suma = 0;

        while(control) {
            System.out.println("Inserte un número: ");
            num = sc.nextInt();
            if (num < 0 ) {
                control = false;
                System.out.println("Saliendo del programa...");
            } else {
            suma += num;
            System.out.println("El total es " + suma);
            }
            

        }
        sc.close();
    }
}
