import java.util.Scanner;

public class TemperaturaPrueba {
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cambio;

        Temperatura cambioTemp = new Temperatura();

        System.out.println("Que quieres convertir(1 = A Celsius, 2 = A Farenheit): ");
        cambio = sc.nextInt();

        switch (cambio) {
            case 1:
                System.out.println("Inserta la temperatura en Farenheit");
                double tempC = sc.nextDouble();
                System.out.println("La temperatura en Celsius es de " + cambioTemp.farenheitToCelsius(tempC) + " ºC");
                break;
            case 2:
                System.out.println("Inserta la temperatura en celsius");
                double tempF = sc.nextDouble();
                System.out.println("La temperatura en Farenheit es de " + cambioTemp.celsiusToFarenheit(tempF) + " ºF");
                break;
            default:
                break;
        }

        sc.close();
    }
}
