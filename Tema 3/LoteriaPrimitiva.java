public class LoteriaPrimitiva {
    public static void main(String[] args) {
        double num;
        System.out.println("LOTERIA PRIMITIVA");

        // Sacamos 6 números al azar del 1 al 6.
        for (int i = 1; i <= 6; i++) {
            num = (Math.random()*49 + 1);
            System.out.print((int)num + " ");
        }
    }
}
