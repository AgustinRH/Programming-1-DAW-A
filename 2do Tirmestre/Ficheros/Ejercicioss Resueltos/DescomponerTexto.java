import java.io.FileOutputStream;

class DescomponerTexto {

    public static void main(String[] args) {

        // SOLUCIÓN 1: Escribir carácter a carácter

        // Solicita al usuario que escriba un texto
        System.out.println("Escribe un texto:");
        // Lee el texto ingresado por el usuario
        String s = System.console().readLine();
        try {
            // Abre el archivo de salida para escritura
            FileOutputStream fos = new FileOutputStream("salida.txt");
            // Recorre cada carácter del texto ingresado
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // Si el carácter es un espacio, escribe un salto de línea en el archivo
                if (c == ' ') fos.write('\n');
                else fos.write(c); // Si no, escribe el carácter en el archivo
            }
            // Cierra el archivo de salida
            fos.close();
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante el proceso
            System.out.println("Error al escribir en el fichero");
            e.printStackTrace();
        }
        // Muestra un mensaje indicando que el texto se guardó con éxito
        System.out.println("Texto salvado con éxito");


/*
        // SOLUCIÓN 2: escribir palabra a palabra
        
        // Solicita al usuario que escriba un texto
        System.out.println("Escribe un texto:");
        // Lee el texto ingresado por el usuario
        String s = System.console().readLine();
        // Divide el texto en palabras usando el espacio como delimitador
        String palabras[] = s.split(" ");
        try {
            // Abre el archivo de salida para escritura
            FileOutputStream fos = new FileOutputStream("salida.txt");
            // Recorre cada palabra del texto ingresado
            for (int i = 0; i < palabras.length; i++) {
                // Agrega un salto de línea al final de cada palabra
                String pal = palabras[i] + "\n";
                // Escribe la palabra en el archivo
                fos.write(pal.getBytes());
            }
            // Cierra el archivo de salida
            fos.close();
        } catch (Exception e) {
            // Maneja cualquier excepción que ocurra durante el proceso
            System.out.println("Error al escribir en el fichero");
            e.printStackTrace();
        }
        // Muestra un mensaje indicando que el texto se guardó con éxito
        System.out.println("Texto salvado con éxito");

*/
    }    
}