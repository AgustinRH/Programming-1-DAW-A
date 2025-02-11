import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Encriptar {

    /**
     * Este programa encripta el contenido de un archivo de texto mediante el método césar.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos al usuario los datos (nombres de los archivos y clave de encriptación)
        System.out.print("Introduce el nombre del archivo de entrada: ");
        String archivoEntrada = sc.nextLine();
        
        System.out.print("Introduce el nombre del archivo de salida: ");
        String archivoSalida = sc.nextLine();
        
        System.out.print("Introduce la clave de encriptación: ");
        int clave = sc.nextInt();
        
        try {
            // Abre el archivo de entrada para lectura
            FileInputStream fis = new FileInputStream(archivoEntrada);
            // Abre el archivo de salida para escritura
            FileOutputStream fos = new FileOutputStream(archivoSalida);
            
            int caracter;
            // Lee el archivo de entrada carácter a carácter
            while ((caracter = fis.read()) != -1) {
                char c = (char) caracter; // Convierte el byte leído en un carácter
                char cEncriptado = encriptarCaracter(c, clave); // Encripta el carácter
                fos.write(cEncriptado); // Escribe el carácter encriptado en el archivo de salida
            }
            
            // Cierra el archivo de entrada
            fis.close();
            // Cierra el archivo de salida
            fos.close();
            System.out.println("El archivo ha sido encriptado correctamente.");
        } catch (IOException e) {
            // Maneja cualquier excepción de E/S
            System.out.println("Error al leer o escribir en los archivos: " + e.getMessage());
        }
    }

    /**
     * Método para encriptar un carácter usando el cifrado César
     * @param c El carácter que se quiere encriptar
     * @param clave La clave de encriptación (cantidad de posiciones que se desplaza el alfabeto)
     * @return El carácter encriptado
     */
    private static char encriptarCaracter(char c, int clave) {
        // Definimos las letras que nos interesa encriptar (puedes añadir otras)
        String alfabeto = "abcdefghijklmnopqrstuvwxyzáéíóúüñ";
        String alfabetoMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÜÑ";
        char caracterEncriptado = c; // Si el carácter no está en el alfabeto anterior, no lo cambiaremos

        clave = clave % alfabeto.length(); // Si la clave es muy grande, nos quedamos con la parte significativa
        
        // Si el carácter que queremos encriptar es una letra minúscula...
        if (Character.isLowerCase(c)) {
            // Buscaremos la posición del carácter en el alfabeto en minúsculas
            int pos = alfabeto.indexOf(c);
            if (pos != -1) {
                // Calculamos la nueva posición con el método césar
                pos = pos + clave;
                if (pos >= alfabeto.length()) // Nos hemos salido del alfabeto, hay que "dar la vuelta"
                    pos = pos - alfabeto.length();
                // Devolveremos el carácter que hay en esa posición
                caracterEncriptado = alfabeto.charAt(pos);
            }
        // Si el carácter que queremos encriptar es una letra mayúscula...
        } else if (Character.isUpperCase(c)) {
            // Buscaremos la posición del carácter en el alfabeto en mayúsculas
            int pos = alfabetoMayus.indexOf(c);
            if (pos != -1) {
                // Calculamos la nueva posición con el método césar
                pos = pos + clave;
                if (pos >= alfabeto.length()) // Nos hemos salido del alfabeto, hay que "dar la vuelta"
                    pos = pos - alfabeto.length();
                // Devolveremos el carácter que hay en esa posición
                caracterEncriptado = alfabetoMayus.charAt(pos);
            }
        }
        
        return caracterEncriptado;
    }
}