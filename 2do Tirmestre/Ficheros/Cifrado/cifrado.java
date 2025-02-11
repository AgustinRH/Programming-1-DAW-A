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
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream(cifrado);

            int content;
            while ((content = fis.read()) != -1) {
                char letra = (char) content;

                // Incrementar el carácter
                if (letra == 'z') {
                    letra = 'a';
                } else if (letra == 'Z') {
                    letra = 'A';
                } else if (letra >= 'a' && letra < 'z') {
                    letra++;
                } else if (letra >= 'A' && letra < 'Z') {
                    letra++;
                }
                if (letra == ' ') {
                    letra = '*';
                }

                fos.write(letra);
                fis.close();
                fos.close();
            }
        } catch (IOException e) {
            System.out.println("Error al cifrar el archivo: " + e.getMessage());
        }
    }
}
