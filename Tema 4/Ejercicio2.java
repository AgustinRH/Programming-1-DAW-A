public class Ejercicio2 {
    public static void main(String[] args) {

        //Creamos Array para Pares y para Impares 
        int[] pares = new int[100];
        int[] impares = new int[100];

        //Variables para ayudarnos a guardar los pares e impares.
        int numPar = 2, numImpar = 1;

        //Bucle para guardar todos los números PARES
        for(int i = 0; i < 100; i++) {
            pares[i] = numPar;
            System.out.println("Par "+ (i + 1) + " = " + pares[i]);
            numPar += 2;
        }
        
        //Bucle para guardar todos los número IMPARES
        for(int j = 0; j< 100; j++) {
            impares[j] = numImpar;
            System.out.println("Impar " + (j + 1) + " = " + impares[j]);
            numImpar += 2;
        }
    }
}
