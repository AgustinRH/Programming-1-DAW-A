import java.util.Scanner;

public class RuletaPruebaV2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¡¡BIENVENIDO A LA RULETA!!");

        // PEDIMOS SALDO
        System.out.println("Inserte saldo para poder jugar");
        RuletaV2 ruleta = new RuletaV2(sc.nextDouble());

        // PEDIMOS NÚMERO A APOSTAR y DINERO
        System.out.println("¿A qué número quieres apostar? (Entre 1 y 20)");
        int numero = sc.nextInt();

        System.out.println("Qué cantidad quieres apostar al número?");
        double apuestaNumero = sc.nextDouble();

        // PEDIMOS COLOR A APOSTAR y DINERO
        System.out.println("¿A qué color quieres apostar? \n 1.ROJO \n 2.NEGRO");
        int color = sc.nextInt();
        System.out.println("¿Qué cantidad quieres apostar al color?");
        double apuestaColor = sc.nextDouble();

        // SI ACIERTA NUMERO FELICITAMOS
        if (color == ruleta.numeroRuleta()) {
            ruleta.numeroAcertado(apuestaNumero);
            System.out.println("¡¡Has acertado el número!!");
        }
        
        // SI ACIERTA COLOR FELICITAMOS
        if (color == ruleta.colorRuleta()) {
            ruleta.colorAcertado(apuestaColor);
            System.out.println("¡Has acertado el color!");
        }



        sc.close();
    }
}
