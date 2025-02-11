import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        System.out.println("EXAMEN DE PROGRAMACIÓN - 15 DE FEBRERO DE 2016");
        System.out.println("EJERCICIO 1");
        
        String forig = null, fdest = null;

        try {
            // Leemos los nombres de los dos ficheros
            System.out.print("Introduzca el nombre del fichero origen: ");
            forig = System.console().readLine();
            System.out.print("Introduzca el nombre del fichero destino: ");
            fdest = System.console().readLine();
            
            // Abrimos los ficheros
            FileInputStream fis = new FileInputStream(forig);
            FileOutputStream fos = new FileOutputStream(fdest);
            
            // Leemos el primer byte
            int c = fis.read();
            while (c != -1) {
                // Si es mayúscula, lo convertimos a minúscula
                if (c >= 'A' && c <= 'Z') c = c + 32;
                // Si es minúscula, lo convertimos a mayúscula
                else if (c >= 'a' && c <= 'z') c = c - 32;
                // En cualquier otro caso, no tocamos el carácter (se queda igual)
                // Y ahora, lo escribimos en el fichero destino
                fos.write(c);
                // Leemos el siguiente byte del fichero origen
                c = fis.read();
            }
            fis.close();
            fos.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }
}
