public class MiNumero {

    private int numero, suma, resta;

    public  MiNumero(){
        numero = 0;
    }

    public MiNumero(int num){
        numero = num;
    }

    public void cambiaNumero(int num) {
        numero = num;
    }

    public int suma(int cantidad) {
        suma = numero + cantidad;
        return suma;
    }

    public int resta(int cantidad) {
        resta = numero - cantidad;
        return resta;
    }

    public int getValor(){
        return numero;
    }

    public int getDoble(){
        return numero*2;
    }

    public int getTriple(){
        return numero*3;
    }

    public int getCuadruple(){
        return numero*4;
    }
}

