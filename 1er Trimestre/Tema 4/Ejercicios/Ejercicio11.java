import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declaramos un Array
        String libros[] = new String[10];

        // Llenamos el Array con títulos de libros
        for (int i = 0; i < libros.length; i++) {
            System.out.println("Inserte el nombre de un libro: ");
            libros[i] = sc.nextLine();
        }

        // Buscamos un libro
        System.out.println("¿Qué libro deseas ?");
        String buscar = sc.nextLine();
        boolean encontrado = false;
        int pos = -1;

        for (int j = 0; j < libros.length; j++) {
            if (libros[j].equals(buscar)) {
                encontrado = true;
                pos = j;
                System.out.println("El libro está en la posición " + j);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado el libro que buscas...");
        }


        // Prestamos un libro
        if (encontrado) {
            int prestarlo = 0;
            String cambio;
            System.out.println("¿Deseas prestar un libro? \n 1. Si, si quiero prestarlo \n  2. No, no quiero prestarlo...");
            prestarlo = sc.nextInt();
            switch (prestarlo) {
                case 1:
                    cambio = libros[pos];
                    libros[pos] = "Prestado";
                    System.out.println("El libro prestado ha sido " + cambio);
                    break;
                case 2: 
                    System.out.println("Hasta prontoo!!");
                default:

                System.out.println("Error al elegir la opción correcta.");
                    break;
            }
        }

        sc.close();
    }
}
