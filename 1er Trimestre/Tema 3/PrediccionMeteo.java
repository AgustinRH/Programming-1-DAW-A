import java.util.Scanner;

public class PrediccionMeteo {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("PREDICCIÓN METEORÓLIGICA");
        System.out.println("------------------------");
        System.out.println();

        // Pedimos al usuario que ingrese el valor de la presión y la humedad.
        System.out.println("Inserte la presión aotmosférica (1 = baja, 2 = media, 3 = alta): ");
        int presion = 0, humedad = 0;
        presion = sc.nextInt();

        System.out.println("Inserte la humedad relativa (1 = baja, 2 = media, 3 = alta): ");
        humedad = sc.nextInt();
        System.out.println();
        System.out.println();
        

        // Controlamos si los campos añadidos por el usuario son correctos.
        if ((presion == 1 || presion == 2 || presion == 3) && (humedad == 1 || humedad == 2 || humedad == 3)) {

        
            System.out.println("RESULTADO:");
            System.out.println();

            // Calculamos la probabilidad de lluvia.
            if (presion == 1 && humedad == 1) {
                System.out.println("La probabilidad de lluvia es Media");
            } else if (presion == 1 && humedad == 2) {
                System.out.println("La probabilidad de lluvia es Alta");
            } else if (presion == 1 && humedad == 3) {
                System.out.println("la probabilidad de lluvia es Muy Alta");
            } else if (presion == 2 && humedad == 2) {
                System.out.println("La probabilidad de lluvia es Media");
            } else {
                System.out.println("La probabilidad de lluvia es Baja");
            }

            System.out.println();
            // Calculamos la probabilidad de que haga sol.
            if (presion == 1 && humedad == 3) {
                System.out.println("La probabilidad de que haga sol es Baja");
            } else if (presion == 1 && humedad == 2) {
                System.out.println("La probabilidad de que haga sol es Media");
            } else if (presion == 1 && humedad == 1) {
                System.out.println("La probabilidad de que haga sol es media");
            } else if (presion == 2 && humedad == 2) {
                System.out.println("La probabilidad de que haga sol es Media");
            } else {
                System.out.println("La probabilidad de que haga sol es Alta");
            }

            System.out.println();
            // Calculamos la probabilidad de que haga frío.
            if (presion == 1 && humedad == 3) {
                System.out.println("La probabilidad de que haga frío es Alta");
            } else if (presion == 1 && humedad == 2) {
                System.out.println("La probabilidad de que haga frío es Alta");
            } else if (presion == 1 && humedad == 1) {
                System.out.println("La probabilidad de que haga frío es Alta");
            } else if (presion == 2 && humedad == 2) {
                System.out.println("La probabilidad de que haga frío es Media");
            } else {
                System.out.println("La probabilidad de que haga frío es Baja");
            }
        } else {
            System.out.println("Error al insertar los datos, por favor. Inserte los valores correctos.");
        }
        sc.close();
    }

}
