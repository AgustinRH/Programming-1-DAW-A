public class Temperatura {

    public double celsiusToFarenheit(double tempC) {
        return (1.8*tempC)+32;
    }

    public double farenheitToCelsius(double tempF) {
        return (tempF-32)/1.8;
    }

}