import java.io.FileOutputStream;
import java.util.Scanner;

public class Multiplicar {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Diem un número: ");
        int num = sc.nextInt();

        System.out.println("Dime el nombre del fichero: ");
        String file = sc.next();

        try {
            FileOutputStream fos = new FileOutputStream(file);

            for (int i = 1; i <= 10; i++) {
                String s = num + " x "  + i + " = " + num*i + "\n";
                byte[] contentInBytes = s.getBytes();

                fos.write(contentInBytes);
            }
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        sc.close();

    }
}