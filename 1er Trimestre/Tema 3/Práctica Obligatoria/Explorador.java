
public class Explorador {

    // Variables de control para el juego
    int salud = 50, lucha, ganado;
    String camino, no_camino = "N", tipo = "";

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
        this.salud -= 5; // Le restamos 5 puntos de vida si decide huir
    }

    // Método para pelear con un pingüino. Este método saca un pingüino al azar.
    // Dependiendo del tipo de pingüino es más facil de derrotar o no
    public int pelearPingu(String tipo) {
        lucha = (int) (Math.random() * 6 + 1); // Saca un número aleatorio entre 1 y 6
        this.tipo = tipo;

        // Si el pingüino es XS, si al sacar el número aleatorio sale el 2, 3, 4, 5 o 6,
        // gana al pingüino
        if (tipo.equals("Pingüino XS")) {
            if (lucha == 2 || lucha == 3 || lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }

        // Si el pingüino es S, si al sacar el número aleatorio sale el 3, 4, 5 o 6,
        // gana al pingüino
        if (tipo.equals("Pingüino S")) {
            if (lucha == 3 || lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }

        // Si el pingüino es M, si al sacar el número aleatorio sale el 4, 5 o 6, gana
        // al pingüino
        if (tipo.equals("Pingüino M")) {
            if (lucha == 4 || lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }

        // Si el pingüino es L, si al sacar el número aleatorio sale el 5 o 6, gana al
        // pingüino
        if (tipo.equals("Pingüino L")) {
            if (lucha == 5 || lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }
        // Si el pingüino es XL, si al sacar el número aleatorio sale el 6, gana al
        // pingüino
        if (tipo.equals("Pingüino XL")) {
            if (lucha == 6) {
                ganado = 1;
            } else {
                ganado = 0;
            }
        }

        // Devuelve 1 si ha ganado, o 0 si ha perdido
        return ganado;
    }

    // Método para elegir un camino
    public void elegirCamino(String camino) {
        this.camino = camino;

        // Si el camino escogido es el Norte, se le bloquea el paso hacia el Sur la
        // próxima vez
        if (camino.equals("N")) {
            no_camino = "S";
        }
        // Si el camino escogido es el Sur, se le bloquea el paso hacia el Norte la
        // próxima vez
        if (camino.equals("S")) {
            no_camino = "N";
        }
        // Si el camino escogido es el Este, se le bloquea el paso hacia el Oeste la
        // próxima vez
        if (camino.equals("E")) {
            no_camino = "O";
        }
        // Si el camino escogido es el Oeste, se le bloquea el paso hacia el Este la
        // próxima vez
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

        // Si ganas al pingüino XS se suma aleatoriamente entre 1 y 10 puntos a la vida
        if (tipo.equals("Pingüino XS")) {
            this.salud += (int) (Math.random() * 10 + 1);
        }
        // Si ganas al pingüino S se suma aleatoriamente entre 10 y 20 puntos a la vida
        if (tipo.equals("Pingüino S")) {
            this.salud += (int) (Math.random() * 11 + 10);
        }
        // Si ganas al pingüino M se suma aleatoriamente entre 20 y 30 puntos a la vida
        if (tipo.equals("Pingüino M")) {
            this.salud += (int) (Math.random() * 11 + 20);
        }
        // Si ganas al pingüino L se suma aleatoriamente entre 30 y 40 puntos a la vida
        if (tipo.equals("Pingüino L")) {
            this.salud += (int) (Math.random() * 11 + 30);
        }
        // Si ganas al pingüino XL se suma aleatoriamente entre 40 y 50 puntos a la vida
        if (tipo.equals("Pingüino XL")) {
            this.salud += (int) (Math.random() * 11 + 40);
        }
    }

    // Método para quitarle vida al jugador si es derrotado por un pingüino
    public void saludDerrota() {

        // Si no ganas al pingüino XS se suma aleatoriamente entre 1 y 10 puntos a la
        // vida
        if (tipo.equals("Pingüino XS")) {
            this.salud -= (int) (Math.random() * 10 + 1);
        }
        // Si no ganas al pingüino S se suma aleatoriamente entre 10 y 20 puntos a la
        // vida
        if (tipo.equals("Pingüino S")) {
            this.salud -= (int) (Math.random() * 11 + 10);
        }
        // Si no ganas al pingüino M se suma aleatoriamente entre 20 y 30 puntos a la
        // vida
        if (tipo.equals("Pingüino M")) {
            this.salud -= (int) (Math.random() * 11 + 20);
        }
        // Si no ganas al pingüino L se suma aleatoriamente entre 30 y 40 puntos a la
        // vida
        if (tipo.equals("Pingüino L")) {
            this.salud -= (int) (Math.random() * 11 + 30);
        }
        // Si no ganas al pingüino XL se suma aleatoriamente entre 40 y 50 puntos a la
        // vida
        if (tipo.equals("Pingüino XL")) {
            this.salud -= (int) (Math.random() * 11 + 40);
        }
    }
}

