import java.util.Scanner;

public class Dados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dado1, dado2, dado3;
        boolean dados = true;
        int jugar = 1;

        System.out.println("Ingrese la cantidad inicial de dinero: ");
        double saldo = sc.nextDouble();

        while (dados) {

            System.out.println("Inserte la cantidad a apostar: ");
            double apostar = sc.nextDouble();

            if (apostar <= saldo) {
                saldo = saldo - apostar;

                dado1 = (int) (Math.random() * 6 + 1);
                dado2 = (int) (Math.random() * 6 + 1);
                dado3 = (int) (Math.random() * 6 + 1);

                if (dado1 == dado2 && dado2 == dado3) { // Si los dados son los mismos números...
                    if (dado1 == 6) {
                        apostar *= 5; // Se multiplica lo apostado x5 si sale 6 en los tres.
                        saldo += apostar;
                        apostar = 0;
                        System.out.println("BONUS X5!!");
                    } else {
                        apostar *= 3; // Se multiplica x3 si salo otra cantidad...
                        saldo += apostar;
                        apostar = 0;
                        System.out.println("BONUS X3!!");
                    }
                } else if (dado1 == dado2 || dado2 == dado3 || dado3 == dado1) {
                    apostar *= 2;
                    saldo += apostar;
                    apostar = 0;
                    System.out.println("BONUS X2!!");
                } else {
                    apostar = 0;
                    System.out.println("HAS PERDIDOO, DEJA DE APOSTAR MATAO' JAJAJAJAJA");
                }
                System.out.println("Tienes " + saldo + " euros.");

            } else {
                System.out.println("Ingrese más dinero para seguir jugando");
            }

            System.out.println("¿Desea finalizar el juego? (Pulse 1 para salir) - (Pulse 2 para continuar)");
            jugar = sc.nextInt();

            switch (jugar) {
                case 1:
                    System.out.println("Hasta prontoo!!");
                    dados = false;
                    break;
                default:
                    System.out.println("Sigue gastandote la paga!!");
                    break;
            }
        }
        sc.close();
    }

}
