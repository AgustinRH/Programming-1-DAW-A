import java.util.Scanner;

public class ConversorDivisasPrueba {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        char tipo = ' ';
        int a;
        int dinero;

        System.out.println("Ingresa el tipo de moneda que tienes: (1 = Euro, 2 = Libra)");
        a = sc.nextInt();
        if (a == 1) {
            tipo = 'E';
        }
        if (a == 2) {
            tipo = 'L';
        } else {
            System.out.println("Error al introducir el tipo.");
        }
        System.out.println("Ingresa la cantidad: ");
        dinero = sc.nextInt();

        ConversorDivisas conversorDivisas = new ConversorDivisas(tipo, dinero);

        System.out.println(conversorDivisas.Convertir(tipo));
        
        sc.close();
    }
}
