package FigurasGeometricas;

public class Triangulo {
    private double base, altura, lado1, lado2, lado3;

    public Triangulo(){
        this.base = 0.0;
        this.altura = 0.0;
        this.lado1 = 0.0;
        this.lado2 = 0.0;
        this.lado3 = 0.0;
    }

    public void setBase(double base){
        this.base = base;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public void setLados(double l1, double l2, double l3) {
        lado1 = l1;
        lado2 = l2;
        lado3 = l3;
    }

    public double getArea(){
        double area = base/2 * altura;
        return area;
    }

    public double getPerimetro(){
        double perimetro = lado1 + lado2+ lado3;
        return perimetro;
    }
}
