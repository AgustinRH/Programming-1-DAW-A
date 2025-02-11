import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase para cifrar archivos de texto.
 */
public class cifrado {

    /**
     * Cifra el contenido de un archivo de texto y guarda el resultado en otro archivo.
     * 
     * @param archivo Ruta del archivo de texto original.
     * @param cifrado Ruta del archivo donde se guardará el texto cifrado.
     */
    public void cifrar(String archivo, String cifrado) {
        try {
            // Abre el archivo de entrada para lectura
            FileInputStream fis = new FileInputStream(archivo);
            // Abre el archivo de salida para escritura
            FileOutputStream fos = new FileOutputStream(cifrado);

            int content;
            // Lee el archivo de entrada byte por byte
            while ((content = fis.read()) != -1) {
                char letra = (char) content;

                // Incrementa el carácter
                if (letra == 'z') {
                    letra = 'a';
                } else if (letra == 'Z') {
                    letra = 'A';
                } else if (letra >= 'a' && letra < 'z') {
                    letra++;
                } else if (letra >= 'A' && letra < 'Z') {
                    letra++;
                }
                // Reemplaza los espacios por asteriscos
                if (letra == ' ') {
                    letra = '*';
                }

                // Escribe el carácter cifrado en el archivo de salida
                fos.write(letra);
            }
            // Cierra el archivo de entrada
            fis.close();
            // Cierra el archivo de salida
            fos.close();
        } catch (IOException e) {
            // Maneja cualquier excepción de E/S
            System.out.println("Error al cifrar el archivo: " + e.getMessage());
        }
    }
}
