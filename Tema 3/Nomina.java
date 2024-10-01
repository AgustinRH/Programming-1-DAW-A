import java.util.Scanner;

public class Nomina {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double extra = 0, nomina;
        System.out.println("¿Quieres saber tu nómina?");
        System.out.println("Cuantas horas has realizado esta semana: ");
        double horas = sc.nextInt();

        System.out.println("Cuanto te pagan por cada hora: ");
        double precio = sc.nextDouble();

        if (horas > 40) {
            extra = horas - 40;
            horas = horas - extra;
        }

        nomina = horas * precio + ((extra * precio)* 1.5);

        System.out.println("Tu nómina es de "+ nomina + " euros.");

        sc.close();
    }
    
}
