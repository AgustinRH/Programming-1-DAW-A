import java.util.Scanner;

public class NotasClase {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Notas de Clase.");
        int nota, aprobado = 0, suspenso = 0;

        for(int i = 0; i < 30; i++){
            System.out.println("Inserte una nota de un alumno");
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Error al introducir la nota, por favor, introduzca una nota valida");
                i--;
            } else {
                if (nota < 5) {
                    suspenso = suspenso + 1;
                } else if (nota >= 5) {
                    aprobado = aprobado + 1;
                }
            }
        }

        System.out.println("Aprobados: " + aprobado);
        System.out.println("Suspensos: " + suspenso);

        sc.close();
    }
}
