package PracticaObligatoria;

public class Carta {

    // Variables privadas de la clase.
    private String valor, palo;
    private int tipo;

    // Constructor de la clase para dar valor a las variables.
    public Carta(String valor, String palo, int tipo) {
        this.valor = valor;
        this.palo = palo;
        this.tipo = tipo;
    }

    // Getter de Tipo
    public int getTipo() {
        return tipo;
    }

    // Setter de Tipo
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    // Getter de Valor
    public String getValor() {
        return valor;
    }

    // Setter de Valor
    public void setValor(String valor, int tipo) {
        String valoresValidos;

        // Si el tipo es Baraja Española
        if (tipo == 1) {
            valoresValidos = "1234567SCR";
            if (valoresValidos.contains(valor)) {
                this.valor = valor;
            }
        }

        // Si el tipo es Baraja de Poker
        if (tipo == 2) {
            valoresValidos = "A23456789JQK";
            if (valoresValidos.contains(valor) || valor.equals("10")) {
                this.valor = valor;
            }
        }
    }

    // Getter de Palo
    public String getPalo() {
        return palo;
    }

    // Setter de Palo
    public void setPalo(String palo) {
        // Baraja de póker
        if (palo.equals("CORAZONES") || palo.equals("DIAMANTES") || palo.equals("PICAS") || palo.equals("TREBOLES")) {
            this.palo = palo;
        }

        // Baraja española
        if (palo.equals("BASTOS") || palo.equals("OROS") || palo.equals("ESPADAS") || palo.equals("COPAS")) {
            this.palo = palo;
        }
    }

    // Devuelve un String del valor y el palo de la carta.
    public String toString() {
        return "Valor" + valor + " | " + "Palo: " + palo;
    }

    //Método para comparar cartas
    public boolean equals(Carta c) {
        boolean iguales = false;
        if (c.getValor().equals(this.valor) || c.getPalo().equals(this.palo)) {
            iguales = true;
        }
        return iguales;
    }

    // Método para clonar cartas
    public Carta clone(){
        Carta c = new Carta(this.valor, this.palo, this.tipo);
        return c;
    }

    // Método para comparar palos de cartas
    public boolean compararPalos(Carta c){
        return this.palo.equals(c.palo);
    }

    // Método para saber si una carta es mayor que otra
    public boolean mayorQue(Carta c) {
        boolean mayor = false;
        if (this.valor.c.valor) {
            mayor = true;
        }
    }
}
