import java.io.FileInputStream;

class RecomponerTexto {

    public static void main(String[] args) {

        // Muestra un mensaje indicando que se va a recuperar el texto del fichero
        System.out.println("Texto recuperado del fichero salida.txt:");
        try {
            // Abre el archivo de entrada para lectura
            FileInputStream fis = new FileInputStream("salida.txt");
            int c;
            // Lee el archivo de entrada carácter a carácter
            while ((c = fis.read()) != -1) {
                // Si el carácter leído es un salto de línea, imprime un espacio
                if ((char)c == '\n') System.out.print(" ");
                else System.out.print((char)c); // Si no, imprime el carácter leído
            }
            // Cierra el archivo de entrada
            fis.close();
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante el proceso
            System.out.println("Error al leer el fichero");
            //e.printStackTrace();
        }
        // Muestra un mensaje indicando que se ha terminado de recuperar el texto
        System.out.println();
    }
}