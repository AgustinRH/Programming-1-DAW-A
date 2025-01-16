import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class cifrado {

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
