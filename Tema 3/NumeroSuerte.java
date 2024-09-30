import java.util.Scanner;

public class NumeroSuerte {
    
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Conoce tu número de la suerte. (Solo para nacidos antes de 2020)");
        int dia, mes, ano, numSuerte, valor1, valor2, valor3, valor4;


        // Pedimos al usuario que introduzca su fecha de nacimiento.
        System.out.println("Introuce tu dia de nacimiento: ");
        dia = sc.nextInt();
        System.out.println("Introduce el mes de nacimiento (Ejemplo: 1 = Enero, 2 = Febrero...:)");
        mes = sc.nextInt();
        System.out.println("Introduce el año de nacimiento: ");
        ano = sc.nextInt();

        // Sumamos las fechas y dividimos el resultado para conocer el número.
        numSuerte = dia + mes + ano;
        valor1 = numSuerte / 1000;
        valor2 = numSuerte / 100 % 10;
        valor3 = numSuerte / 10 % 10;
        valor4 = numSuerte % 10;

        numSuerte = valor1 + valor2 + valor3 + valor4;

        valor3 = numSuerte / 10 % 10;
        valor4 = numSuerte % 10;

        numSuerte = valor3 +valor4;

        System.out.println("Tu número de la suerte es " + numSuerte);
    }
}
