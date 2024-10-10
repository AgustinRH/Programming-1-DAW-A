public class Peso {
    private double libras = 0, onzas = 0, kilogramos = 0;


    public Peso(double peso, String unidad) {
        if (unidad.equals("Lb")) {
            libras = peso;
            onzas = peso * 16;
            kilogramos = peso * 0.453592;
        }

        if (unidad.equals("Oz")) {
            onzas = peso;
            libras = peso * 0.0625;
            kilogramos = peso * 0.0283495;
        }

        if (unidad.equals("Kg")) {
            kilogramos = peso;
            onzas = peso * 35.274;
            libras = peso * 2.20462;
        }
    }

    public double getLibras() {
        return libras;
    }

    public double getOnzas() {
        return onzas;
    }

    public double getPeso() {
        return kilogramos;
    }
    
}
