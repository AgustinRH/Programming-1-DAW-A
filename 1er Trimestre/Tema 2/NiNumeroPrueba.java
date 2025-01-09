import java.util.Scanner;

public class NiNumeroPrueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, suma, resta, main, sumar, restar;

        System.out.println("Inserte un número: ");
        main = sc.nextInt();

        MiNumero miNumero = new MiNumero(main);

        while (main != -1) {

            System.out.println("Dime un número para sumarle.");
            sumar = sc.nextInt();
            suma = miNumero.suma(sumar);
            System.out.println("Dime un número para restarle.");
            restar = sc.nextInt();
            resta = miNumero.resta(restar);

            System.out.println("La suma es " + suma);
            System.out.println("La resta es " + resta);
            System.out.println("El doble es " + miNumero.getDoble());
            System.out.println("El triple es " + miNumero.getTriple());
            System.out.println("El cuadruple es " + miNumero.getCuadruple());

            int cambiar;

            System.out.println("¿Quieres cambiar el número? (1 = SI, RESTO NO)");
            cambiar = sc.nextInt();

            if (cambiar == 1) {
                System.out.println("Dime el nuevo número: ");
                main = sc.nextInt();
                miNumero.cambiaNumero(main);
            }

        }
        System.out.println("ADIOSS");
        sc.close();
    }
}
