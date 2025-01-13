package Geometria;

public class Figura {
    private String color;
    private boolean relleno;

    public Figura(){
        this.color = "Rojo";
        this.relleno = true;
    }

    public Figura(String color, boolean relleno){
        this.color = color;
        this.relleno = relleno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean estaRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public String toString(){
        if (relleno) {
            return "Soy una figura de color " + color + " y estoy rellena";
        } else {
            return "Soy una figura de color " + color + " y no estoy rellena";            
        }
    }

}
