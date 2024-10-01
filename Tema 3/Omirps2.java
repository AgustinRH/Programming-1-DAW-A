import java.util.Scanner;

public class Omirps2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        for (int i = 2; i < 1000; i++) {
            num1 = i;
            String numero1, inverso = "";

            boolean primo = true;

            for (int j = 2; j <= num1 / 2; j++) {
                if (num1 % j == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                numero1 = Integer.toString(num1);
                for (int k = numero1.length() - 1; k >= 0; k--) {
                    inverso = inverso + numero1.charAt(k);
                }

                num2 = Integer.parseInt(inverso);

                boolean primo2 = true;
                for (int l = 2; l <= num2 / 2; l++) {
                    if (num2 % l == 0) {
                        primo2 = false;
                    }
                }

                if (primo2) {
                    System.out.println(i + " es Omirp");
                }
            }
        }
    }
}
