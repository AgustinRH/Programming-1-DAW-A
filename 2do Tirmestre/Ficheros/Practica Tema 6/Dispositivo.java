import java.io.RandomAccessFile;

public class Dispositivo {
    protected int id;
    protected String marca, modelo;
    protected boolean estado;
    private final int TAM_REG = 49;
    private final int MAX_STRING_LENGTH = 100;

    public Dispositivo(String marca, String modelo, boolean estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");

            raf.seek(raf.length() - TAM_REG);
            int ultimoId = raf.readInt();
            this.id = ultimoId;
            raf.close();

        } catch (Exception e) {
            this.id = 0;
            e.getMessage();
        }
    }

    public Dispositivo(int id) {
        this.id = id;
        this.marca = "";
        this.modelo = "";
        this.estado = true;
    }

    public int getId() {
        return this.id;
    }

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

    public String toString() {
        String est;
        if (estado) {
            est = "funciona";
        } else {
            est = "no funciona";
        }
        return "Marca: " + this.marca + ". Modelo: " + this.modelo + ". Estado: " + est + ".";
    }

    protected void escribirString(RandomAccessFile raf, String str) throws Exception{
        long posIni = raf.getFilePointer();
        raf.writeUTF(str);
        long posFin = raf.getFilePointer();
        long bytesEscritos = posFin - posIni;

        for (int i = 0; i < MAX_STRING_LENGTH - bytesEscritos; i++) {
            raf.writeByte(0);
        }
        raf.close();
    }

    public int save() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "rw");

            long tamArchivo = raf.length();
            raf.seek(tamArchivo);

            raf.writeInt(this.id);

            escribirString(raf, marca);
            escribirString(raf, modelo);

            raf.writeBoolean(this.estado);

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

    public int load(){
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat", "r");
            raf.seek(this.id*205);
            raf.readInt();
            this.marca = leerString(raf);
            this.modelo = leerString(raf);
            this.estado = raf.readBoolean();
            raf.close();
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void delete() {
        try {
            RandomAccessFile raf = new RandomAccessFile("dispositivos.dat","rw");
            raf.seek(this.id*205);
            raf.seek(204);
            raf.seek(4);
            escribirString(raf, "BORRADO");
            escribirString(raf, "BORRADO");
            raf.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
