package PracticaObligatoria;

public class Baraja {
    private int tipo;
    private Carta c = new Carta(null, null, tipo);

    public Baraja(int tipo) {
        this.tipo = tipo;
    }

    public void crearBaraja() {
        switch (tipo) {
            case 1:

                break;
            case 2:

                break;

            default:
                break;
        }
    }
}
