import java.io.File;
import java.io.RandomAccessFile;

public class Dispositivo {

    // Variables de la clase
    protected int id, tipo = 1;
    protected int id_ajeno = -1;
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
        this.tipo = 1;
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

    // Getter de Marca
    public String getMarca() {
        return this.marca;
    }

    // Setter de Modelo
    public void setModelo(String m) {
        this.modelo = m;
    }

    // Getter de Modelo
    public String getModelo() {
        return this.modelo;
    }

    // Getter de Estado
    public boolean estado() {
        return this.estado;
    }

    // Setter de Estado
    public void setEstado(boolean est) {
        this.estado = est;
    }

    // Método para cambiar el estado del dispositivo
    public void cambiarEstado(boolean e) {
        this.estado = e;
    }

    // Getter de Borrado
    public boolean borrado() {
        return this.borrado;
    }

    // Setter de Borrado
    public void setBorrado(boolean b) {
        this.borrado = b;
    }

    // Getter de Tipo
    public int getTipo() {
        return this.tipo;
    }

    // Setter de Tipo
    public void setTipo(int t) {
        this.tipo = t;
    }

    // Getter de Id Ajeno
    public int getIdAjeno() {
        return id_ajeno;
    }

    // Setter de Id Ajeno
    public void setIdAjeno(int id) {
        this.id_ajeno = id;
    }

    // Método toString para mostrar los datos del dispositivo
    @Override
    public String toString() {
        String est;
        if (estado) {
            est = "funciona";
        } else {
            est = "no funciona";
        }
        String tipoString = "Dispositivo";
        switch (tipo) {
            case 1:
                tipoString = "Dispositivo";
                break;
            case 2:
                tipoString = "Ordenador";
                break;
            case 3:
                tipoString = "Impresora";
                break;
            default:
                break;
        }
        return "ID: " + this.id + ". Marca: " + this.marca + ". Modelo: " + this.modelo + ". Estado: " + est + ". Tipo: " + tipoString;
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

    // Método para guardar el dispositivo en el fichero
    public int save() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "rw");
            long tamanioFichero = raf.length(); 
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

    // Método para leer un String del registro
    protected String leerString(RandomAccessFile raf) throws Exception {
        long pos = raf.getFilePointer();
        String str = raf.readUTF();
        raf.seek(pos + MAX_STRING_LENGTH);
        return str;
    }

    // Método para cargar los datos del dispositivo
    public int load() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");
            raf.seek(this.id * TAM_REG);
            System.out.println(raf.getFilePointer());
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

    // Método para borrar un dispositivo
    public void delete() {
        try {
            // Abrir el archivo en modo lectura y escritura
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "rw");
            // Buscar la posición del registro
            raf.seek(this.id * TAM_REG);
            raf.readInt();  // Salta el ID
            leerString(raf);  // Salta la marca
            leerString(raf);  // Salta el modelo
            raf.readBoolean();  // Salta el estado
            raf.readInt();  // Salta el tipo
            raf.readBoolean();  // Salta el valor borrado actual
            raf.readInt();  // Salta el id ajeno
            // Ahora sobreescribimos el valor borrado en la posición correspondiente
            raf.writeBoolean(true);  // Marcamos el dispositivo como borrado
            // Cerrar el archivo
            raf.close();
        } catch (Exception e) {
            System.out.println("Error al marcar el dispositivo como borrado: " + e.getMessage());
        }
    }
}
