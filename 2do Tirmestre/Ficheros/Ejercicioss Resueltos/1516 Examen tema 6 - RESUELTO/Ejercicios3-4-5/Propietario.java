
import java.io.*;


public class Propietario {
    int codigo;
    String nombre;
    String apellidos;
    String dni;
    String domicilio;

    // *******************
    // Para el ejercicio 3
    // *******************
    
    public void save() {
        try {
            // Abrimos el flujo de escritura y nos colocamos al final
            raf = new RandomAccessFile("propietarios.dat", "rw");
            raf.seek(raf.length());
            
            // Escribimos los datos del objeto de uno en uno, forzando los strings para que tengan longitud fija
            // (rellenamos con espacios para simplificar)
            dos.writeInt(codigo);
            dos.writeUTF(String.format("%20s", nombre));
            dos.writeUTF(String.format("%40s", apellidos));
            dos.writeUTF(String.format("%10s", dni));
            dos.writeUTF(String.format("%50s", domicilio));
            dos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void load() {
        try {
            // Abrimos el flujo para lectura con acceso aleatorio.
            // Supondremos que ya tenemos un valor en la variable "codigo" para acceder al fichero
            raf = new RandomAccessFile("propietarios.dat", "r");

            // Suponemos que los códigos empiezan en 1, y que el tamaño del registro es 132 bytes
            // (calculado a ojo sobre las variables de la clase y el tamaño de los strings en el método save())
            raf.seek((codigo-1) * 132);
            
            // Cargamos los datos del registro
            codigo = raf.readInt();
            nombre = raf.readUTF();
            apellidos = raf.readUTF();
            dni = raf.readUTF();
            domicilio = raf.readUTF();
            raf.close();
        }
        catch (Exception e) {
            //e.printStackTrace();
            nombre = null; // Etc.
        }
    }
    
    // *************************
    // Para los ejercicios 4 y 5
    // *************************
    
    public int setCodigo(int c) {
        codigo = c;
    }
    
    public void show() {
        System.out.println("Datos del propietario: " + codigo);
        System.out.println("  - Nombre y apellidos" + nombre + " " + apellidos);
        System.out.println("  - DNI: " + dni);
        System.out.println("  - Domicilio: " + domicilio);
    }
}
