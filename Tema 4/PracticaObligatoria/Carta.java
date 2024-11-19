package PracticaObligatoria;

public class Carta {
    private int valor = -1;
    private String palo = "nulo";

    public Carta(int valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }
    public int getValor() {
        return valor;
    }

    
    public void setValor(int valor) {
        if (valor > 0 && valor < 13) {
            this.valor = valor;
        } 
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo (String palo) {
            this.palo = palo;
    }

}
