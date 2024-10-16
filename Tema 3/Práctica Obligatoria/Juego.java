import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Ohhhh nooo!!, ¡¡te has caido por un túnel subterraneo!! \n Encuentra la forma de salir, pero ten cuidado, no sabes lo que puede haber en esta cueva...");

        System.out.println();

        Explorador explorer = new Explorador();
        Pingu pingu = new Pingu();
        String camino, path = "";
        boolean seguir = false, correcto = false;

        System.out.println("Tienes " + explorer.getSalud() + " puntos de vida.");
        System.out.println("Has vencido a " + pingu.getVencidos() + "/5 pingüinos.");

        // Se divide el camino. Escogemos una opción que no sea la anterior...
        while (!seguir) {

            System.out.println(
                    "Oh no!!. Se divide el camino. ¿Dónde quieres ir? \n N = Norte. \n S = Sur. \n E = Este. \n O = Oeste.");
            camino = sc.nextLine();

            if (!camino.equals(explorer.getNoCamino())) {
                explorer.elegirCamino(camino);
                seguir = true;

                if (explorer.getCamino().equals("S")) {
                    System.out.println("Has elegido ir hacia el Sur");
                } else if (explorer.getCamino().equals("N")) {
                    System.out.println("Has elegido ir hacia el Norte");
                } else if (explorer.getCamino().equals("E")) {
                    System.out.println("Has elegido ir hacia el Este");
                } else if (explorer.getCamino().equals("O")) {
                    System.out.println("Has elegido ir hacia el Oeste");
                } else {
                    System.out.println("¡Esa dirección no existe!");
                    seguir = false;
                }
            } else {
                System.out.println("¡¡No puedes volver por donde has venido, estás atrapado por la nieve!!");
            }
        }

        //Nos encontramos con un pingüino!!


        sc.close();
    }
}
