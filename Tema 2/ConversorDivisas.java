public class ConversorDivisas {

    private char tipoMoneda;
    private int dinero;

    public ConversorDivisas(char tipo, int d) {
        tipoMoneda = tipo;
        dinero = d;
    }

    public int Convertir(int tipo) {
        int din = 0;
        if(tipo == 'E') {
            dinero /= 0.85;
            din = dinero;
        } 
        
        if(tipo == 'L') {
            dinero *= 0.85;
            din = dinero;
        }
        return din;
    }
}
