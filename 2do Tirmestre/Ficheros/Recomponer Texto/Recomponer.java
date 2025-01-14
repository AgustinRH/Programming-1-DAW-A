
import java.io.FileInputStream;
import java.util.Scanner;

public class Recomponer {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        FileInputStream fis;

        System.out.println("Dime el nombre del archivo (Ejemplo: 'archivo.txt'):  ");
        String archivo = sc.next();
        System.out.print("\nCONTENIDO DEL FICHERO: ");
        
        try {
            fis = new FileInputStream(archivo);
            int content;
            while((content = fis.read()) != -1 ) {
                if ((char)content == '\n') {
                    System.out.print(" ");
                }
                else {System.out.print((char)content);}
            }
            fis.close();
        } catch (Exception e) {
            System.out.println("Error al leer el fichero");
        }

        sc.close();
    }
}
