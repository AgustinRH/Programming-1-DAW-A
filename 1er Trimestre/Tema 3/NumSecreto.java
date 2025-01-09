import java.util.Scanner;

public class NumSecreto {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Intenta adivinar el número secreto!");
        int user = -1, secret = -3, count = 0;
        secret = (int)(Math.random()* 100 + 1); // Obtiene un número al azar entre 1 y 100
        while (user != secret) { 

            System.out.println("¿Qúe número crees que se esconde tras la caja?");
            user = sc.nextInt();

            //Comprobamos si el usuario esta cerca o lejos del número secreto.
            if (user > secret) {
                System.out.println("Te has pasado. el número es menor que el introducido.");
            } else if(user < secret){
                System.out.println("Te has quedado corto. El número es mayor que el introducido");
            }

            count += 1;
        }

        //Avisamos al usuario de que ha acertado y le damos el número de veces intentadas.
        System.out.println("¡Has acertado!");
        System.out.println("Lo has intentado " + count + " veces.");

        sc.close();
    }
}
