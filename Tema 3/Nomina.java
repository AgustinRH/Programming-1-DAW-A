import java.util.Scanner;

public class Nomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double extra = 0, nomina, extra2 = 0, brutoMes, disc = 0;
        System.out.println("¿Quieres saber tu nómina?");
        System.out.println("Cuantas horas has realizado esta semana: ");
        double horas = sc.nextInt();

        System.out.println("Cuanto te pagan por cada hora: ");
        double precio = sc.nextDouble();

        if (horas > 40) {
            extra = horas - 40;
            horas = horas - extra;
        }

        if (horas > 45) {
            extra2 = horas - 45;
            horas = horas - extra2;
        }

        nomina = horas * precio + ((extra * precio) * 1.5);

        brutoMes = (horas * precio + ((extra * precio) * 1.5) + ((extra2 * precio) * 2)) * 4;

        if (brutoMes >= 1000) {
            disc = brutoMes * 0.15;
            System.out.println("Se le aplica un descuento de " + disc + " euros");
        } else {
            disc = brutoMes * 0.1;
            System.out.println("Se le aplica un descuento de " + disc + " euros");
        }

        System.out.println("Tu nómina semanal  es de " + nomina + " euros.");
        System.out.println("Tu salario bruto/mes es de " + brutoMes + " euros.");
        System.out.println("Tu salario neto es de " + (brutoMes - disc) + " euros.");

        sc.close();
    }

}
