import java.util.Scanner;

public class Nomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double extra = 0, nomina, extra2 = 0, brutoMes, disc = 0;
        System.out.println("¿Quieres saber tu nómina?");
        // Pedimos al usuario el número de horas trabajas
        System.out.println("Cuantas horas has realizado esta semana: ");
        double horas = sc.nextInt();
        // Pedimos al usuario el precio/hora pagado
        System.out.println("Cuanto te pagan por cada hora: ");
        double precio = sc.nextDouble();

        // Calculamos las horas extra si es que tiene alguna.
        if (horas > 40) {
            extra = horas - 40;
            if (extra <= 5) {
                horas = horas - extra;
            } else { // calculamos las horas extra más caras si es que tiene
                
                extra = horas - 40 - 5;
                extra2 = horas - 45.0;
                horas = horas - extra2 - 5.0;
            }
        }
        
        // Calculamos la nómina
        
        nomina = horas * precio + (((extra + 5 )* precio) * 1.5);
        // Calculamos es salario bruto mensual.
        System.out.println("Horas" + horas);
        System.out.println("Precio" + precio);
        System.out.println("extra" + extra);
        System.out.println("Extra2" + extra2);
        brutoMes = (horas * precio + ((extra * precio) * 1.5) + ((extra2 * precio) * 2)) * 4;
        // Calculamos los impuestos según su salario.
        if (brutoMes >= 1000) {
            disc = brutoMes * 0.15;
            System.out.println("Se le aplica un descuento de " + disc + " euros");
        } else {
            disc = brutoMes * 0.1;
            System.out.println("Se le aplica un descuento de " + disc + " euros");
        }
        // Mostramos en pantalla al usuario su nómina, el salario bruto mensual y su
        // salario neto.
        System.out.println("Tu nómina semanal  es de " + nomina + " euros.");
        System.out.println("Tu salario bruto/mes es de " + brutoMes + " euros.");
        System.out.println("Tu salario neto es de " + (brutoMes - disc) + " euros.");

        sc.close();
    }
}
