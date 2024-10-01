import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean operando = true;

        System.out.println("CALCULADORA CASI-O (made in spain)");

        System.out.println("Inserte el valor de 'A': ");
        int a = sc.nextInt();

        System.out.println("Inserte el valor de 'B': ");
        int b = sc.nextInt();

        while (operando) {

            System.out.println("¿Qué operación quieres ejecutar? (+, -, *, /)");
            String operacion = sc.nextLine();

            switch (operacion) {
                case "+":
                    System.out.println(a + b);
                    operando = false;
                    break;
                case "-":
                    System.out.println(a - b);
                    operando = false;
                    break;
                case "*":
                    System.out.println(a * b);
                    operando = false;
                    break;
                case "/":
                    System.out.println(a / b);
                    operando = false;
                default:
                    System.out.println("Operación no válida");
                    break;
            }
        }
        sc.close();
    }
}
