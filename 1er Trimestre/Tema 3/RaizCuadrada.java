import java.util.Scanner;

public class RaizCuadrada {

    public static void main(String[] args) {
        System.out.println("Inserte un número para conocer su raiz cuadrada.");
        Scanner sc = new Scanner(System.in);

        double num = sc.nextDouble();
        double numCuadrado;

        if (num > 0) {
            numCuadrado = Math.sqrt(num);
            System.out.println("El cuadrado de " + num + " es " + numCuadrado + " .");
        } else {
            System.out.println("No es posible hacer la raiz cuadrada de un número negativo o de cero.");
        }
        sc.close();
    }
}
