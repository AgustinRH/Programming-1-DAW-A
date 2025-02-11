import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Desencriptar {

    /**
     * Este programa desencripta el texto de un archivo de texto cifrado con el método césar
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos al usuario los datos (fichero encriptado y clave)
        System.out.print("Introduce el nombre del archivo cifrado: ");
        String archivoEntrada = sc.nextLine();
        
        System.out.print("Introduce la clave de encriptación utilizada (un número entero): ");
        int clave = sc.nextInt();
        
        try {
            // Abre el archivo cifrado para lectura
            FileInputStream fis = new FileInputStream(archivoEntrada);
            
            int caracter;
            // Lee el archivo cifrado carácter a carácter
            while ((caracter = fis.read()) != -1) {
                char c = (char) caracter; // Convierte el byte leído en un carácter
                char cDesencriptado = desencriptarCaracter(c, clave); // Desencripta el carácter
                System.out.print(cDesencriptado); // Muestra el carácter desencriptado por la consola
            }
            // Cierra el archivo cifrado
            fis.close();
            System.out.println("\nEl archivo ha sido desencriptado correctamente.");
        } catch (IOException e) {
            // Maneja cualquier excepción de E/S
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Este método desencripta un carácter mediante el método césar
     * @param c El carácter encriptado que se quiere descifrar
     * @param clave La clave de encriptación (cantidad de desplazamientos)
     * @return El carácter desencriptado
     */
    private static char desencriptarCaracter(char c, int clave) {
        // Definimos las letras que nos interesa desencriptar (puedes añadir otras)
        String alfabeto = "abcdefghijklmnopqrstuvwxyzáéíóúüñ";
        String alfabetoMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÜÑ";
        char caracterDesencriptado = c;

        clave = clave % alfabeto.length(); // Si la clave es muy grande, nos quedamos con la parte significativa

        // Si la letra es un carácter en minúsculas...
        if (Character.isLowerCase(c)) {
            int pos = alfabeto.indexOf(c);
            if (pos != -1) {
                pos = pos - clave;
                if (pos < 0) pos = pos + alfabeto.length(); // Nos hemos salido del alfabeto, hay que "dar la vuelta"
                caracterDesencriptado = alfabeto.charAt(pos);
            }
        // Si la letra es un carácter en mayúsculas...
        } else if (Character.isUpperCase(c)) {
            int pos = alfabetoMayus.indexOf(c);
            if (pos != -1) {
                pos = pos - clave;
                if (pos < 0) pos = pos + alfabeto.length(); // Nos hemos salido del alfabeto, hay que "dar la vuelta"
                caracterDesencriptado = alfabetoMayus.charAt(pos);
            }
        }
        
        // Si no es una letra, devolver el mismo carácter sin modificarlo
        return caracterDesencriptado;
    }
}
