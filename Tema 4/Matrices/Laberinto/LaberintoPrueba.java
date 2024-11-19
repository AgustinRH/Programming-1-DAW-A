package Matrices.Laberinto;

import java.util.Scanner;

public class LaberintoPrueba {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte el alto del laberinto: ");
        int alto = sc.nextInt();

        System.out.println("Inserte el ancho del laberinto: ");
        int ancho = sc.nextInt();

        Laberinto lab = new Laberinto(alto, ancho);

        lab.crearLaberinto();

        lab.mostrarLaberinto();
    

        sc.close();
    }    
}
