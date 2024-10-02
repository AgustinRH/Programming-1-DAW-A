import java.util.Scanner;

public class Ruleta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("RULETA");
        int numero, color;
        int numAdivinar = 0, colAdivinar = 0, jugar = 0;

        double saldo = 500, apostadoNum = 0, apostadoCol = 0;

        while (jugar != -1) {

            numero = (int) (Math.random() * 20 + 1);
            color = (int) (Math.random() * 2 + 1);

            System.out.println("Tienes " + saldo + " euros restantes.");
            System.out.println("Elige número: (Del 1 al 20)");
            numAdivinar = sc.nextInt();
            System.out.println("¿Cuánto quieres apostar al número?");
            apostadoNum = sc.nextInt();

            System.out.println("Elige el color (1 = ROJO, 2 = NEGRO)");
            colAdivinar = sc.nextInt();

            System.out.println("¿Cuánto quieres apostar al color?");
            apostadoCol += sc.nextInt();

            switch (color) {
                case 1: // Color ROJO
                    if (colAdivinar == 1) {
                        System.out.println("Has acertado, es el color ROJO!!");
                        saldo += apostadoCol * 2;
                        apostadoCol = 0;
                    } else {
                        System.out.println("No has acertado el color");
                        saldo -= apostadoCol;
                        apostadoCol = 0;
                    }
                    break;
                case 2: // Color NEGRO
                    if (colAdivinar == 2) {
                        System.out.println("Has acertado, es el color NEGRO!!");
                        saldo += apostadoCol * 2;
                        apostadoCol = 0;
                    } else {
                        System.out.println("No has acertado el color");
                        saldo -= apostadoCol;
                        apostadoCol = 0;
                    }
                    break;
                default:
                    break;
            }

            if (numAdivinar == numero) {
                System.out.println("Has acertado el número!!");
                saldo += apostadoNum * 3;
                apostadoNum = 0;
            } else {
                System.out.println("Has fallado el número!!");
                saldo -= apostadoNum;
                apostadoNum = 0;
            }

            // Salir del programa
            System.out.println("¿Quieres seguir jugando? (Presione 1 para salir, u otra tecla para seguir jugando)");
            int respuesta = sc.nextInt();
            if (respuesta == 1) {
                System.out.println("Hasta pronto pequeño ludópata");
                jugar = -1;
            } else {
                jugar = 0;
            }
        }

        sc.close();
    }
}
