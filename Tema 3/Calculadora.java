import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean operando = true;

        System.out.println("CALCULADORA CASI-O (made in spain)");

        // Pedimos al usuario que inserte 2 números
        System.out.println("Inserte el valor de 'A': ");
        int a = sc.nextInt();

        System.out.println("Inserte el valor de 'B': ");
        int b = sc.nextInt();

        while (operando) { // Filtramos las operaciones posibles.

            System.out.println("¿Qué operación quieres ejecutar? (+, -, *, /)");
            String operacion = sc.nextLine();

            switch (operacion) {
                case "+":
                    System.out.println(a + b); // Sumamos
                    operando = false;
                    break;
                case "-":
                    System.out.println(a - b); // Restamos
                    operando = false;
                    break;
                case "*":
                    System.out.println(a * b); // Multiplicamos
                    operando = false;
                    break;
                case "/":
                    System.out.println(a / b); // Dividimos
                    operando = false;
                default:
                    System.out.println("Operación no válida"); // Si no elige la opción correcta vuelve a pedirle que introduzca la opción.
                    break;
            }
        }
        sc.close();
    }
}
