import java.util.Scanner;

public class Primo {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        boolean primo = true;

        System.out.println("Introduce un número para saber si es primo: ");
        numero = sc.nextInt();
        for (int i = 2; i <= numero/2; i++){
            if(numero % i == 0){
                primo = false;
            break; 
            }
        }

        if (primo) {
            System.out.println("El número es primo.");
        } else {
            System.out.println("El número no es primo.");
        }
        sc.close();
    }
}
