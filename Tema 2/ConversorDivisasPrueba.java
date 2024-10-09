import java.util.Scanner;

public class ConversorDivisasPrueba {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double euro, libra;
        int cambio;

        ConversorDivisas conversor = new ConversorDivisas();

        System.out.println("¿Qué quieres cambiar? (1 = euros, 2 = libras)");
        cambio = sc.nextInt();

        switch (cambio) {
            case 1:
                System.out.println("Ingrese cuantos euros quieres cambiar a libras: ");
                euro = sc.nextDouble();
                System.out.println(euro + " euros son " + Math.round(conversor.eurosALibras(euro)) + " libras.");
                break;
            case 2:
                System.out.println("Ingrese cuantas libras quieres cambiar a euros: ");
                libra = sc.nextDouble();
                System.out.println(libra + " libras son " + Math.round(conversor.librasAEuros(libra)) + " euros.");
                break;
            default:
            System.out.println("Error de moneda.");
                break;
        }

        sc.close();
    }
}
