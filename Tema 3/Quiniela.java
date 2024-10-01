import java.util.Scanner;

public class Quiniela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quiniela");

        double num;

        for (int i = 1; i <= 14; i++) {
            num = Math.random() * 3 + 1;

            switch ((int)num) {
                case 1:
                    System.out.print(1 + " - ");
                    break;
                case 2:
                    System.out.print(2 + " - ");
                    break;
                case 3:
                    System.out.print("X - ");
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
