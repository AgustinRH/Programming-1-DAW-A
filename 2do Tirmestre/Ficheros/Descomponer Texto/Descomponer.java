import java.io.FileOutputStream;
import java.util.Scanner;

public class Descomponer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce texto (Pulsa Enter para terminar...): ");
        String texto = sc.nextLine();


        String[] palabras = texto.split(" ");

        try {
            FileOutputStream fos = new FileOutputStream("Archivo.txt");
            for (int i = 0; i < palabras.length; i++) {
                palabras[i] += "\n";
                fos.write(palabras[i].getBytes());
            }

            System.out.println("Archivo creado correctamente");
            fos.close();
        } catch (Exception e) {
            System.out.println("Error al completar el archivo");
        }

        sc.close();
    }
}
