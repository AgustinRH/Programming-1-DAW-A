import java.io.File;
import java.io.RandomAccessFile;

public class Impresora extends Dispositivo {
    private int tipoImpr, idImpresora;
    private boolean color;
    private boolean scanner;
    private final int tamLinea = 10;

    // Constructor que recibe marca, modelo, estado, tipo, tip, color y scanner y guarda la impresora llamando al método save().
    public Impresora(String marca, String modelo, boolean estado, int tipoImpr, boolean color, boolean scanner) {
        super(marca, modelo, estado);
        this.idImpresora = generarIdImpresora();
        this.tipo = 3;
        this.color = color;
        this.tipoImpr = tipoImpr;
        this.scanner = scanner;
        super.setIdAjeno(idImpresora);
    }

    // Constructor que recibe un id e inicializa todo vacío.
    public Impresora(int id) {
        super(id);
        this.tipo = -1;
        this.color = false;
        this.scanner = false;
    }

    // Método para generar el ID
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

    // Getter de Tipo
    public int getTipo() {
        return tipo;
    }

    // Setter de Tipo
    public void setTipo(int tipo) {
        if (tipo >= 0 && tipo <= 2) {
            this.tipo = tipo;
        } else {
            System.out.println("Tipo de impresora inválido.");
        }
    }

    // Getter de Color
    public boolean color() {
        return color;
    }

    // Setter de Color
    public void setColor(boolean color) {
        this.color = color;
    }

    // Getter de Scanner
    public boolean scanner() {
        return scanner;
    }

    // Setter de Scanner
    public void setScanner(boolean scanner) {
        this.scanner = scanner;
    }

    // Método toString que devuelve un String con la información de la impresora.
    @Override
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

        return "ID: " + idImpresora +
                ". Marca: " + super.marca +
                ". Modelo: " + super.modelo +
                ". Estado: " + estadoString +
                ". Tipo: " + tipoString +
                ". Soporte de Color: " + colorString +
                ". Escáner: " + scannerString + "." + 
                ". Id Ajeno: " + super.id_ajeno;
    }

    // Método para guardar la impresora en el fichero impresoras.dat
    public int save() {
        try {
            super.save();
            RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "rw");
            raf.seek(raf.length());
            raf.writeInt(this.idImpresora);
            raf.writeInt(this.tipoImpr);
            raf.writeBoolean(color);
            raf.writeBoolean(scanner);
            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }

    // Método para cargar la impresora desde el fichero impresoras.dat
    public int load() {
        try {
            super.load();
            idImpresora = super.id_ajeno;
            RandomAccessFile raf = new RandomAccessFile("impresoras.dat", "r");
            raf.seek(this.idImpresora * tamLinea);
            this.idImpresora = raf.readInt();
            this.tipoImpr = raf.readInt();
            this.color = raf.readBoolean();
            this.scanner = raf.readBoolean();
            raf.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error en la carga de datos: " + e.getMessage());
            e.printStackTrace();
            return 1;
        }
    }
}
