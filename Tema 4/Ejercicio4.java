import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        int media, numero = 0;
        for(int i = 0; i < 10; i++) {
            System.out.println("Inserte el número " + (i + 1));
            num[i] = sc.nextInt();
        }

        for (int j = 0; j < num.length; j++) {
            numero += num[j];
        }

        media = numero / num.length;

        System.out.println("La media es " + media);
        

        System.out.println("Mayor que la media: ");
        for (int k = 0; k < num.length; k++) {
            if (num[k]>media) {
                System.out.println(num[k]);
            }
        }

        System.out.println();
        System.out.println("Menor que la media: ");
        for (int j = 0; j < num.length; j++) {
            if(num[j]<media){
                System.out.println(num[j]);
            }
        }
    sc.close();
    }
}
