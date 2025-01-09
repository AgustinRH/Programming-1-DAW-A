import java.util.Scanner;

public class PositivoNegativo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte un número positivo o negativo. ");
        double num = sc.nextDouble();

        if (num > 0) {
            System.out.println("El número es positivo.");
        } 
        else if (num < 0) {
            System.out.println("El número es negativo");
        }
        else {
            System.out.println("El número no es ni positivo ni negativo");
        }
        sc.close();
    }
}
