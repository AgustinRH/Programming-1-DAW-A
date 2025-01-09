import java.util.Scanner;

public class EstadisticaBasica {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, num;
        double med = 0;
        
        for(int i = 1; i <= 10; i++) {
            System.out.println("Inserte el número " + i + "º");
            num = sc.nextInt();

            med = med + num;

            if (max < num) {
                max = num;   
            }
            if (min > num) {
                min = num;
            }
        }
        med = med / 10;
        System.out.println("El número máximo es " + max);
        System.out.println("El número mínimo es " + min);
        System.out.println("La media de los números es " + med);

        sc.close();
    }
}
