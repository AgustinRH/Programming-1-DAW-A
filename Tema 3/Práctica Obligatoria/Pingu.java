
public class Pingu {
    int vencidos = 0;
    String pingu;
    int azar, egg;
    boolean huevo = false;
    
    // Método para spawnear un pingüino al azar
    public String pinguAzar() {
        this.azar = (int)(Math.random()*5+1); // Saca un número entre 1 y 5
        if (this.azar == 1) {
            pingu = "Pingüino XS"; // Si el número es 1 el pingüino es XS
        }
        if (this.azar == 2) {
            pingu = "Pingüino S"; // Si el número es 2 el pingüino es S
        }
        if (this.azar == 3) {
            pingu = "Pingüino M"; //Si el número es 3 el pingüino es M
        }
        if (this.azar == 4) {
            pingu = "Pingüino L"; // Si el número es 4 el pingüino es L
        }
        if (this.azar == 5) {
            pingu = "Pingüino XL"; // Si el número es 5 el pingüino es XL
        }
        return pingu;
    } 
    
    // Metodo para saber los pingüinos que ha derrotado
    public int getVencidos() {
        return vencidos;
    }

    // Método que añade 1 pingüino a derrotados
    public void addVencido() {
        vencidos++;
    }
    
    // Método que da un huevo mágico si coincide un número al azar entre 1 y 50.
    public boolean soltarHuevoMagico() {
        egg = (int)(Math.random()*50 + 1); // Saca 1 número entre 1 y 50
        if (egg == 13) {
            huevo = true; // Si el número es 13, el pongüino derrotado soltará un huevo mágico
        }
        return huevo;
    }
}
