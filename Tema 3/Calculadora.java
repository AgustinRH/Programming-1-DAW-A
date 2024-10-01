import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean operando = true;
        int a, b;

        System.out.println("CALCULADORA CASI-O (made in spain)");

        while (operando) { // Filtramos las operaciones posibles.

            // Pedimos al usuario que inserte 2 números
            System.out.println("Inserte el valor de 'A': ");
            a = sc.nextInt();

            System.out.println("Inserte el valor de 'B': ");
            b = sc.nextInt();

            System.out.println("¿Qué operación quieres ejecutar? (+, -, *, /)  -- Si desea salir diga 'Salir'.  ");
            String operacion = sc.nextLine();

            switch (operacion) {
                case "+":
                    System.out.println(a + b); // Sumamos
                    break;
                case "-":
                    System.out.println(a - b); // Restamos
                    break;
                case "*":
                    System.out.println(a * b); // Multiplicamos
                    break;
                case "/":
                    System.out.println(a / b); // Dividimos
                    break;
                case "Salir":
                    System.out.println("Hasta pronto!!");
                    operando = false;
                    break;
                default:
                    System.out.println("Operación no válida"); // Si no elige la opción correcta vuelve a pedirle que
                                                               // introduzca la opción.
                    break;
            }
        }
        sc.close();
    }
}
