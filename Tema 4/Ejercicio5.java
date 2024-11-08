import java.util.Scanner;

public class Ejercicio5 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];
        int negativo = 0;
        int positivo = 0;

        for (int i = 0; i < num.length; i++) {
            System.out.println("Inserte el valor de " + (i + 1));
            num[i] = sc.nextInt();
        }

        for (int j = 0; j < num.length; j++) {
            if (num[j]>= 0) {
                positivo += num[j];
            }
            else {
                negativo += num[j];
            }
        }

        System.out.println("La suma de los positivos es " + positivo);
        System.out.println("La suma de los negativos es " + negativo);
        sc.close();
    }
}
