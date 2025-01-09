import java.util.Scanner;

public class Programa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int before = 0;
        int now;

        System.out.println("Introduce números enteros. Si deseas terminar introduce un número negativo");

        do {
            System.out.print("Introduce un número: ");
            now = sc.nextInt();

            if (now >= 0) {
                System.out.println("La suma es: " + (before + now));
            }

            before = now;
        } while (now >= 0);

        System.out.println("Saliendo...");
        sc.close();
    }
}
