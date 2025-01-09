import java.util.Scanner;

public class MayMenMed {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);


    // Pedimos al usuario el valor de los tres números.
        int num1, num2, num3;
        System.out.println("Inserte el primer número");
        num1 = sc.nextInt();
        System.out.println("Ingrese el segundo número");
        num2 = sc.nextInt();
        System.out.println("Ingrese el tercer número");
        num3 = sc.nextInt();

        int mayor, mediano, menor;
        // Comparamos los números entre si para conocer cual es el mayor, cual es el mediano
        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
            if (num2 >= num3) {
                mediano = num2;
                menor = num3;
            } else {
                mediano = num3;
                menor = num2;
            }
        } else if (num2 >= num1 && num2 >= num3) {
            mayor = num2;
            if (num1 >= num3) {
                mediano = num1;
                menor = num3;
            } else {
                mediano = num3;
                menor = num1;
            }
        } else {
            mayor = num3;
            if (num1 >= num2) {
                mediano = num1;
                menor = num2;
            } else {
                mediano = num2;
                menor = num1;
            }
        }

        // Mostramos en pantalla el resultado.
        System.out.println("Mayor: " + mayor);
        System.out.println("Mediano: " + mediano);
        System.out.println("Menor: " + menor);
        
        sc.close();
    }
}
