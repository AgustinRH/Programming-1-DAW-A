import java.io.File;
import java.io.RandomAccessFile;

public class Ordenador extends Dispositivo {
    private int ram;
    private String procesador;
    private int tamDiscoDuroGB;
    private int tipoDisco;
    private final int tamLinea = 317;

    public Ordenador(String marca, String modelo, boolean estado, int ram, String procesador, int tamDiscoDuroGB,
            int tipoDisco) {
        super(marca, modelo, estado);
        this.id = generarIdOrdenador();
        this.ram = ram;
        this.procesador = procesador;
        this.tamDiscoDuroGB = tamDiscoDuroGB;
        this.tipoDisco = tipoDisco;
        super.setIdAjeno(this.id);
    }

    public Ordenador(int id) {
        super(id);
        this.ram = 0;
        this.procesador = "";
        this.tamDiscoDuroGB = 0;
        this.tipoDisco = 0;
    }

    public int generarIdOrdenador() {
        try {
            File f = new File("ordenadores.dat");
            int id = 0;
            if (f.exists()) {
                RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "r");

                raf.seek(raf.length() - tamLinea);
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

    public int getRam() {
        return this.ram;
    }

    public void setRam(int r) {
        this.ram = r;
    }

    public String getProcesador() {
        return this.procesador;
    }

    public void setProcesador(String p) {
        this.procesador = p;
    }

    public int getTamDiscoDuro() {
        return this.tamDiscoDuroGB;
    }

    public void setTamDiscoDuro(int tamDisco) {
        this.tamDiscoDuroGB = tamDisco;
    }

    public int getTipoDisco() {
        return this.tipoDisco;
    }

    public void setTipoDisco(int tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    @Override
    public String toString() {
        String tipoDiscoString;
        switch (tipoDisco) {
            case 0:
                tipoDiscoString = "Mecanico";
                break;
            case 1:
                tipoDiscoString = "SSD";
                break;
            case 2:
                tipoDiscoString = "NVMe";
                break;
            case 3:
                tipoDiscoString = "Otro";
                break;
            default:
                tipoDiscoString = "Desconocido";
                break;
        }

        String estadoString = super.estado ? "funciona" : "no funciona";
        return "Marca: " + super.marca +
                ". Modelo: " + super.modelo +
                ". Estado: " + estadoString +
                ". Procesador: " + procesador +
                ". Memoria RAM: " + ram + " GB" +
                ". Almacenamiento: " + tipoDiscoString + " " + tamDiscoDuroGB + " GB.";
    }

    public int save() { // Cada línea ocupa 317 bytes
        try {
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "rw");
            long tamArchivo = raf.length();
            raf.seek(tamArchivo);

            raf.writeInt(super.getId());
            super.escribirString(raf, super.getMarca());
            super.escribirString(raf, super.getModelo());
            raf.writeBoolean(super.estado());
            raf.writeInt(ram);
            super.escribirString(raf, procesador);
            raf.writeInt(tamDiscoDuroGB);
            raf.writeInt(tipoDisco);

            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }

    public int load() {
        try {
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "r");
            raf.seek(super.getId() * tamLinea);

            super.id = raf.readInt();
            super.setMarca(super.leerString(raf));
            super.setModelo(super.leerString(raf));
            super.setEstado(raf.readBoolean());
            this.ram = raf.readInt();
            this.procesador = super.leerString(raf);
            this.tamDiscoDuroGB = raf.readInt();
            this.tipoDisco = raf.readInt();

            raf.close();
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}