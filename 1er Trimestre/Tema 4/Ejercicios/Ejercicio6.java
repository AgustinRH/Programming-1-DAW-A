import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10000];

        // Rellenamos el array de números aleatorios entre 1 y 10000.
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)((Math.random()*10000)+1);
        }

        Arrays.sort(array);

        // Mostramos el Array
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
        sc.close();
    }
}
