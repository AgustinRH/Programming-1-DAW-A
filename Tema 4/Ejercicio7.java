import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[2000000];
        boolean encontrado = false;
        System.out.println("Inserta un número: ");
        int buscar = sc.nextInt();

        for (int i = 0; i < array.length; i++) {
            array[i] = (int)((Math.random()*2000000) + 1);
        }

        Arrays.sort(array);

            // Búsqueda secuencial
            for(int j = 0; j < (array.length); j++){
                if(array[j] == buscar) {
                    System.out.println("El número estaba en la posición " + j);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se ha encontrado el número...");
            }

        sc.close();
    }
}
