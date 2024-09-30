import java.util.Scanner;

public class Impares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos al usuario el valor de A y de B
        int a, b;
        System.out.println("Inserta el valor de A");
        a = sc.nextInt();
        System.out.println("Inserta el valor de B");
        b = sc.nextInt();

        // Comprobamos si A es menor que B para sacar los números impares.
        if (a < b) {
            if (a % 2 != 0) {
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
        } else if (a > b) {      // Comprobamos si B es menor que A para sacar los números impares.
            int aux = 0;

            aux = a;
            a = b;
            b = aux;

            if (a % 2 != 0) {
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
        } else { // Comprobamos que los números no sean iguales.
            System.out.println("Los números son iguales. No puedo obtener ningún número impar.");
        }
    }
}
