import java.io.*;

public class Ejercicio2 {
    int[] tablero = new int[16];
    String nombreJugador1;
    String nombreJugador2;
    int turno;
    
    // Vamos a crear un pequeño programa de prueba en main() 
    // (NO ERA NECESARIO HACERLO EN EL EXAMEN)
    public static void main(String[] args) {
        
        Ejercicio2 ej2 = new Ejercicio2();

        // Inicializamos el tablero en blanco (todo a 0)
        for (int i = 0; i < 16; i++) ej2.tablero[i] = 0;
        // Ponemos algunas fichas en el tablero (para probar)
        ej2.tablero[3] = 1; ej2.tablero[5] = 1; ej2.tablero[12] = 1; ej2.tablero[13] = 1;
        ej2.tablero[2] = 2; ej2.tablero[7] = 2; ej2.tablero[11] = 2;
        
        // Nos inventamos unos nombres para los jugadores y un turno
        ej2.nombreJugador1 = "Juan";
        ej2.nombreJugador2 = "Ana";
        ej2.turno = 2;

        // Probamos los 4 métodos que se pedía en el ejercicio
        ej2.save();   // Volcamos el array al fichero
        ej2.show();   // Mostramos el tablero que hay en el fichero
        for (int i = 0; i < 16; i++) ej2.tablero[i] = 0;    // Borramos el contenido del array
        ej2.load();   // Cargamos el array
        ej2.show();   // Mostramos el tablero de nuevo. Debería estar igual que antes.
        ej2.reset();  // Reseteamos el tablero del fichero
        ej2.show();   // Lo mostramos de nuevo. Ahora debería estar en blanco.
    }
    
    public void save() {
        // Vamos a usar un RandomAccessFile para escribir el estado del juego
        try {
            RandomAccessFile raf = new RandomAccessFile("tablero.dat", "rw");
            
            // Escribimos el tablero (casilla a casilla)
            for (int i = 0; i < 16; i++) {
                raf.writeInt(tablero[i]);
            }
            
            // Ahora escribimos los nombres de los jugadores
            raf.writeUTF(nombreJugador1);
            raf.writeUTF(nombreJugador2);
            
            // Por último, escribimos el turno
            raf.writeInt(turno);
            
            // Cerramos el archivo
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


    public void load() {
        RandomAccessFile raf = null;
        // Vamos a usar un RandomAccessFile para recuperar el estado del tablero
        try {
            raf = new RandomAccessFile("tablero.dat", "r");
            
            // Primero leemos el contenido del tablero (casilla a casilla)
            for (int i = 0; i < 16; i++) {
                tablero[i] = raf.readInt();
            }
            
            // Ahora leemos los nombres de los jugadores
            nombreJugador1 = raf.readUTF();
            nombreJugador2 = raf.readUTF();
            
            // Por último, leemos el turno
            turno = raf.readInt();
            raf.close();
        }
        catch (Exception e) {
            System.out.println("Error de lectura de fichero");
        }
    }
    

    public void reset() {
        // Podemos resetar las variables de la clase y luego llamar a save() para 
        // resetear también la partida guardada. O podemos hacerlo directamente
        // en el fichero con un RandomAccessFile. Vamos a intentar esto último.
        try {
            RandomAccessFile raf = new RandomAccessFile("tablero.dat", "rw");
            
            // Escribimos un tablero en blanco (16 enteros a 0)
            for (int i = 0; i < 16; i++) {
                raf.writeInt(0);
            }
            
            // Ahora escribimos los nombres de los jugadores en blanco
            raf.writeUTF("");
            raf.writeUTF("");
            
            // Por último, escribimos el turno con valor 1 (ese es el valor inicial en cualquier partida)
            raf.writeInt(1);
            
            // Cerramos el archivo
            raf.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void show() {
        // Podríamos hacer una llamada a load() y luego mostrar las
        // variables de la clase. Pero también se puede leer el contenido del fichero
        // y mostrarlo directamente. Eso es lo que vamos a hacer.
        try {
            RandomAccessFile raf = new RandomAccessFile("tablero.dat", "r");
            
            // Primero leemos el contenido del tablero y lo mostramos
            System.out.println("\n+---+---+---+---+");
            for (int i = 0; i < 16; i++) {
                int casilla = raf.readInt();
                char ficha = ' ';
                if (casilla == 1) ficha = 'X';
                if (casilla == 2) ficha = 'O';
                System.out.printf("| %c ", ficha);
                if ((i+1) % 4 == 0) System.out.println("|\n+---+---+---+---+");
            }
            
            // Ahora leemos los nombres de los jugadores
            String jug1 = raf.readUTF();
            String jug2 = raf.readUTF();
            System.out.print("X = " + jug1);
            System.out.print(", O = " + jug2);
            
            // Por último, leemos el turno
            if (raf.readInt() == 1) System.out.println(", Turno de " + jug1);
            else System.out.println(", Turno de " + jug2);
            
            raf.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
