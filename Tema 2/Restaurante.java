public class Restaurante {
    private int cantHuevos, platosHuevos, platos;
    private double cantChorizos, platosChorizos;

    public Restaurante(int huevos, double chorizos) {
        cantHuevos = huevos * 12;
        cantChorizos = chorizos;
    }

    public void addHuevos(int huevos) {
        cantHuevos += huevos * 12;
    }

    public void addChorizos(double chorizos) {
        cantChorizos += chorizos;
    }

    public int getNumPlatos(){
        if (cantHuevos/2 >= 1 && cantChorizos/0.2 >= 1) {
            platosHuevos = cantHuevos/2;
            platosChorizos = cantChorizos/0.2;

            if (platosHuevos > platosChorizos) {
                platos = (int)platosChorizos;
            }
            if (platosChorizos > platosHuevos) {
                platos = platosHuevos;
            }
        }

        return platos;
    }

    public void sirvePlato() {
        if (cantChorizos > 0.2 && cantHuevos > 2) {cantChorizos -= 0.2;
        cantHuevos -= 2;
        System.out.println("Plato servidor con éxito!!");
        } else {System.out.println("No es posible servir platos, no hay stock");}
    }

    public int getHuevos(){
        return cantHuevos;
    }

    public double getChorizos() {
        return cantChorizos;
    }
}
