import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Censura {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el nombre del archivo a descifrar: ");
        String archivo = sc.next();

        System.out.println("Dime el nombre del nuevo archivo cifrado: ");
        String cifrado = sc.next();

        try {
            int content;
            FileInputStream fis1 = new FileInputStream(archivo);
            FileOutputStream fos1 = new FileOutputStream(cifrado);

            while((content = fis1.read()) != -1){
            }
        } catch (Exception e) {
            System.out.println("Error en el archivo: " + e.getMessage());
        }

    }
}
