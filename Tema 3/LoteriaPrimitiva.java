public class LoteriaPrimitiva {
    public static void main(String[] args) {
        double num;
        System.out.println("LOTERIA PRIMITIVA");

        for (int i = 1; i <= 6; i++) {
            num = (Math.random()*49 + 1);
            System.out.print((int)num + " ");
        }
    }
}
