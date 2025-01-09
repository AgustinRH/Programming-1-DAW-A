package FigurasGeometricas;

public class Rectangulo {
    private double lado1, lado2, lado3, lado4;

    public Rectangulo(){
        this.lado1 = 0.0;
        this.lado2 = 0.0;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }

    public void setLados(double lado1, double lado2, double lado3, double lado4) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.lado4 = lado4;
    }

    public double getLado1(){
        return this.lado1;
    }

    public double getLado2(){
        return this.lado2;
    }

    public double getLado3(){
        return this.lado3;
    }
    public double getLado4(){
        return this.lado4;
    }

    public double getArea(){
        double area = lado1 * lado2;
        return area;
    }

    public double getPerimetro(){
        double perimetro = lado1 + lado2 + lado3 + lado4;
        return perimetro;
    }

}
