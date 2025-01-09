package FigurasGeometricas;

public class Circulo {
    
    private double radio;
    
    public Circulo() {
        this.radio = 0.0;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio(){
        return radio;
    }

    public double getArea() {
        double area = radio * radio * Math.PI;
        return area;
    }
    public double getPerimetro() {
        double perimetro = radio * 2 * Math.PI;
        return perimetro;
    }
}
