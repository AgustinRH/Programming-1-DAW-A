import java.util.Scanner;

public class CalculadoraEdad {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia, mes, anio, dianow, mesnow, anionow, edad, meses;


        System.out.println("Ingrese el día de nacimiento (dd): ");
        dia = sc.nextInt();

        System.out.println("Ingrese el mes de nacimiento (MM): ");
        mes = sc.nextInt();

        System.out.println("Ingrese el año de nacimiento (yyyy): ");
        anio = sc.nextInt();

        System.out.println("Ingrese el dia actual (dd): ");
        dianow = sc.nextInt();

        System.out.println("Ingrese el mes actual (MM): ");
        mesnow = sc.nextInt();

        System.out.println("Ingrese el año actual (yyyy): ");
        anionow = sc.nextInt();

        edad = anionow - anio;


        if (mesnow < mes) {
            edad -= 1;
        } 
        if (mesnow == mes) {
            if (dianow < dia ) {
                edad -= 1;
            }
            if (dianow == dia) {
                System.out.println("¡Feliz cumpleaños!");
            }
        }
        if (edad <= 0) {
            meses = mesnow - mes;
            System.out.println("Tienes " + meses +  " meses" );
        }

        System.out.println("Tienes " + edad + " años.");
    } 
}