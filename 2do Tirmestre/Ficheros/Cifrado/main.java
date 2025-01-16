import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        cifrado cifrado = new cifrado();
        descifrado descifrado = new descifrado();

        System.out.println("Seleccione una opción:");
        System.out.println("1. Cifrar");
        System.out.println("2. Descifrar");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Dime el nombre del archivo a cifrar: ");
                String cifrar = sc.nextLine();

                System.out.println("Dime el nombre del nuevo archivo cifrado: ");
                String descifrar = sc.nextLine();

                cifrado.cifrar(cifrar, descifrar);
                System.out.println("Archivo cifrado exitosamente.");
                break;

            case 2:
                System.out.println("Dime el nombre del archivo a descifrar: ");
                String descifrar2 = sc.nextLine();
                System.out.println("Dime el nombre del nuevo archivo descifrado: ");

                String cifrar2 = sc.nextLine();
                descifrado.descifrar(descifrar2, cifrar2);
                System.out.println("Archivo descifrado exitosamente.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        sc.close();
    }
}
