
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Varaibles de la clase
    private ArrayList<Dispositivo> listaDispositivos;
    private Scanner sc;

    public Main() {
        
        sc = new Scanner(System.in);
        listaDispositivos = new ArrayList<>();
        
        System.out.println("Algos");
        cargarArraylist();
    }

    public static void main(String[] args) {
        System.out.println("BIENVENIDO!");
        Main m = new Main();
        m.menuPrincipal();
    }

    public void cargarArraylist() {
        RandomAccessFile raf = null;
        try {
            // Abrimos archivo dispositivos.dat
            raf = new RandomAccessFile("dispositivos.dat", "r");

            while (raf.getFilePointer() < raf.length()) {
                Dispositivo dispositivo = new Dispositivo(0);
                dispositivo.load(); // Cargar los datos del dispositivo desde el archivo
                listaDispositivos.add(dispositivo);
            }

            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        boolean estado = true;

        try {
            System.out.println("Estado: \n1. Funciona.\n2. No funciona.");
            int est = sc.nextInt();
            if (est == 1) {
                estado = true;
            }
            if (est == 2) {

                estado = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Dispositivo d = new Dispositivo(marca, modelo, estado);

        System.out.println("¿Qué tipo de dispositivo es? \n1. Dispositivo. \n2. Ordenador. \n3. Impresora.");
        d.setTipo(sc.nextInt());

        switch (d.tipo) {
            case 1:
                System.out.println("Dispositivo creado correctamente.");
                break;
            case 2:
                System.out.println("Ingrese la RAM:");
                int ram = sc.nextInt();
                System.out.println("Procesador: ");
                String procesador = sc.next();
                System.out.println("Ingrese el tamaño del Disco Duro: ");
                int tamDisco = sc.nextInt();
                System.out.println("Ingrese el tipo Disco Duro: ");
                int tipoDisco = sc.nextInt();

                Ordenador ord = new Ordenador(d.marca, d.modelo, d.estado, ram, procesador, tamDisco, tipoDisco);

                d.setIdAjeno(ord.getId());
                ord.save();
                ord.load();
                break;
            case 3:
                System.out.println("Ingresa el tipo de Impresora: \n 1. Láser.\n2. Inyección de tinta.\n3. Otros.");
                int tipo = sc.nextInt();
                
                System.out.println("Ingrese si es de color o no:\n 1. SÍ. \n 2. NO.");
                int colorInt = sc.nextInt();
                boolean color;
                switch (colorInt) {
                    case 1:
                        color = true;
                        break;
                    case 2:
                        color = false;
                        break;
                    default:
                        System.out.println("Error al responder...");
                        color = false; 
                        break;
                }
                
                System.out.println("¿Tiene Scanner?\n1. SÍ.\n2. NO.");
                int scannerInt = sc.nextInt();
                boolean scanner = false;
                switch (scannerInt) {
                    case 1:
                        scanner = true;
                        break;
                    case 2:
                        scanner = false;
                        break;
                    default:
                        System.out.println("Error al responder...");
                        break;
                }
                
                Impresora imp = new Impresora(d.marca,d.modelo,d.estado, tipo, color, scanner);
                d.setIdAjeno(imp.getId()); 
                imp.save();
                imp.load();           
            break;
        }
        d.load();
        System.out.println(d.toString());
        listaDispositivos.add(d);
    }

    /*public void mostrarDispositivos() {
        if (listaDispositivos.isEmpty()) {
            System.out.println("No hay dispositivos disponibles.");
        } else {
            for (Dispositivo d : listaDispositivos) {
                if (!d.borrado()) { // Verificamos si el dispositivo no está borrado
                    System.out.println(d.toString());
                }
            }
        }
    }*/
    public void mostrarDispositivos() {
        if (listaDispositivos.isEmpty()) {
            System.out.println("No hay dispositivos disponibles.");
            return;
        }
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige qué tipo de dispositivos quieres mostrar:");
        System.out.println("1. Todos los dispositivos");
        System.out.println("2. Ordenadores");
        System.out.println("3. Impresoras");
        System.out.println("4. Otros dispositivos");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
    
        for (Dispositivo d : listaDispositivos) {
            if (!d.borrado()) { // Solo dispositivos no borrados
                switch (opcion) {
                    case 1: // Mostrar todos
                        System.out.println(d.toString());
                        break;
                    case 2: // Mostrar solo Ordenadores
                        if (d.getTipo() == 1) {
                            System.out.println(d.toString());
                        }
                        break;
                    case 3: // Mostrar solo Impresoras
                        if (d.getTipo() == 2) {
                            System.out.println(d.toString());
                        }
                        break;
                    case 4: // Mostrar otros dispositivos
                        if (d.getTipo() == 0) {
                            System.out.println(d.toString());
                        }
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        return; // Salir si la opción es incorrecta
                }
            }
        }
    }

    public void buscarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a buscar: ");
        int id = sc.nextInt();

        Dispositivo dispositivo = null;
        for (Dispositivo d : listaDispositivos) {
            if (d.getId() == id) {
                dispositivo = d;
                break;
            }
        }

        if (dispositivo != null) {
            System.out.println("Dispositivo encontrado: \n" + dispositivo.toString());
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    public void borrarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a borrar: ");
        int id = sc.nextInt();

        Dispositivo dispositivo = null;
        for (Dispositivo d : listaDispositivos) {
            if (d.getId() == id) {
                dispositivo = d;
                break;
            }
        }

        if (dispositivo != null) {
            dispositivo.setBorrado(true);
            dispositivo.save(); // Guardamos los cambios
            System.out.println("Dispositivo con ID " + id + " marcado como borrado.");

            listaDispositivos.clear(); // Limpiamos la lista actual
            cargarArraylist(); // Recargamos la lista DESPUÉS de guardar
            System.out.println("PATATA");
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    public void cambiarEstadoDispositivo() {
        System.out.print("Ingrese el ID del dispositivo para cambiar su estado: ");
        int id = sc.nextInt();

        Dispositivo dispositivo = null;
        for (Dispositivo d : listaDispositivos) {
            if (d.getId() == id) {
                dispositivo = d;
                break;
            }
        }

        if (dispositivo != null) {
            boolean nuevoEstado = true;
            try {
                System.out.println("Estado: \n1. Funciona.\n2. No funciona.");
                int est = sc.nextInt();
                if (est == 1) {
                    nuevoEstado = true;
                }
                if (est == 2) {

                    nuevoEstado = false;
                }
            } catch (Exception e) {
                System.out.println("Error al cambiar el estado");
                e.printStackTrace();
            }
            dispositivo.setEstado(nuevoEstado);
            dispositivo.save(); // Guardamos cambios en el archivo
            System.out.println("Estado del dispositivo con ID " + id + " cambiado.");
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    public void modificarDispositivo() {
        System.out.print("Ingrese el ID del dispositivo a modificar: ");
        int id = sc.nextInt();

        Dispositivo dispositivo = null;
        for (Dispositivo d : listaDispositivos) {
            if (d.getId() == id) {
                dispositivo = d;
                break;
            }
        }

        if (dispositivo != null) {
            System.out.println("Modificar marca (actual: " + dispositivo.getMarca() + "): ");
            String nuevaMarca = sc.next();
            dispositivo.setMarca(nuevaMarca);

            System.out.println("Modificar modelo (actual: " + dispositivo.getModelo() + "): ");
            String nuevoModelo = sc.next();
            dispositivo.setModelo(nuevoModelo);

            dispositivo.save(); // Guardar cambios en el archivo
            System.out.println("Dispositivo con ID " + id + " modificado.");
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    public boolean comprobarBorrado(int id) {
        for (Dispositivo d : listaDispositivos) {
            if (d.getId() == id) {
                return d.borrado(); // Devolvemos el valor de "borrado" del dispositivo
            }
        }
        return false; // El dispositivo no se encontró
    }
}
