package PracticaObligatoria;

public class Carta {
    private int valor;
    private int palo;
    private int tipo;

    public Carta(int valor, int palo, int tipo){
        this.valor = valor;
        this.palo = palo;
        this.tipo = tipo;
    }
    public int getValor() {
        return valor;
    }

    public void setValor() {
        
    }

    public int getPalo() {
        return palo;
    }

    public int getTipo() {
        return tipo;
    }
}
