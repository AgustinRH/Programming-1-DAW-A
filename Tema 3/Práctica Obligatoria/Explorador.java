
public class Explorador {
    int salud = 50;
    String camino, no_camino = "N";  

    public void addVida(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
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

}
