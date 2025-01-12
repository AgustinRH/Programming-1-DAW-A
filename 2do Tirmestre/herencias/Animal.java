public class Animal{
    private String nombre;
    private int edad;
    private static int contadorDeAnimales = 0;

    public Animal(){
        this.nombre = "Desconocido";
        this.edad = 0;
        contadorDeAnimales ++;
    }

    public Animal (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        contadorDeAnimales ++;
    }

    public Animal (Animal a) {
        this.nombre = a.getNombre();
        this.edad = a.getEdad();
        contadorDeAnimales ++;
    }

    public String getNombre(){ return nombre;}
    public void setNombre(String nombre){ this.nombre = nombre;}

    public int getEdad(){ return edad;}
    public void setEdad(int edad){ this.edad = edad;}

    public int getContadorDeAnimales(){ return contadorDeAnimales;}

    public Animal clone(){
        return new Animal(this.nombre, this.edad);
    }

    public boolean equals(Animal a){
        return ((a.getNombre() == this.nombre) && (a.getEdad() == this.edad));
    }
}