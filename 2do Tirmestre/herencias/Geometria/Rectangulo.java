package Geometria;

public class Rectangulo extends Figura {
    private double largo;
    private double ancho;

    public Rectangulo() {
        this.largo = 1.0;
        this.ancho = 1.0;
    }

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public Rectangulo(String color, boolean relleno, double largo, double ancho) {
        super(color, relleno);
        this.largo = largo;
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getArea() {
        return largo * ancho;
    }

    public double getPerimetro() {
        return 2 * (largo + ancho);
    }

    public String toString() {
        return "Soy un rectángulo con largo = " + largo + " y ancho = " + ancho + ". \n" + super.toString();
    }
}

