
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class descifrado {

    public void descifrar(String archivo, String descifrado) {
        try {
            FileInputStream fis = new FileInputStream(archivo);
            FileOutputStream fos = new FileOutputStream(descifrado);

            int content;
            while ((content = fis.read()) != -1) {
                char letra = (char) content;

                // Decrementar el carácter
                if (letra == 'A') {
                    letra = 'Z';
                } else if (letra == 'a') {
                    letra = 'z';
                } else if (letra >= 'a' && letra < 'z') {
                    letra--;
                } else if (letra >= 'A' && letra < 'Z') {
                    letra--;
                } else if (letra == '*') {
                    letra = ' ';
                }

                fos.write(letra);
                fis.close();
                fos.close();
            }
        } catch (IOException e) {
            System.out.println("Error al descifrar el archivo: " + e.getMessage());
        }
    }
}
