import java.util.Scanner;

public class Quiniela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quiniela");

        double num;

        for (int i = 1; i <= 14; i++) { // Bucle para obtener 14 números.
            num = Math.random() * 3 + 1; // Sacamos un número al azar entre 1 y 3.

            switch ((int) num) {
                case 1:
                    if (i == 1) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print("- " + 1 + " "); // Si el número es 1 irmprimimos 1.
                    }
                    break;
                case 2:
                    if (i == 1) {
                        System.out.print(2 + " ");
                    } else {
                        System.out.print("- " + 2 + " "); // Si el número es 2 imrpimimos 2.
                    }
                    break;
                case 3:
                    if ( i == 1) {
                        System.out.print("X ");
                    } else {
                    System.out.print("- X "); // Si el número es 3 imprimimos X.
                    }
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
