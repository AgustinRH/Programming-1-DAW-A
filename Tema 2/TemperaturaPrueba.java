import java.util.Scanner;


public class TemperaturaPrueba {
    
    public static void main (String[] args) {

        double cambio;

        Temperatura convTemp = new Temperatura();

        cambio = convTemp.celsiusToFarenheit(25);

        System.Out.Println(cambio);
    }
}
