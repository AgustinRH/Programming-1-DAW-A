import java.util.Scanner;

public class MaquinaExpendedora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double dinero, resto;
        int deuros = 0, euros, cincuent = 0, venti = 0, ten = 0, five = 0, two = 0, one = 0, bfive = 0, bten = 0,
                bventi = 0;
        System.out.println("Ingrese la cantidad de dinero: ");
        dinero = sc.nextDouble();

        euros = (int) dinero; // Parte entera

        resto = (dinero - euros) * 100; // Parte decimal en céntimos
        resto = Math.round(resto);

        if (resto >= 50) { // Monedas de 50 céntimos
            cincuent = (int) resto / 50;
            resto -= (50 * (double) cincuent);

        }
        if (resto >= 20) { // Monedas de 20 céntimos
            venti = (int) resto / 20;
            resto -= (20 * (double) venti);

        }
        if (resto >= 10) { // Monedas de 10 céntimos
            ten = (int) resto / 10;
            resto -= (10 * (double) ten);

        }
        if (resto >= 5) { // Monedas de 5 céntimos
            five = (int) resto / 5;
            resto -= (5 * (double) five);
        }

        if (resto >= 2) { // Monedas de 2 céntimos
            two = (int) resto / 2;
            resto -= (2 * (double) two);
        }

        if (resto >= 1) { // Monedas de 1 céntimos
            one = (int) resto / 1;
            resto -= (1 * (double) one);
        }

        

        if (euros >= 20) { // Billetes de 20 euros
            bventi = euros / 20;
            euros -= (20 * bventi);
        }

        if (euros >= 10) { // Billetes de 10 euros
            bten = euros / 10;
            euros -= (10 * bten);
        }

        if (euros >= 5) { // Billetes de 5 euros
            bfive = euros / 5;
            euros -= (5 * bfive);
        }

        if (euros >= 2) {
            deuros = euros / 2;
            euros -= (2 * deuros);
        }
        System.out.println("--------------------------");
        System.out.println("Billetes de 20 euros: " + bventi);
        System.out.println("Billetes de 10 euros: " + bten);
        System.out.println("Billetes de 5 euros: " + bfive);

        System.out.println("Monedas de 2 euros: " + deuros);
        System.out.println("Monedas de 1 euro: " + euros);
        System.out.println("Monedas de 50 cents: " + cincuent);
        System.out.println("Monedas de 20 cents: " + venti);
        System.out.println("Monedas de 10 cents: " + ten);
        System.out.println("Monedas de 5 cents: " + five);
        System.out.println("Monedas de 2 cents: " + two);
        System.out.println("Monedas de 1 cents: " + one);

        sc.close();
    }
}
