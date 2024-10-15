public class RuletaV2 {
    double saldo = 0;
    int numRandom, colorRandom;

    public RuletaV2(double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(double saldo) {
        this.saldo += saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int numeroRuleta(){
        numRandom = (int) (Math.random() * 20 + 1);
        return numRandom;
    }

    public int colorRuleta(){
        colorRandom = (int) (Math.random() * 2 + 1);
        return colorRandom;
    }

    public void colorAcertado(double apuestaColor) {
        saldo += apuestaColor *2;
    }

    public void numeroAcertado(double apuestaNumero) {
        saldo += apuestaNumero *6;
    }
}
