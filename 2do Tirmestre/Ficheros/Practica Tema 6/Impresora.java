import java.io.File;
import java.io.RandomAccessFile;

public class Impresora extends Dispositivo {
    private int tipo, idImpresora;
    private boolean color;
    private boolean scanner;
    private final int tamLinea = 211;

    public Impresora(String marca, String modelo, boolean estado, int tipo, boolean color, boolean scanner) {
        super(marca, modelo, estado);
        this.idImpresora = generarIdImpresora();
        this.tipo = tipo;
        this.color = color;
        this.scanner = scanner;
        id_ajeno = idImpresora;
    }

    public int generarIdImpresora() {
        try {
            File f = new File("impresoras.dat");
            int id = 0;
            if (f.exists()) {
                RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "r");

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


    public Impresora(int id) {
        super(id);
        this.tipo = -1;
        this.color = false;
        this.scanner = false;

    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean color() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean scanner() {
        return scanner;
    }

    public void setScanner(boolean scanner) {
        this.scanner = scanner;
    }

    public String toString() {
        String tipoString;
        switch (tipo) {
            case 0:
                tipoString = "Láser";
                break;
            case 1:
                tipoString = "Inyección de tinta";
                break;
            case 2:
                tipoString = "Otro";
                break;
            default:
                tipoString = "Desconocido";
                break;
        }
        String colorString = color ? "Si" : "No";
        String scannerString = scanner ? "Incluido" : "No incluido";
        String estadoString = super.estado ? "funciona" : "no funciona";

        return  "ID: " + idImpresora +
                ". Marca: " + super.marca +
                ". Modelo: " + super.modelo +
                ". Estado: " + estadoString +
                ". tipo: " + tipoString +
                ". Color: " + colorString +
                ". Scanner: " + scannerString + ".";
    }

    public int save() {
        super.save(); // Guardamos los datos del dispositivo
        try {
            RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "rw");
            raf.seek(raf.length());

            raf.writeInt(this.idImpresora);
            raf.writeInt(this.tipo);
            raf.writeBoolean(color);
            raf.writeBoolean(scanner);

            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }

    public int load() {
        super.load(); 
        try {
            RandomAccessFile raf = new RandomAccessFile("imprepsoras.dat", "r");

            this.tipo = raf.readInt();
            this.color = raf.readBoolean();
            this.scanner = raf.readBoolean();
            
            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }
}
