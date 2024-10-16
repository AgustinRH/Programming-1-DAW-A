
public class Pingu {
    int vencidos = 0;
    String pingu;
    int azar, num;
    
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
    
    public int getVencidos() {
        return vencidos;
    }

    public void addVencido() {
        vencidos++;
    }

    public int numeroAzar() {
        num = (int)(Math.random()* 100 + 1);
        return num;
    }
}
