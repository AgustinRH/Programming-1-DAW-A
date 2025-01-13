package Geometria;

public class Circulo extends Figura {
    private double radio;

    public Circulo() {
        this.radio = 1;
    }

    public Circulo(double r) {
        this.radio = r;
    }

    public Circulo(double r, String color, boolean relleno) {
        super(color, relleno);
        this.radio = r;
    }

    public double getRadio() {
        return this.radio;
    }

    public void setRadio(double r) {
        this.radio = r;
    }

    public double getArea() {
        return (Math.PI *Math.pow(this.radio, 2));
    }

    public double getPerimetro() {
        return (2 * Math.PI * this.radio);
    }

    public String toString(){
        return "Soy un círculo con radio = " + radio + ". \n" + super.toString();
    }
}
