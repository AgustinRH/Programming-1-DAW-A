
public class Explorador {
    int salud = 50, lucha, ganado;
    String camino, no_camino = "N", tipo;  


    public void addVida(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public void huir(){
        this.salud -= 5;
    }

    Pingu pingu = new Pingu();

    public int pelearPingu(String tipo) {
        lucha = (int)(Math.random()*6+1);
        this.tipo = tipo;
        if (tipo.equals("Pingüino XS")) {
            if (lucha == 2 || lucha == 3 || lucha == 4 || lucha == 5 ||lucha == 6) {
                ganado = 1;
            }
            else{
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino S")) {
            if (lucha == 3 || lucha == 4 || lucha == 5 ||lucha == 6) {
                ganado = 1;
            }
            else{
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino M")) {
            if (lucha == 4 || lucha == 5 ||lucha == 6) {
                ganado = 1;
            }
            else{
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino L")) {
            if (lucha == 5 ||lucha == 6) {
                ganado = 1;
            }
            else{
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino XL")) {
            if (lucha == 6) {
                ganado = 1;
            }
            else{
                ganado = 0;
            }
        }
        return ganado;
    }

    public void elegirCamino(String camino) {
        this.camino = camino;
        no_camino = camino;
    }

    public String getNoCamino() {
        return no_camino;
    }

    public String getCamino() {
        return camino;
    }

    public void saludVictoria() {
        if (tipo.equals("Pingüino XS")) {
            this.salud += (int)(Math.random()*10 + 1);
        }
        if (tipo.equals("Pingüino S")) {
            this.salud += (int)(Math.random()*20 + 10);
        }
        if (tipo.equals("Pingüino M")) {
            this.salud += (int)(Math.random()*30 + 20);
        }
        if (tipo.equals("Pingüino L")) {
            this.salud += (int)(Math.random()*40 + 30);
        }
        if (tipo.equals("Pingüino XL")) {
            this.salud += (int)(Math.random()*50 + 40);
        }
    }

    public void saludDerrota() {
        if (tipo.equals("Pingüino XS")) {
            this.salud -= (int)(Math.random()*10 + 1);
        }
        if (tipo.equals("Pingüino S")) {
            this.salud -= (int)(Math.random()*20 + 10);
        }
        if (tipo.equals("Pingüino M")) {
            this.salud -= (int)(Math.random()*30 + 20);
        }
        if (tipo.equals("Pingüino L")) {
            this.salud -= (int)(Math.random()*40 + 30);
        }
        if (tipo.equals("Pingüino XL")) {
            this.salud -= (int)(Math.random()*50 + 40);
        }
    }

}
