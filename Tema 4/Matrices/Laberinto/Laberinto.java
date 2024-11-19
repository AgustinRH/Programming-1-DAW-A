package Matrices.Laberinto;

public class Laberinto {


    private int alto, ancho;
    private int[][] lab = new int[alto][ancho];

    public Laberinto(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho; 
    }

    public void crearLaberinto(){

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab.length; j++) {
                lab[i][j] = 1;
            }
        }
    }

    public void mostrarLaberinto() {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab.length; j++) {
                System.out.print(lab[i][j]);
            }
            System.out.println();
        }
    }
}
