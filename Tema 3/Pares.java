import java.util.Scanner;

public class Pares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;
        System.out.println("Inserta el valor de A");
        a = sc.nextInt();
        System.out.println("Inserta el valor de B");
        b = sc.nextInt();
        if (a < b) {
            if (a % 2 == 0) {
                System.out.println("Los números pares entre " + a + " y " + b + " son:");
                for (int i = a; i < b; i = i + 2) {
                    System.out.println(i);
                }
            } else {
                a = a + 1;
                System.out.println("Los números pares entre " + a + " y " + b + " son:");
                for (int i = a; i < b; i = i + 2) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("El valor de A debe ser menor al valor de B");
        }

        sc.close();
    }
}
