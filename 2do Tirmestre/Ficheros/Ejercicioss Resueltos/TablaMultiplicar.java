import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TablaMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario que introduzca un número
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();

        // Nombre del archivo donde se guardará la tabla de multiplicar
        String nombreArchivo = "tabla_" + numero + ".txt";

        // Crea un objeto File que representa el archivo
        File archivo = new File(nombreArchivo);

        try {
            // Crea un objeto FileOutputStream para escribir en el archivo
            FileOutputStream fos = new FileOutputStream(archivo);

            // Escribe la tabla de multiplicar en el archivo
            for (int i = 1; i <= 10; i++) {
                String linea = numero + " x " + i + " = " + (numero * i) + "\n";
                fos.write(linea.getBytes());
            }

            // Cierra el flujo de salida
            fos.close();

            // Muestra un mensaje indicando que la tabla de multiplicar se ha guardado con éxito
            System.out.println("La tabla de multiplicar se ha guardado en el archivo " + nombreArchivo);

        } catch (IOException e) {
            // Maneja cualquier error que ocurra durante el procesamiento del archivo
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
