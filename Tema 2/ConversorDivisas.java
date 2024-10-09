public class ConversorDivisas {
    public double librasAEuros(double libra) {
        double euros = libra * 0.85;
        return euros;
    }
    public double eurosALibras(double euro) {
        double libras = euro / 0.85;
        return libras;
    }
}
