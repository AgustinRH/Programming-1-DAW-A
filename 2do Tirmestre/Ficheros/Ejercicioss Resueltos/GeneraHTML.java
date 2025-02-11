import java.io.FileOutputStream;

public class GeneraHTML {

    // Variables para almacenar los datos del título y del cuerpo del HTML
    private static String textoTitulo, colorTitulo, tamTitulo;
    private static String textoCuerpo, colorCuerpo, tamCuerpo;

    // Método para leer los datos del usuario
    public static void leerDatos() {
        System.out.println("Introduce el texto del título:");
        textoTitulo = System.console().readLine();
        System.out.println("Introduce el color del título:");
        colorTitulo = System.console().readLine();
        System.out.println("Introduce el tamaño del título:");
        tamTitulo = System.console().readLine();
        
        System.out.println("Introduce el texto del cuerpo:");
        textoCuerpo = System.console().readLine();
        System.out.println("Introduce el color del cuerpo:");
        colorCuerpo = System.console().readLine();
        System.out.println("Introduce el tamaño del cuerpo:");
        tamCuerpo = System.console().readLine();
    }

    // Método para escribir el archivo HTML
    public static void escribirArchivo() {
        try {
            // Crea un objeto FileOutputStream para escribir en el archivo HTML
            FileOutputStream fos = new FileOutputStream("pagina.html");
            
            // Escribe la estructura básica del archivo HTML
            fos.write("<html>\n\t<head>\n\t\t<meta charset='UTF-8'>\n\t\t<title>Ejemplo Java</title>\n\t</head>\n".getBytes());
            fos.write(("<body><p style = 'font-size: " + tamTitulo + " ; color:" + colorTitulo + "'>" + textoTitulo + "</p>").getBytes());
            fos.write(("<p style = 'color:" + colorCuerpo + "; font-size: " + tamCuerpo + "'>" + textoCuerpo + "</p></body></html>").getBytes());
            
            // Cierra el archivo HTML
            fos.close();
        } catch (Exception e) {
            // Maneja cualquier error que ocurra durante el procesamiento del archivo
            System.out.println("Error al escribir el fichero de salida");
        }
    }
}
