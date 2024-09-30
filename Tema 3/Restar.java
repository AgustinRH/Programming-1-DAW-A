import java.util.Scanner;

public class Restar {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserte 1 número");
        double num1 = sc.nextDouble();

        System.out.println("Inserte otro número");
        double num2 = sc.nextDouble();
        double resta;
        if (num1 > num2) {
            resta = num1 - num2;
        } else {
            resta = num2 - num1;
        }

        System.out.println("El resultado de la resta del mayor por el menor es " + resta + " .");
    }
}
