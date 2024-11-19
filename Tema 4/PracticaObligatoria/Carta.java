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

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor, int tipo) {
        String valoresValidos;
        if (tipo == 1) {
            valoresValidos = "1234567SCR";
            if (valoresValidos.contains(valor)) {
                this.valor = valor;
            }
        }
        if (tipo == 2) {
            valoresValidos = "A23456789JQK";
            if (valoresValidos.contains(valor) || valor.equals("10")) {
                this.valor = valor;
            }
        }
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        // Baraja de póker
        if (palo.equals("CORAZONES") || palo.equals("DIAMANTES") || palo.equals("PICAS") || palo.equals("TREBOLES")) {
            this.palo = palo;
        }

        //Baraja española
        if (palo.equals("BASTOS") || palo.equals("OROS")||palo.equals("ESPADAS") ||palo.equals("COPAS")) {
            this.palo = palo;
        }
    }

}
