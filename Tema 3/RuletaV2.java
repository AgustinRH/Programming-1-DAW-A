public class RuletaV2 {
    double saldo = 0;
    int numRandom, colorRandom;

    public RuletaV2(){
        this.saldo = 0;
    }

    public RuletaV2(double saldo) {
        this.saldo = saldo;
    }

    public void apuestaNumero(double apuestaNumero) {
        this.saldo -= apuestaNumero;
    }

    public void apuestaColor(double apuestaColor) {
        this.saldo -= apuestaColor;
    }

    public void addSaldo(double saldo) {
        this.saldo += saldo;
    }

    public void removeSaldo(double saldo) {
        this.saldo -= saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getColor() {
        return this.colorRandom;
    }

    public int getNumero() {
        return this.numRandom;
    }

    public void numeroRuleta(){
        numRandom = (int) (Math.random() * 20 + 1);
    }

    public void colorRuleta(){
        colorRandom = (int) (Math.random() * 2 + 1);
    }

    public void colorAcertado(double apuestaColor) {
        saldo += apuestaColor *2;
    }

    public void numeroAcertado(double apuestaNumero) {
        saldo += apuestaNumero *6;
    }
}
