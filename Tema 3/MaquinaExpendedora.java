import java.util.Scanner;

public class MaquinaExpendedora {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double dinero, resto;
        int euros, cincuent = 0, venti = 0, ten = 0, five = 0, two = 0, one = 0;
        System.out.println("Ingrese la cantidad de dinero: ");
        dinero = sc.nextDouble();

        euros = (int)dinero;
        System.out.println(euros);

        resto = (dinero - (double)euros);
        resto = resto * 100;
        if (resto >= 50) { //Monedas de 50 céntimos 
            cincuent = (int)resto / 50;
            resto -= (50*(double)cincuent);
           
        } 
        if(resto >= 20) { //Monedas de 20 céntimos 
            venti = (int)resto / 20;
            resto -= (20*(double)venti);
           
        }if(resto >= 10) { //Monedas de 10 céntimos 
            ten = (int)resto / 10;
            resto -= (10*(double)ten);
            
        } 
        if(resto >= 5) { //Monedas de 5 céntimos 
            five = (int)resto / 5;
            resto -= (5*(double)five);
        }  
        
        if(resto >= 2) { //Monedas de 2 céntimos 
            two = (int)resto / 2;
            resto -= (2*(double)two);
        } 
        
        if(resto >= 1) { //Monedas de 1 céntimos
            one = (int)resto/1;
            resto -= (1*(double)one);
        }

        System.out.println("Monedas de euro: " + euros);
        System.out.println("Monedas de 50 cents: " + cincuent);
        System.out.println("Monedas de 20 cents: " + venti);
        System.out.println("Monedas de 10 cents: " + ten);
        System.out.println("Monedas de 5 cents: " + five);
        System.out.println("Monedas de 2 cents: " + two);
        System.out.println("Monedas de 1 cents: " + one);

        sc.close();
    }
}
