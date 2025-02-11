import java.io.FileOutputStream;
import java.io.FileInputStream;

class ConcatenarArchivos {

    public static void main(String[] args) {

        try {
            // Abre el primer archivo de entrada para lectura
            FileInputStream fichEntrada1 = new FileInputStream("archivo1.txt");
            // Abre el segundo archivo de entrada para lectura
            FileInputStream fichEntrada2 = new FileInputStream("archivo2.txt");
            // Abre el archivo de salida para escritura
            FileOutputStream fichSalida = new FileOutputStream("archivo3.txt");

            int c = 0;
            // Obtiene el tamaño del primer archivo
            long tamFich1 = fichEntrada1.available();
            // Obtiene el tamaño del segundo archivo
            long tamFich2 = fichEntrada2.available();
            // Calcula el tamaño total de los dos archivos
            long tam = tamFich1 + tamFich2;
            long cont = 0;

            // Lee el primer archivo byte por byte y lo escribe en el archivo de salida
            while ((c = fichEntrada1.read()) != -1) {
                fichSalida.write((byte)c);
                cont++;
                // Muestra el progreso de la copia
                System.out.print(cont*100/tam + "% completado\r");
            }
            // Lee el segundo archivo byte por byte y lo escribe en el archivo de salida
            while ((c = fichEntrada2.read()) != -1) {
                fichSalida.write((byte)c);
                cont++;
                // Muestra el progreso de la copia
                System.out.print(cont*100/tam + "% completado\r");
            }
            // Cierra el primer archivo de entrada
            fichEntrada1.close();
            // Cierra el segundo archivo de entrada
            fichEntrada2.close();
            // Cierra el archivo de salida
            fichSalida.close();
            // Muestra un mensaje indicando que el archivo de salida se generó con éxito
            System.out.println("Archivo3.txt generado con éxito");
        }
        catch(Exception e) {
            // Maneja cualquier excepción que ocurra durante el proceso
            System.out.println("Error al procesar los archivos");
            e.printStackTrace();
        }

    }    
}