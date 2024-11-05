package FigurasGeometricas;

import java.util.Scanner;
public class FigurasGeometricas {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0, f = 0;
        double radioCirculo, baseTriangulo,alturaTriangulo, lado1T, lado2T, lado3T;
        double lado1R, lado2R, lado3R, lado4R;
        boolean fin = false;
        do {
            System.out.println("¿Qué figura geométrica deseas calcular? \n 1. Círculo.\n 2. Triángulo.\n 3. Rectángulo. \n 4. Cuadrado");
            try {
                opc = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error al introducir el valor correcto");
            }
    
            Circulo circulo = new Circulo();
            Triangulo triangulo = new Triangulo();
            Rectangulo rectangulo = new Rectangulo();
            switch (opc) {
                case 1: // CIRCULO
                    System.out.println("Inserte el radio del círculo: ");
                    radioCirculo = sc.nextDouble();
                    circulo.setRadio(radioCirculo);
                    System.out.println("El área del círculo es " + circulo.getArea());
                    System.out.println("El perímetro del círculo es" + circulo.getPerimetro());
                    break;
                case 2: // TRIANGULO
                    System.out.println("Inserte la base del triangulo: ");
                    baseTriangulo = sc.nextDouble();
                    triangulo.setBase(baseTriangulo);
    
                    System.out.println("Inserte la altura del triángulo: ");
                    alturaTriangulo = sc.nextDouble();
                    triangulo.setAltura(alturaTriangulo);
                    
                    System.out.println("Inserte el lado1: ");
                    lado1T = sc.nextDouble();
                    System.out.println("Inserte el lado2: ");
                    lado2T = sc.nextDouble();
                    System.out.println("Inserte el lado3: ");
                    lado3T = sc.nextDouble();
    
                    triangulo.setLados(lado1T, lado2T, lado3T);
    
                    System.out.println("El área del triángulo es " + triangulo.getArea());
                    System.out.println("El perímetro del círculo es " + triangulo.getPerimetro());
                    break;
                case 3: // Cuadrado
                    System.out.println("Inserte los lados del cuadrado: ");
                    lado1R = sc.nextDouble();
                    lado2R = sc.nextDouble();
                    lado3R = lado1R;
                    lado4R = lado2R;

                    rectangulo.setLados(lado1R, lado2R, lado3R, lado4R);
                    System.out.println("El área del cuadrado es " + rectangulo.getArea());
                    System.out.println("El perímetro del cuadrado es " + rectangulo.getPerimetro());
                    break;
                case 4: //Rectángulo
                    System.out.println("Inserte los lados del rectángulo: ");
                    lado1R = sc.nextDouble();
                    lado2R = sc.nextDouble();
                    lado3R = sc.nextDouble();
                    lado4R = sc.nextDouble();
    
                    rectangulo.setLados(lado1R, lado2R, lado3R, lado4R);
                    System.out.println("El área del rectágulo es " + rectangulo.getArea());
                    System.out.println("El perímetro del rectángulo es " + rectangulo.getPerimetro());
                    break;
                default:
                    System.out.println("Opción no disponible.");
                    break;
            }
            System.out.println("¿Desea finalizar?");
            try {
                f = sc.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
            }
    
            if (f == 1) {
                fin = true;
            }
            
        } while (!fin);
        sc.close();
    }
}
