import java.util.Scanner;

public class Programa1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int estacion;
        boolean control = true;

        while (control) {

            System.out.println("Inserte el número de la estación (1 = primavera, 2 = verano, 3 = otoño, 4 = invierno): ");
            estacion = sc.nextInt();

            switch (estacion) {
                case 1:
                    System.out.println("Estás en primavera");
                    control = false;
                    break;
                case 2:
                    System.out.println("Estás en verano");
                    control = false;
                    break;
                case 3:
                    System.out.println("Estás en otoño");
                    control = false;
                    break;
                case 4:
                    System.out.println("Estás en invierno");
                    control = false;
                    break;
                default:
                    System.out.println("Error al introducir la estación");
                    break;
            }
        }
        sc.close();
    }
}