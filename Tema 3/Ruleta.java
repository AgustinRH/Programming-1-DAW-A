import java.util.Scanner;

public class Ruleta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("RULETA");
        int numero, color;
        int numAdivinar = 0, colAdivinar = 0, jugar = 0;

        double saldo = 500, apostado = 0;

        numero = (int) (Math.random() * 20 + 1);
        color = (int) (Math.random() * 2 + 1);
        

        while (jugar != -1) {

            System.out.println("Tienes " + saldo + " euros restantes.");
            
            switch (color) {
                case 1: // Color ROJO
                    if (colAdivinar == 1) {
                        System.out.println("Has acertado, es el color ROJO!!");
                        saldo = apostado * 2;
                        apostado = 0;
                    } else {
                        System.out.println("No has acertado el color");
                        saldo -= apostado;
                        apostado = 0;
                    }
                    break;
                case 2: // Color NEGRO
                    if (colAdivinar == 2) {
                        System.out.println("Has acertado, es el color NEGRO!!");
                        saldo = apostado * 2;
                        apostado = 0;
                    } else {
                        System.out.println("No has acertado el color");
                        saldo -= apostado;
                        apostado = 0;
                    }
                    break;
                default:
                    break;
            }

        }

        sc.close();
    }
}
