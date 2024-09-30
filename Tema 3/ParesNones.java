import java.util.Scanner;

public class ParesNones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = 0, a, b;
        System.out.println("¿QUÉ QUIERES CONOCER, PARES o NONES?  (PARES = 1, NONES = 2)");
        valor = sc.nextInt();

        switch (valor) {
            case 1:
                System.out.println("Inserta el valor de A");
                a = sc.nextInt();
                System.out.println("Inserta el valor de B");
                b = sc.nextInt();
                if (a % 2 == 0) {
                    if (a < b) {
                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    } else if (a > b) {
                        int aux = 0;
                        aux = a;
                        a = b;
                        b = aux;

                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }

                    } else {
                        System.out.println("No se pueden sacar números entre 2 números iguales.");
                    }
                } else {
                    a = a + 1;
                    if (a < b) {
                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    } else if (a > b) {
                        int aux = 0;
                        aux = a;
                        a = b;
                        b = aux;

                        System.out.println("Los números pares entre " + a + " y " + b + " son:");
                        for (int i = a; i < b; i = i + 2) {
                            System.out.println(i);
                        }
                    } else {
                        System.out.println("No se pueden sacar números entre 2 números iguales.");
                    }
                }
                break;
            case 2:
                System.out.println("Inserta el valor de A");
                a = sc.nextInt();
                System.out.println("Inserta el valor de B");
                b = sc.nextInt();
                // Comprobamos si A es menor que B para sacar los números impares.
                if (a < b) {
                    if (a % 2 != 0) {
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
                } else if (a > b) { // Comprobamos si B es menor que A para sacar los números impares.
                    int aux = 0;

                    aux = a;
                    a = b;
                    b = aux;

                    if (a % 2 != 0) {
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
                } else { // Comprobamos que los números no sean iguales.
                    System.out.println("Los números son iguales. No puedo obtener ningún número impar.");
                }
                break;
            default:
                System.out.println("Error al elegir la opción");
        }
    }
}
