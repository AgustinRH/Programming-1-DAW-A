import java.io.File;
import java.io.RandomAccessFile;

public class Dispositivo {

    // Variables de la clase
    protected int id, tipo, id_ajeno;
    protected String marca, modelo;
    protected boolean estado, borrado;
    private final int TAM_REG = 214;
    private final int MAX_STRING_LENGTH = 100;

    // Contructor que recibe marca, modelo y estado y guarda el dispositivo llamando al método save().
    public Dispositivo(String marca, String modelo, boolean estado) {
        this.id = generarId();
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.borrado = false;
         
        save();
    }

    // Constructor que recibe un id e inicializa todo vacío.
    public Dispositivo(int id) {
        this.id = id;
        this.marca = "";
        this.modelo = "";
        this.estado = true;
    }


    // Método para generar el ID
    public int generarId() {
        try {
            File f = new File("dispositivos.dat");
            int id = 0;
            if (f.exists()) {
                RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");

                raf.seek(raf.length() - TAM_REG);
                id = raf.readInt() + 1;

                raf.close();
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return -1;
        }
    }

    // Getter de Id
    public int getId() {
        return this.id;
    }


    // Setter de Marca
    public void setMarca(String m) {
        this.marca = m;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(String m) {
        this.modelo = m;
    }

    public String getModelo() {
        return this.modelo;
    }

    public boolean estado() {
        return this.estado;
    }

    public void setEstado(boolean est) {
        this.estado = est;
    }

    public void cambiarEstado(boolean e) {
        this.estado = e;
    }

    public boolean borrado() {
        return this.borrado;
    }

    public void setBorrado(boolean b) {
        this.borrado = b;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int t) {
        this.tipo = t;
    }

    public String toString() {
        String est;
        if (estado) {
            est = "funciona";
        } else {
            est = "no funciona";
        }
        return "ID: " + this.id + ". Marca: " + this.marca + ". Modelo: " + this.modelo + ". Estado: " + est + ".";
    }


    // Método para escribir un String dentro del registro
    protected void escribirString(RandomAccessFile raf, String str) throws Exception {
        long posIni = raf.getFilePointer(); // Guardamos la posición antes de escribir el String
        raf.writeUTF(str); // Escribimos el String
        long posFin = raf.getFilePointer(); // Volvemos a guardar la posición tras escribir el String
        long bytesEscritos = posFin - posIni; // Restamos la posición final menos la inicial para obtener el tamaño del String escrito

        for (int i = 0; i < MAX_STRING_LENGTH - bytesEscritos; i++) { // Bucle para escribir ceros desde el final del String hasta obtener un tamaño de 100
            raf.writeByte(0);
        }
    }

    public int save() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "rw");
            long tamanioFichero = raf.length(); //
            raf.seek(tamanioFichero);

            raf.writeInt(this.id);  // ID 4
            escribirString(raf, marca);  // MARCA 100
            escribirString(raf, modelo); // MODELO 100
            raf.writeBoolean(this.estado); // ESTADO 1
            raf.writeInt(this.tipo); // TIPO 4
            raf.writeBoolean(this.borrado);  // BORRADO 1
            raf.writeInt(this.id_ajeno);  // ID_AJENA 4
            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }

    protected String leerString(RandomAccessFile raf) throws Exception {
        long pos = raf.getFilePointer();
        String str = raf.readUTF();
        raf.seek(pos + MAX_STRING_LENGTH);
        return str;
    }

    public int load() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");
            raf.seek(this.id * TAM_REG);
            this.id = raf.readInt();
            this.marca = leerString(raf);
            this.modelo = leerString(raf);
            this.estado = raf.readBoolean();
            this.tipo = raf.readInt();
            this.borrado = raf.readBoolean();
            this.id_ajeno = raf.readInt();
            raf.close();
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void delete() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "rw");
            raf.seek(this.id * TAM_REG + 209);
            raf.writeBoolean(borrado);
            raf.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
