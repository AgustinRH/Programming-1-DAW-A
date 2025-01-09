import java.util.Scanner;

public class TPV {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        double precio;
        int discount = 0;
        System.out.println("Ingrese su edad: ");
        edad = sc.nextInt();
        System.out.println("Ingrese el precio del producto: ");
        precio = sc.nextDouble();

        if (edad > 65) {
            discount = 1;
        } else if (edad < 25) {
            discount = 2;
        } else if (edad < 0) {
            discount = 3;
        }

        switch (discount) {
            case 1:
                precio = (precio * 0.85);
                System.out.println("Tienes descuento por ser +65 años. El precio es de " + precio);
                break;
            case 2:
                precio = (precio * 0.90);
                System.out.println("Tienes descuento por ser -25 años. El precio es de " + precio);
                break;
            case 3: 
                System.out.println("Fin de la compra.");
                break;
            default:
            System.out.println("No tienes descuento por edad.");
                break;
        }

        sc.close();
    }
}
