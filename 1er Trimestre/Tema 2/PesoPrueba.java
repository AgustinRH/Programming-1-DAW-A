import java.util.Scanner;

public class PesoPrueba {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double cantidad;
        String unidad;

        // Pedimos al usuario que eliga una unidad de medida.
        System.out.println("Inserte la unidad de medida: (Lb = libras, Oz = Onzas, Kg = Kilogramos)");
        unidad = sc.nextLine();

        // Ahora le pedimos la cantidad de la unidad.
        System.out.println("Inserte la cantidad: ");
        cantidad = sc.nextDouble();
        
        Peso peso = new Peso(cantidad, unidad);

        System.out.println("La cantidad en Libras es " + peso.getLibras());
        System.out.println("La cantidad en Onzas es " + peso.getOnzas());
        System.out.println("La cantidad en Kilogramos es " + peso.getPeso());
        sc.close();
    }
}
