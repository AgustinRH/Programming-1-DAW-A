import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploFis {

    public static void main(String[] args) {
        // Ruta del archivo de entrada
        String archivoEntrada = "entrada.txt";
        // Ruta del archivo de salida
        String archivoSalida = "salida.txt";

        // Llamamos al método para copiar el contenido del archivo de entrada al archivo de salida
        copiarArchivo(archivoEntrada, archivoSalida);
    }

    /**
     * Método para copiar el contenido de un archivo a otro usando FileInputStream y FileOutputStream.
     * 
     * @param archivoEntrada Ruta del archivo de entrada.
     * @param archivoSalida Ruta del archivo de salida.
     */
    public static void copiarArchivo(String archivoEntrada, String archivoSalida) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Abre el archivo de entrada para lectura
            fis = new FileInputStream(archivoEntrada);
            // Abre el archivo de salida para escritura
            fos = new FileOutputStream(archivoSalida);

            int byteLeido;
            // Lee el archivo de entrada byte por byte
            while ((byteLeido = fis.read()) != -1) {
                // Escribe el byte leído en el archivo de salida
                fos.write(byteLeido);
            }

            System.out.println("Archivo copiado exitosamente.");

        } catch (IOException e) {
            // Maneja cualquier excepción de E/S
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        } finally {
            try {
                // Cierra el archivo de entrada si está abierto
                if (fis != null) {
                    fis.close();
                }
                // Cierra el archivo de salida si está abierto
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar los archivos: " + e.getMessage());
            }
        }
    }
}
