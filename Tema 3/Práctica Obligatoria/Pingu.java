
public class Pingu {
    int vencidos = 0;
    String pingu;
    int azar, egg;
    boolean huevo = false;
    
    // Método para spawnear un pingüino al azar
    public String pinguAzar() {
        this.azar = (int)(Math.random()*5+1);
        if (this.azar == 1) {
            pingu = "Pingüino XS";
        }
        if (this.azar == 2) {
            pingu = "Pingüino S";
        }
        if (this.azar == 3) {
            pingu = "Pingüino M";
        }
        if (this.azar == 4) {
            pingu = "Pingüino L";
        }
        if (this.azar == 5) {
            pingu = "Pingüino XL";
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
        egg = (int)(Math.random()*50 + 1);
        if (egg == 13) {
            huevo = true;
        }
        return huevo;
    }
}
