package Matrices;
import java.util.Scanner;

public class PermutarFilas {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);

        int[][] matriz = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 5; k++) {

                System.out.println("Inserte el valor de la matriz[" + i + "][" + k + "]: ");
                matriz[i][k] = sc.nextInt();
            }
        }



        for (int j = 0; j < 5; j++) {
            int aux = matriz[0][j];
            matriz[0][j] = matriz[2][j];
            matriz[2][j] = aux;
        }


        for (int l = 0; l < matriz.length; l++) {
            for (int f = 0; f < matriz.length; f++) {
                System.out.print(matriz[l][f]);
            }
            System.out.println();
        }


        sc.close();
    }
}
