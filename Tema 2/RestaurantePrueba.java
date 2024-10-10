import java.util.Scanner;

public class RestaurantePrueba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        int opc = 0, numHuevos, addHue;
        double kgChorizo, addCho;

        System.out.println("REPARTIDOR:  ¡¡Buenas empleado!!, ¿Cuántas docenas de huevos quieres que te deje?");
        numHuevos = sc.nextInt();
        System.out.println("TÚ:  Démaje " + numHuevos + " docenas de huevos para mi restaurante.");

        System.out.println("REPARTIDOR:  ¿Y cuántos Kg de chorizo?");
        kgChorizo = sc.nextDouble();
        System.out.println("TÚ:  Démaje " + kgChorizo + " kg de chorizo para mi restaurante.");
        
        Restaurante rest = new Restaurante(numHuevos, kgChorizo);

        while (continuar) {
            System.out.println("¡¡BIENVENIDO AL RESTAURANTE CASA PACO!!");
            System.out.println("----------------------------------------");
            System.out.println("¿Qué desea realizar?");
            System.out.println("1. Obtener número de platos disponibles. \n 2. Servir plato. \n 3. Obtener cantidad de huevos. \n 4. Obtener cantidad de chorizo. \n 5. Añadir huevos (1 equivale a una docena). \n  6. Añadir chorizo. \n 7. Salir" );
            opc = sc.nextInt();
            
            switch (opc) {
                case 1:
                    System.out.println("El número de paltos es de " + rest.getNumPlatos());
                    break;
                case 2:
                    rest.sirvePlato();
                    break;
                case 3:
                    System.out.println("Te quedan " + rest.getHuevos() + " huevos.");
                    break;
                case 4:
                System.out.println("Te quedan " + rest.getChorizos() + " kg de chorizo.");
                    break;
                case 5:
                    System.out.println("¿Cuántas docenas de huevos quieres añadir?");
                    addHue = sc.nextInt();
                    break;
                case 6:
                    System.out.println("¿Cuántos kg de chorizo quieres añadir?");
                    addCho = sc.nextDouble();
                    break;
                case 7:
                    System.out.println("¡¡Hasta pronto!!");
                    continuar = false;
                default:
                System.out.println("Opción incorrectá");
                    break;
            }
        }

        sc.close();

    }
}
