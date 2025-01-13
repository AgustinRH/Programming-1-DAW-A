package Geometria;

public class Cuadrado extends Rectangulo {
    
    public Cuadrado(double lado) {
        super(lado, lado);
    }
    
    public String toString() {
        return "Soy un cuadrado con lado = " + getLargo() + ". " + super.toString();
    }
 
    public void setLargo(double largo) {
        super.setLargo(largo);
        super.setAncho(largo);
    }
 
    public void setAncho(double ancho) {
        super.setAncho(ancho);
        super.setLargo(ancho);
     }
}
