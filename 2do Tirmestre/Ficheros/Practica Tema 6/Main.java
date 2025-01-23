
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   /* private ArrayList<Dispositivo> listaDispositivos;
    private Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
        listaDispositivos = new ArrayList<>();
        
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menuPrincipal();
    }

    private void menuPrincipal() {
        int option;
        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("--------------");
            System.out.println("1. Añadir dispositivo");
            System.out.println("2. Mostrar dispositivos");
            System.out.println("3. Buscar dispositivo");
            System.out.println("4. Borrar dispositivo");
            System.out.println("5. Cambiar estado dispositivo");
            System.out.println("6. Modificar dispositivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    anadirDispositivo();
                    break;
                case 2:
                    mostrarDispositivos();
                    break;
                case 3:
                    buscarDispositivo();
                    break;
                case 4:
                    borrarDispositivo();
                    break;
                case 5:
                    cambiarEstadoDispositivo();
                    break;
                case 6:
                    modificarDispositivo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
    }
 */

    public static void main (String[] args) {
         // Dispositivo d = new Dispositivo("ASus", "PT3", true);
        Dispositivo d = new Dispositivo("Honor", "Magicbook16", true);
        Dispositivo d2 = new Dispositivo("ASus", "Vivobook", true);
        Dispositivo d3 = new Dispositivo("Acer", "Aspire", true);
        Dispositivo d4 = new Dispositivo("Google", "Interbook", true);

        System.out.println(d.toString());
        System.out.println(d2.toString());
        
        System.out.println(d3.toString());
        System.out.println(d4.toString());
        d.save();
        d2.save();
        d3.save();
        d4.save();
    
        d3.delete();
        System.out.println(d3.getId());
    }

}