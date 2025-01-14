import java.util.Scanner;
import java.io.FileInputStream;

public class ContarLetras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el nombre del fichero: ");
        String fichero = sc.next();

        // Array para contar la frecuencia de cada letra
        int[] frecuencia = new int[26];
        int totalLetras = 0;
        int caracteresNoImprimibles = 0;

        try (FileInputStream fis = new FileInputStream(fichero)) {
            int content;
            while ((content = fis.read()) != -1) {
                char letra = (char) content;

                // Comprobar si es una letra mayúscula o minúscula
                if (letra >= 'a' && letra <= 'z') {
                    frecuencia[letra - 'a']++;
                    totalLetras++; // Solo contar letras
                } else if (letra >= 'A' && letra <= 'Z') {
                    frecuencia[letra - 'A']++;
                    totalLetras++; // Solo contar letras
                } else {
                    caracteresNoImprimibles++;
                }
            }

            // Imprimir resultados
            System.out.println("Núm. de caracteres del archivo: " + (totalLetras + caracteresNoImprimibles));
            System.out.println("Letra\tNúm. de veces que aparece\tFrecuencia (%)");
            System.out.println("------------------------------------------------------------");

            for (int i = 0; i < frecuencia.length; i++) {
                char letra = (char) (i + 'a');
                double porcentaje;

                if (totalLetras > 0) {
                    porcentaje = (frecuencia[i] / (double) totalLetras) * 100;
                } else {
                    porcentaje = 0;
                }

                System.out.printf("%c\t%d\t\t\t\t%.2f %%\n", letra, frecuencia[i], porcentaje);
            }

            double porcentajeNoImprimibles;

            if (totalLetras + caracteresNoImprimibles > 0) {
                porcentajeNoImprimibles = (caracteresNoImprimibles / (double) (totalLetras + caracteresNoImprimibles))
                        * 100;
            } else {
                porcentajeNoImprimibles = 0;
            }
            System.out.printf("no imprimibles\t%d\t\t\t\t%.2f %%\n", caracteresNoImprimibles, porcentajeNoImprimibles);

        } catch (Exception ex) {
            System.err.println("Error al abrir el archivo: " + ex.getMessage());
        }

        sc.close();
    }
}