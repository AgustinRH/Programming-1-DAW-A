import java.util.Scanner;

public class IntercambioDeTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Intercambia los números.");

        System.out.println("Inserte el valor de 'A': ");
        int a = sc.nextInt();

        System.out.println("Inserte el valor de 'B' :");
        int b = sc.nextInt();

        System.out.println("Inserte el valor de 'C' :");
        int c = sc.nextInt();
        
        int e = a;

        a = b;
        b = c;
        c = e;
        System.out.println("El valor de 'A' es " + a + " .");
        System.out.println("El valor de 'B' es " + b + " .");
        System.out.println("El valor de 'C' es " + c + " .");

        sc.close();
    }
}
