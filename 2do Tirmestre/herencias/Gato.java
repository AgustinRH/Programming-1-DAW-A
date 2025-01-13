public class Gato extends Animal{
    private int vidas;

    public Gato(String nombre, int edad) {
        super(nombre ,edad);
        this.vidas = 7;
    }

    public int getVidas(){ return this.vidas;}
    public void restarVidas(){ this.vidas = this.vidas - 1;}
    // Patata
}
