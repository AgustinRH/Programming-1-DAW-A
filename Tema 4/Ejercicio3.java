public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("LOTERIA PRIMITIVA");
        System.out.println(".................");
        System.out.print("Los números de loteria son: ");

        int[] miArray = new int[6];
        int num = 0;
        for (int i = 0; i < 6; i++) {

            num = (int) (Math.random() * 49 + 1);
            while (num == miArray[i]) {
                num = (int) (Math.random() * 6 + 1);
            }
            miArray[i] = num;
            if (i == 5) {
                System.out.print(miArray[i]);
            } else {
                System.out.print(miArray[i] + "-");
            }
        }
    }
}
