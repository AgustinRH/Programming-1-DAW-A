package Geometria;

public class Main {
    public static void main (String[] args) {
        Figura f = new Figura();

        System.out.println(f.getColor());
        System.out.println(f.estaRelleno());
        System.out.println(f.toString());
        System.out.println("-----------------------");
        Figura f2 = new Figura("Azul", false);

        System.out.println(f2.getColor());
        System.out.println(f2.estaRelleno());
        System.out.println(f2.toString());
        System.out.println("-----------------------");

        Circulo c = new Circulo(2, "Verde", true);
        System.out.println(c.toString());
        System.out.println();
        System.out.println("----------------------- \n");

        Cuadrado cuadrado = new Cuadrado(5.0);
        
        System.out.println(cuadrado.toString());
        System.out.println("Área del cuadrado: " + cuadrado.getArea()); 
        System.out.println("Perímetro del cuadrado: " + cuadrado.getPerimetro());
        
        cuadrado.setLargo(7.0);
        System.out.println("Después de cambiar el largo:");
        System.out.println(cuadrado.toString());
        
        cuadrado.setAncho(10.0);
        System.out.println("Después de cambiar el ancho:");
        System.out.println(cuadrado.toString());
    }   
}
