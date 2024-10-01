import java.util.Scanner;

public class IntercambiarVariables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Intercambia los números.");

        System.out.println("Inserte el valor de 'A': ");
        int a = sc.nextInt();

        System.out.println("Inserte el valor de 'B' :");
        int b = sc.nextInt();

        int c = a;

        a = b;

        System.out.println("El valor de 'A' es " + a + " .");
        System.out.println("El valor de 'B' es " + c + " .");

        sc.close();
    }
}
