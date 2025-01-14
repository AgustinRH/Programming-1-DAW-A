import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Concatenar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el nombre del primer fichero: ");
        String f1 = sc.next();

        System.out.println("Dime el nombre del segundo fichero: ");
        String f2 = sc.next();

        System.out.println("Dime el nombre del nuevo fichero: ");
        String fend = sc.next();

        try {
            FileInputStream fis1 = new FileInputStream(f1);
             FileInputStream fis2 = new FileInputStream(f2);
             FileOutputStream fos = new FileOutputStream(fend);

            int content;
            while ((content = fis1.read()) != -1) {
                fos.write(content);
            }
            fis1.close();
            fos.write("\n".getBytes());

            while ((content = fis2.read()) != -1) {
                fos.write(content);
            }
            fis2.close();

            System.out.println("Archivos concatenados exitosamente en: " + fend);
            fos.close();
        } catch (IOException e) {
            System.err.println("Error con los archivos: " + e.getMessage());
        }
        sc.close();
    }
}