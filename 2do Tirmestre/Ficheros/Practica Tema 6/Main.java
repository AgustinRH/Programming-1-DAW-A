
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Dispositivo> listaDispositivos;
    private Scanner sc;

    public Main() {
        sc = new Scanner(System.in);
        listaDispositivos = new ArrayList<>();
    }

    public void cargarArraylist() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");
            while (raf.getFilePointer() < raf.length()) {
                raf.seek(this.id * 205);
                raf.readInt();
                this.marca = leerString(raf);
                this.modelo = leerString(raf);
                this.estado = raf.readBoolean();
                Dispositivo d = new Dispositivo(this.marca, this.modelo, this.estado);
                listaDispositivos.add(d);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
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

    public void anadirDispositivo() {
        System.out.println("Ingresa los siguientes datos para añadir un dispositivo nuevo.");
        System.out.println("Marca: ");
        String marca = sc.next();
        System.out.println("Modelo: ");
        String modelo = sc.next();
        System.out.println("Estado (funciona / no funciona): ");
        String estadoString = sc.next();
        boolean estado;
        if (estadoString.equals("funciona")) {
            estado = true;
        } else {
            estado = false;
        }

        Dispositivo d = new Dispositivo(marca, modelo, estado);

        d.load();
        System.out.println(d.toString());
    }

    public void mostrarDispositivos() {

    }

    public void buscarDispositivo() {
        System.out.println("Dime el ID del dispsoitivo a buscar: ");
        int idBuscar = sc.nextInt();


    }

    public void borrarDispositivo() {
        System.out.println("Dime el ID del dispsoitivo a borrar: ");
        int idBuscar = sc.nextInt();

    }

    public void cambiarEstadoDispositivo() {
        System.out.println("Dime el ID del dispsoitivo a cambiar: ");
        int idBuscar = sc.nextInt();
    }

    public void modificarDispositivo() {
        System.out.println("Dime el ID del dispsoitivo que deseas modificar: ");
        int idBuscar = sc.nextInt();
    }
}
