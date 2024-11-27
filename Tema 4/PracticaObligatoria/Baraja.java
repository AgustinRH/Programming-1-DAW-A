package PracticaObligatoria;

public class Baraja {
    private int tipo;
    private String palo, valor;
    Carta mazo[][];

    public Baraja(int tipo) {
        this.tipo = tipo;
        if (tipo == 1) {
            Carta mazo[][] = new Carta[4][10];
            for (int i = 0; i < mazo.length; i++) {
                if (i == 0) {
                    palo = "BASTOS";
                }
                if (i == 1) {
                    palo = "COPAS";
                }
                if (i == 2) {
                    palo = "OROS";
                }
                if (i == 3) {
                    palo = "ESPADAS";
                }
                for (int j = 0; j < mazo[0].length; j++) {
                    switch (j) {
                        case 0:
                            valor = "1";
                            break;
                        case 1:
                            valor = "2";
                            break;
                        case 2:
                            valor = "3";
                            break;
                        case 3:
                            valor = "4";
                            break;
                        case 4:
                            valor = "5";
                            break;
                        case 5:
                            valor = "6";
                            break;
                        case 6:
                            valor = "7";
                            break;
                        case 7:
                            valor = "S"; // SOTA
                            break;
                        case 8:
                            valor = "C"; // CABALLO
                            break;
                        case 9:
                            valor = "R"; // REY
                            break;
                        default:
                            break;
                    }
                    mazo[i][j] = new Carta(valor, palo, tipo);
                }
            }
        }
        // POKER
        if (tipo == 2) {
            Carta mazo[][] = new Carta[4][13];
            for (int i = 0; i < mazo.length; i++) {
                if (i == 0) {
                    palo = "BASTOS";
                }
                if (i == 1) {
                    palo = "COPAS";
                }
                if (i == 2) {
                    palo = "OROS";
                }
                if (i == 3) {
                    palo = "ESPADAS";
                }
                for (int j = 0; j < mazo[0].length; j++) {
                    switch (j) {
                        case 0:
                            valor = "A";
                            break;
                        case 1:
                            valor = "2";
                            break;
                        case 2:
                            valor = "3";
                            break;
                        case 3:
                            valor = "4";
                            break;
                        case 4:
                            valor = "5";
                            break;
                        case 5:
                            valor = "6";
                            break;
                        case 6:
                            valor = "7";
                            break;
                        case 7:
                            valor = "8"; // SOTA
                            break;
                        case 8:
                            valor = "9"; // CABALLO
                            break;
                        case 9:
                            valor = "10"; // REY
                            break;
                        case 10:
                            valor = "J";
                            break;
                        case 11:
                            valor = "Q";
                            break;
                        case 12:
                            valor = "K";
                            break;

                        default:
                            break;
                    }
                    mazo[i][j] = new Carta(valor, palo, tipo);
                }
            }
        }
    }

    public void mostrarBaraja(){
        for (int i = 0; i < mazo.length; i++) {
            for (int j = 0; j < mazo[0].length; j++) {
                System.out.println(mazo[i][j]);
            }
        }
    }

    public void barajar() {
        int cambiar = (int)(Math.random()*mazo.length + 1);
        


    }
}
