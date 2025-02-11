import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Variables de la clase
    private ArrayList<Dispositivo> listaDispositivos;
    private Scanner sc;

    // Constructor de la clase Main
    public Main() {
        sc = new Scanner(System.in); // Inicializamos Scanner
        listaDispositivos = new ArrayList<>(); // Inicializamos el ArrayList
        cargarArraylist(); // Cargamos los datos de los ficheros al ArrayList
    }

    public static void main(String[] args) {
        System.out.println("BIENVENIDO!");
        Main m = new Main(); // Creamos el objeto de main
        m.menuPrincipal(); // Llamamos al método menuPrincipal() de main
    }

    // Método para cargar los ficheros al ArrayList
    public void cargarArraylist() {
        int id = 0;

        boolean terminar = false;
        while (!terminar) {
            Dispositivo d = new Dispositivo(id);
            if (d.load() == 0) {
                System.out.println(d.toString());
                switch (d.getTipo()) {
                    case 2:
                        Ordenador o = new Ordenador(id);
                        o.load();
                        listaDispositivos.add(o);
                        break;
                    case 3:
                        Impresora i = new Impresora(id);
                        i.load();
                        listaDispositivos.add(i);
                        break;
                    default:
                        listaDispositivos.add(d);
                        break;
                }
            } else {
                terminar = true;
            }
            id++;
        }
    }

    // Método que muestra un menú de opciones
    private void menuPrincipal() {
        int opc;
        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("--------------");
            System.out.println("1. Añadir dispositivo");
            System.out.println("2. Mostrar dispositivos");
            System.out.println("3. Buscar dispositivo");
            System.out.println("4. Borrar dispositivo");
            System.out.println("5. Cambiar estado dispositivo");
            System.out.println("6. Modificar dispositivo");
            System.out.println("7. Recuperar dispositivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();
            sc.nextLine();
            System.out.println(); // ESPACIADO

            switch (opc) {
                case 1:
                    anadirDispositivo(); // Llamamos al método anadirDispositivo()
                    break;
                case 2:
                    mostrarDispositivos(); // Llamamos al método mostrarDispositivos()
                    break;
                case 3:
                    buscarDispositivo(); // Llamamos al método buscarDispositivos()
                    break;
                case 4:
                    borrarDispositivo(); // Llamamos al método borrarDispositivos
                    break;
                case 5:
                    cambiarEstadoDispositivo(); // Llamamos al método cambiarEstadoDispositivo()
                    break;
                case 6:
                    modificarDispositivo(); // Llamamos al método modificarDispositivo()
                    break;
                case 7:
                    recuperarDispositivo(); // Llamamos al método recuperarDispositivo()
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opc != 0);
    }

    // Método para añadir un dispositivo nuevo
    public void anadirDispositivo() {
        String marca = obtenerMarca();
        String modelo = obtenerModelo();
        boolean estado = obtenerEstado();
        int tipo = obtenerTipoDispositivo();

        Dispositivo d = new Dispositivo(marca, modelo, estado);

        switch (tipo) {
            case 1:
                System.out.println("Dispositivo creado correctamente.");
                System.out.println(); // ESPACIADO

                listaDispositivos.add(d);
                d.save();
                break;
            case 2:
                crearOrdenador(d);
                break;
            case 3:
                crearImpresora(d);
                break;
        }

        System.out.println(d.toString());
    }

    // Método para obtener la marca de un dispositivo
    private String obtenerMarca() {
        System.out.print("Marca: ");
        return sc.next();
    }

    // Método para obtener el modelo de un dispositivo
    private String obtenerModelo() {
        sc.nextLine();
        System.out.print("Modelo: ");
        return sc.next();
    }

    // Método para obtener el estado de un dispositivo
    private boolean obtenerEstado() {
        System.out.println("Estado: \n1. Funciona.\n2. No funciona.");
        int est = sc.nextInt();
        return est == 1;
    }

    // Método para obtener el tipo de dispositivo
    private int obtenerTipoDispositivo() {
        System.out.println("¿Qué tipo de dispositivo es? \n1. Dispositivo. \n2. Ordenador. \n3. Impresora.");
        return sc.nextInt();
    }

    // Método para crear un ordenador
    private void crearOrdenador(Dispositivo d) {
        System.out.print("Ingrese la RAM: ");
        int ram = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        System.out.print("Procesador: ");
        String procesador = sc.nextLine();
        System.out.print("Ingrese el tamaño del Disco Duro: ");
        int tamDisco = sc.nextInt();
        System.out.print("Ingrese el tipo Disco Duro: \n1. HDD.\n2. SSD.\n3. nvMe.\n4. Otro.");
        int tipoDisco = sc.nextInt();

        Ordenador ord = new Ordenador(d.marca, d.modelo, d.estado, ram, procesador, tamDisco, tipoDisco);
        System.out.println(ord.toString());
        d.setIdAjeno(ord.getId());
        ord.save();
        listaDispositivos.add(ord);
    }

    // Método para crear una impresora
    private void crearImpresora(Dispositivo d) {
        System.out.println("Ingresa el tipo de Impresora: \n1. Láser.\n2. Inyección de tinta. \n3. Otros.");
        int tipoImpr = sc.nextInt();

        boolean color = obtenerColor();
        boolean scanner = obtenerScanner();

        Impresora imp = new Impresora(d.marca, d.modelo, d.estado, tipoImpr, color, scanner);
        imp.save();
        listaDispositivos.add(imp);
    }

    // Método para obtener si una impresora es de color o no
    private boolean obtenerColor() {
        System.out.println("Ingrese si es de color o no:\n1. SÍ. \n2. NO.");
        int colorInt = sc.nextInt();
        return colorInt == 1;
    }

    // Método para obtener si una impresora tiene scanner o no
    private boolean obtenerScanner() {
        System.out.println("¿Tiene Scanner?\n1. SÍ.\n2. NO.");
        int scannerInt = sc.nextInt();
        return scannerInt == 1;
    }

    // Método para mostrar dispositivos con opción de filtro
    public void mostrarDispositivos() {
        if (listaDispositivos.isEmpty()) {
            System.out.println("No hay dispositivos disponibles.");
            return;
        }

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
                        if (d.getTipo() == 2) {
                            System.out.println(d.toString());
                        }
                        break;
                    case 3: // Mostrar solo Impresoras
                        if (d.getTipo() == 3) {
                            System.out.println(d.toString());
                        }
                        break;
                    case 4: // Mostrar otros dispositivos
                        if (d.getTipo() == 4) {
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

    // Método para buscar un dispositivo por su ID
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

    // Método para borrar un dispositivo marcándolo como borrado
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
            dispositivo.setBorrado(true); //
            dispositivo.save(); // Guardamos los cambios
            System.out.println("Dispositivo con ID " + id + " marcado como borrado.");

            // listaDispositivos.clear(); // Limpiamos la lista actual
            // cargarArraylist(); // Recargamos la lista DESPUÉS de guardar
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    // Método para cambiar el estado de un dispositivo
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
                } else if (est == 2) {
                    nuevoEstado = false;
                }
            } catch (Exception e) {
                System.out.println("Error al cambiar el estado");
                e.printStackTrace();
            }
            dispositivo.setEstado(nuevoEstado);
            dispositivo.save(); // Guardamos cambios en el archivo
            // listaDispositivos.clear();
            // listaDispositivos.add(dispositivo);
            System.out.println("Estado del dispositivo con ID " + id + " cambiado.");
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    // Método para modificar la información de un dispositivo
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
            System.out.print("Modificar marca (actual: " + dispositivo.getMarca() + "): ");
            String nuevaMarca = sc.next();
            dispositivo.setMarca(nuevaMarca);

            System.out.print("Modificar modelo (actual: " + dispositivo.getModelo() + "): ");
            String nuevoModelo = sc.next();
            dispositivo.setModelo(nuevoModelo);

            dispositivo.save(); // Guardar cambios en el archivo
            System.out.println("Dispositivo con ID " + id + " modificado.");
        } else {
            System.out.println("Dispositivo con ID " + id + " no encontrado.");
        }
    }

    // Método para comprobar si un dispositivo está marcado como borrado
    public void recuperarDispositivo() {
        try {
            System.out.println(); // ESPACIADO
            System.out.println("LISTA DE DISPOSITIVOS BORRADOS:");
            for (Dispositivo d : listaDispositivos) {
                if (d.borrado()) {
                    System.out.println(d.toString());
                }
            }
            System.out.println(); // ESPACIADO

            System.out.println("¿Qué dispositivo deseas recuperar?");
            int idRecuperado = sc.nextInt();

            for (Dispositivo d : listaDispositivos) {
                if (d.getId() == idRecuperado) {
                    d.setBorrado(false);
                }
            }
            System.out.println(); // ESPACIADO
            System.out.println("Dispositivo recuperado con éxito");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
