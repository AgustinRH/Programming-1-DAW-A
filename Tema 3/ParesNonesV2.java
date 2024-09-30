import java.util.Scanner;

public class ParesNonesV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = 0, a, b;
        System.out.println("Inserte el valor de 'A': ");
        a = sc.nextInt();
        System.out.println("Inserte el valor de 'B': ");
        b = sc.nextInt();
        if (a > b) {
            int aux = 0;
            aux = a;
            a = b;
            b = aux;
        }
        System.out.println(
                "Si quieres conocer los números Pares pulsa '1', si quieres conocer los números Impares pulsa '2':  ");
        valor = sc.nextInt();
        if (a != b) {
            switch (valor) {
                case 1:
                    if (a % 2 == 0) {
                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    } else {
                        a = a + 1;
                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 2:
                    if (a % 2 != 0) {
                        System.out.println("Los números impares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    } else {
                        a = a + 1;
                        System.out.println("Los números impares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    }
                    break;
                default:
                    System.out.println("Error al elegir una opción.");
                    break;
            }
        } else {
            System.out.println("'A' y 'B' no pueden ser iguales.");
        }
    }
}