
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Dispositivo> listaDispositivos;
    private Scanner sc;

    public Main() {
        listaDispositivos = new ArrayList<>();
        sc = new Scanner(System.in);
        cargarDatos(); // Load devices at the start
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

    private void cargarDatos() {

    }

    private void anadirDispositivo() {
        System.out.print("Ingrese el tipo de dispositivo (1: Ordenador, 2: Impresora): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la marca: ");
        String marca = sc.nextLine();
        System.out.print("Ingrese el modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Ingrese el estado (true/false): ");
        boolean estado = sc.nextBoolean();

        if (tipo == 1) { // Ordenador
            System.out.print("Ingrese la RAM (GB): ");
            int ram = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Ingrese el procesador: ");
            String procesador = sc.nextLine();
            System.out.print("Ingrese el tamaño del disco duro (GB): ");
            int tamDisco = sc.nextInt();
            System.out.print("Ingrese el tipo de disco (0: Mecánico, 1: SSD, 2: NVMe, 3: Otro): ");
            int tipoDisco = sc.nextInt();

            Ordenador ordenador = new Ordenador(marca, modelo, estado, ram, procesador, tamDisco, tipoDisco);
            listaDispositivos.add(ordenador);
            ordenador.save();
            System.out.println("Ordenador añadido con éxito.");
        } else if (tipo == 2) { // Impresora
            System.out.print("Ingrese el tipo de impresora (0: Láser, 1: Inyección, 2: Otro): ");
            int tipoImpresora = sc.nextInt();
            System.out.print("¿Es color? (true/false): ");
            boolean color = sc.nextBoolean();
            System.out.print("¿Tiene escáner? (true/false): ");
            boolean scanner = sc.nextBoolean();

            Impresora impresora = new Impresora(marca, modelo, estado, tipoImpresora, color, scanner);
            listaDispositivos.add(impresora);
            impresora.save();
            System.out.println("Impresora añadida con éxito.");
        } else {
            System.out.println("Tipo de dispositivo no válido.");
        }
    }

    private void mostrarDispositivos() {
        if (listaDispositivos.isEmpty()) {
            System.out.println("No hay dispositivos para mostrar.");
        }
        System.out.println("Dispositivos:");
        for (Dispositivo dispositivo : listaDispositivos) {
            System.out.println(dispositivo.toString());
        }
    }

    private void buscarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a buscar: ");
        int id = sc.nextInt();
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getId() == id) {
                System.out.println("Dispositivo encontrado: " + dispositivo.toString());
            }
        }
        System.out.println("Dispositivo no encontrado.");
    }

    private void borrarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a borrar: ");
        int id = sc.nextInt();
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getId() == id) {
                dispositivo.delete();
                listaDispositivos.remove(dispositivo);
                System.out.println("Dispositivo borrado con éxito.");
            }
        }
        System.out.println("Dispositivo no encontrado.");
    }

    private void cambiarEstadoDispositivo() {
        System.out.print("Ingrese el ID del dispositivo: ");
        int id = sc.nextInt();
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getId() == id) {
                dispositivo.cambiarEstado(!dispositivo.estado());
                dispositivo.save(); // Save the updated state
                System.out.println("Estado del dispositivo cambiado con éxito.");
            }
        }
        System.out.println("Dispositivo no encontrado.");
    }

    private void modificarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a modificar: ");
        int id = sc.nextInt();
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo.getId() == id) {
                System.out.println("Datos actuales: " + dispositivo.toString());
                System.out.print("Ingrese nueva marca (dejar vacío para no cambiar): ");
                String nuevaMarca = sc.nextLine();
                if (!nuevaMarca.isEmpty()) {
                    dispositivo.setMarca(nuevaMarca);
                }
                System.out.print("Ingrese nuevo modelo (dejar vacío para no cambiar): ");
                String nuevoModelo = sc.nextLine();
                if (!nuevoModelo.isEmpty()) {
                    dispositivo.setModelo(nuevoModelo);
                }
                System.out.print("Ingrese nuevo estado (true/false, dejar vacío para no cambiar): ");
                if (sc.hasNextBoolean()) {
                    boolean nuevoEstado = sc.nextBoolean();
                    dispositivo.setEstado(nuevoEstado);
                }
                dispositivo.save(); // Save the updated device
                System.out.println("Dispositivo modificado con éxito.");
            }
        }
        System.out.println("Dispositivo no encontrado.");
    }
}