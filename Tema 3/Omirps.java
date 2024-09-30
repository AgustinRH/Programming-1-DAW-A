import java.util.Scanner;

public class Omirps {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        String numero1,inverso = "";

        System.out.println("Introduce un número: ");
        num1 = sc.nextInt();
        boolean primo = true;

        for (int i = 2; i <= num1/2; i++){
            if(num1 % i == 0){
                primo = false;
            break; 
            }
        }
        if (primo) {
            numero1 = Integer.toString(num1);
            for (int k = numero1.length() - 1; k >= 0; k --) {
                inverso = inverso + numero1.charAt(k);
            }

            num2 = Integer.parseInt(inverso);
            
            boolean primo2 = true;
            for(int j = 2; j <= num2/2; j++){
                if(num2 % j == 0) {
                    primo2 = false;
                }  
            }

            if (primo2){
                System.out.println("El número " + inverso + " ES Omirp");
            }
            else{
                System.out.println("El número " + inverso + "NO es Omirp");
            }
        }
        sc.close();
    }
}
