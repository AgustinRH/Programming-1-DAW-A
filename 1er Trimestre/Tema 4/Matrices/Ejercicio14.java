package Matrices;

public class Ejercicio14 {
    public static void main (String [] args) {
        int[][] matriz = new int[10][10];

        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length; j++) {
                matriz[i][j] = -1;
            }
        }

        for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < matriz.length; l++) {
                System.out.print(matriz[k][l]);
            }
            System.out.println();
        }
    }
}
