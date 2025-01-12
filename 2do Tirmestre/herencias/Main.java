public class Main {
    public static void main (String[] args) {
        Animal a1 = new Animal("Bobby", 9);

        System.out.println("ANIMAL 1");
        System.out.println("- Nombre: " + a1.getNombre());
        System.out.println("- Edad: " + a1.getEdad());
        System.out.println("TOTAL DE ANIMALES: " + a1.getContadorDeAnimales());
        System.out.println("----------------------------");
        
        Animal a2 = a1.clone();
        System.out.println("ANIMAL 2");
        System.out.println("- Nombre: " + a2.getNombre());
        System.out.println("- Edad: " + a2.getEdad());

        if (a1.equals(a2)) {
            System.out.println("Los animales son iguales.");
        } else {System.out.println("Los animales son distintos.");}

        System.out.println("TOTAL DE ANIMALES: " + a1.getContadorDeAnimales());

        System.out.println("-----------------------------");

        Animal a3 = new Animal(a1);

        System.out.println("ANIMAL 3");
        System.out.println("- Nombre: " + a3.getNombre());
        System.out.println("- Edad: " + a3.getEdad());

        System.out.println("TOTAL DE ANIMALES: " + a1.getContadorDeAnimales());

        System.out.println("------------------------");
        Perro p1 = new Perro("Kelva", 15, "Chihuahua");
        System.out.println("ANIMAL 4");
        System.out.println("- Nombre: " + p1.getNombre());
        System.out.println("- Edad: " + p1.getEdad());
        System.out.println("- Raza: " + p1.getRaza());

        System.out.println("TOTAL DE ANIMALES: " + p1.getContadorDeAnimales());

        System.out.println("-------------------------------");

        Gato g1 = new Gato("Copo", 5);

        System.out.println("- Nombre: " + g1.getNombre());
        System.out.println("- Edad: " + g1.getEdad());
        System.out.println("- Vidas: " + g1.getVidas());

        System.out.println("El gato se ha caido...ha perdido una vida...");
        g1.restarVidas();
        System.out.println("VIDAS ACTUALES: " + g1.getVidas());

        System.out.println("TOTAL DE ANIMALES: " + p1.getContadorDeAnimales());

    }
}
