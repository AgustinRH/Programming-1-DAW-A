import java.util.Scanner;

public class ejercicio3examen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma, primer_numero, last_num, num = 0;

        System.out.println("Introduce un el primer_número: ");
        primer_numero = sc.nextInt();
        last_num = primer_numero;
        do {
            System.out.println("Introduce otro número: ");
            num = sc.nextInt();
            suma = last_num + num;

            last_num = num;
            if (num >= 0) {
                System.out.println("La suma es " + suma);
            }
        } while (num >= 0);

        sc.close();
    }

}
