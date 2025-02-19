import java.io.File;
import java.io.RandomAccessFile;

public class Ordenador extends Dispositivo {
    private int ram, idOrdenador;
    private String procesador;
    private int tamDiscoDuroGB;
    private int tipoDisco;
    private final int tamLinea = 116;

    /**
     * Constructor que recibe marca, modelo, estado, tipo, ram, procesador, tamDiscoDuroGB y tipoDisco y guarda el ordenador llamando al método save().
     * 
     * @param marca La marca del ordenador
     * @param modelo El modelo del ordenador
     * @param estado El estado del ordenador (true si funciona, false si no funciona)
     * @param ram La cantidad de RAM del ordenador
     * @param procesador El procesador del ordenador
     * @param tamDiscoDuroGB El tamaño del disco duro en GB
     * @param tipoDisco El tipo de disco duro (1: HDD, 2: SSD, 3: NVMe, 4: Otro)
     */
    public Ordenador(String marca, String modelo, boolean estado, int ram, String procesador, int tamDiscoDuroGB,
            int tipoDisco) {
        super(marca, modelo, estado);
        idOrdenador = generarIdOrdenador();
        this.ram = ram;
        this.procesador = procesador;
        this.tamDiscoDuroGB = tamDiscoDuroGB;
        this.tipoDisco = tipoDisco;
        this.tipo = 2;
        super.setIdAjeno(idOrdenador);
    }

    /**
     * Constructor que recibe un id e inicializa todo vacío.
     * 
     * @param id El ID del ordenador
     */
    public Ordenador(int id) {
        super(id);
        this.ram = 0;
        this.procesador = "";
        this.tamDiscoDuroGB = 0;
        this.tipoDisco = 0;
    }

    /**
     * Método para generar el ID del ordenador.
     * 
     * @return El ID generado
     */
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

    /**
     * Getter de Ram.
     * 
     * @return La cantidad de RAM del ordenador
     */
    public int getRam() {
        return this.ram;
    }

    /**
     * Setter de Ram.
     * 
     * @param r La cantidad de RAM del ordenador
     */
    public void setRam(int r) {
        this.ram = r;
    }

    /**
     * Getter de Procesador.
     * 
     * @return El procesador del ordenador
     */
    public String getProcesador() {
        return this.procesador;
    }

    /**
     * Setter de Procesador.
     * 
     * @param p El procesador del ordenador
     */
    public void setProcesador(String p) {
        this.procesador = p;
    }

    /**
     * Getter de TamDiscoDuro.
     * 
     * @return El tamaño del disco duro en GB
     */
    public int getTamDiscoDuro() {
        return this.tamDiscoDuroGB;
    }

    /**
     * Setter de TamDiscoDuro.
     * 
     * @param tamDisco El tamaño del disco duro en GB
     */
    public void setTamDiscoDuro(int tamDisco) {
        this.tamDiscoDuroGB = tamDisco;
    }

    /**
     * Getter de TipoDisco.
     * 
     * @return El tipo de disco duro (1: HDD, 2: SSD, 3: NVMe, 4: Otro)
     */
    public int getTipoDisco() {
        return this.tipoDisco;
    }

    /**
     * Setter de TipoDisco.
     * 
     * @param tipoDisco El tipo de disco duro (1: HDD, 2: SSD, 3: NVMe, 4: Otro)
     */
    public void setTipoDisco(int tipoDisco) {
        if (tipoDisco >= 1 && tipoDisco <= 4) {
            this.tipoDisco = tipoDisco;
        } else {
            System.out.println("Tipo de disco inválido");
        }
    }

    /**
     * Método toString que devuelve un String con la información del ordenador.
     * 
     * @return Una cadena con los datos del ordenador
     */
    @Override
    public String toString() {
        String tipoDiscoString;
        switch (tipoDisco) {
            case 1:
                tipoDiscoString = "HDD";
                break;
            case 2:
                tipoDiscoString = "SSD";
                break;
            case 3:
                tipoDiscoString = "NVMe";
                break;
            case 4:
                tipoDiscoString = "Otro";
                break;
            default:
                tipoDiscoString = "Desconocido";
                break;
        }

        String estadoString = super.estado ? "funciona" : "no funciona";
        return "ID: " + idOrdenador +
                ". Marca: " + super.marca +
                ". Modelo: " + super.modelo +
                ". Estado: " + estadoString +
                ". Procesador: " + procesador +
                ". Memoria RAM: " + ram + " GB" +
                ". Almacenamiento: " + tipoDiscoString + " " + tamDiscoDuroGB + " GB" +
                ". Id_ajeno = " + super.id_ajeno;
    }

    /**
     * Método para guardar el ordenador en el fichero ordenadores.dat.
     * 
     * @return 0 si se guarda correctamente, 1 si ocurre un error
     */
    public int save() { // Cada línea ocupa 116 bytes

        try {
            super.save();
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "rw");
            raf.seek(raf.length());

            raf.writeInt(this.idOrdenador); // 4
            raf.writeInt(ram); // 4
            super.escribirString(raf, procesador); // 100
            raf.writeInt(tamDiscoDuroGB); // 4
            raf.writeInt(tipoDisco); // 4

            raf.close();
            return 0;
        } catch (Exception e) {
            e.getMessage();
            return 1;
        }
    }

    /**
     * Método para cargar el ordenador desde el fichero ordenadores.dat.
     * 
     * @return 0 si se carga correctamente, 1 si ocurre un error
     */
    public int load() {
        try {
            super.load();
            idOrdenador = super.id_ajeno;
            RandomAccessFile raf = new RandomAccessFile("ordenadores.dat", "r");
            raf.seek(this.idOrdenador * tamLinea);

            this.idOrdenador = raf.readInt();
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