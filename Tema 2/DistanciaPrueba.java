import java.util.Scanner;

public class DistanciaPrueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        double mill, met;
        Distancia distance = new Distancia();

        System.out.println(
                "Elige que valor quieres introducir para conocer el contrario. \n 1. Millas a Metros. \n 2. Metros a Millas. \n 3. Salir.");
                opc = sc.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Inserte las millas: ");
                mill = sc.nextDouble();

                System.out.println("La distancia en metros es " + distance.millasAMetros(mill));
                break;
            case 2:
                System.out.println("Inserte los metros: ");
                met = sc.nextDouble();

                System.out.println("La distancia en millas es " + distance.metrosAMillas(met));
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:

                System.out.println("Opción no válida.");
                break;
        }

        sc.close();
    }

}
