
public class Explorador {
    int salud = 50, lucha, ganado;
    String camino, no_camino = "N", tipo;


    // Método para sumarle vida al jugador
    public void addVida(int salud) {
        this.salud = salud;
    }

    // Método para obtener la salud del jugador
    public int getSalud() {
        return salud;
    }

    // Método para huir del pingüino
    public void huir() {
        this.salud -= 5;
    }

    // Método para pelear con un pingüino. Este método saca un pingüino al azar. Dependiendo del tipo de pingüino es más facil de derrotar o no
    public int pelearPingu(String tipo) {
        lucha = (int) (Math.random() * 6 + 1);
        this.tipo = tipo;
        if (tipo.equals("Pingüino XS")) {
            if (lucha == 2 || lucha == 3 || lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino S")) {
            if (lucha == 3 || lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino M")) {
            if (lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino L")) {
            if (lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        if (tipo.equals("Pingüino XL")) {
            if (lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        return ganado;
    }

    // Método para elegir un camino
    public void elegirCamino(String camino) {
        this.camino = camino;

        if (camino.equals("N")) {
            no_camino = "S";
        }
        if (camino.equals("S")) {
            no_camino = "N";
        }
        if (camino.equals("E")) {
            no_camino = "O";
        }
        if (camino.equals("O")) {
            no_camino = "E";
        }
    }

    // Método que te devuelve el camino que no puedes tomar
    public String getNoCamino() {
        return no_camino;
    }

    // Método que te devuelve el camino que has escogido
    public String getCamino() {
        return camino;
    }

    // Método para agregar salud al jugador si derrota al pingüino
    public void saludVictoria() {
        if (tipo.equals("Pingüino XS")) {
            this.salud += (int) (Math.random() * 10 + 1);
        }
        if (tipo.equals("Pingüino S")) {
            this.salud += (int) (Math.random() * 20 + 10);
        }
        if (tipo.equals("Pingüino M")) {
            this.salud += (int) (Math.random() * 30 + 20);
        }
        if (tipo.equals("Pingüino L")) {
            this.salud += (int) (Math.random() * 40 + 30);
        }
        if (tipo.equals("Pingüino XL")) {
            this.salud += (int) (Math.random() * 50 + 40);
        }
    }

    // Método para quitarle vida al jugador si es derrotado por un pingüino
    public void saludDerrota() {
        if (tipo.equals("Pingüino XS")) {
            this.salud -= (int) (Math.random() * 10 + 1);
        }
        if (tipo.equals("Pingüino S")) {
            this.salud -= (int) (Math.random() * 20 + 10);
        }
        if (tipo.equals("Pingüino M")) {
            this.salud -= (int) (Math.random() * 30 + 20);
        }
        if (tipo.equals("Pingüino L")) {
            this.salud -= (int) (Math.random() * 40 + 30);
        }
        if (tipo.equals("Pingüino XL")) {
            this.salud -= (int) (Math.random() * 50 + 40);
        }
    }

}
