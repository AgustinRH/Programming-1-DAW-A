/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfebrero2016;

import java.io.*;

/**
 *
 * @author alfredo
 */
public class Vehiculo {
    
    int codigoPropietario;
    int codigoVehiculo;
    String matricula;
    String marca;
    String modelo;

    // Para poder utilizar la herencia y no duplicar montones de código, 
    // vamos a declarar un par de flujos aquí.
    protected RandomAccessFile raf;
    
    //**************************************
    // Estos son los métodos del ejercicio 3
    // *************************************

    /**
     * Este método salva en el fichero los datos comunes a todos los vehículos.
     * Necesita que el flujo ya esté abierto y apuntando al final del fichero.
     */
    public void save() {
        try {
            // Escribimos los datos del objeto de uno en uno, forzando los strings para que tengan longitud fija
            // (rellenaremos con espacios para simplificar)
            raf.writeInt(codigoPropietario);
            raf.writeInt(codigoVehiculo);
            raf.writeUTF(String.format("%8s", matricula));
            raf.writeUTF(String.format("%20s", marca));
            raf.writeUTF(String.format("%20s", modelo));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /** 
     * Este método carga del fichero los datos comunes a todos los vehículos
     * Necesita que el flujo ya esté abierto y apuntando al registro correcto.
     */
    public void load() {
        try {
            // Cargamos los datos del registro
            codigoPropietario = raf.readInt();
            codigoVehiculo = raf.readInt();
            matricula = raf.readUTF();
            marca = raf.readUTF();
            modelo = raf.readUTF();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //********************************************************
    // Los siguientes métodos se usan en los ejercicios 4 y 5
    // *******************************************************
    
    public static int getTotalVehiculos() {
        int numRegs = 0;
        
        try {
            RandomAccessFile raf = new RandomAccessFile("vehiculos.dat", "r");
            numRegs = (int) (raf.length() / 64);
            raf.close();
        }
        catch (Exception e) {}
        
        return numRegs;
    }
    
    /**
     * Devuelve el código de propietario asociado a un vehículo
     * @param codVehiculo
     * @return 
     */
    public static int loadPropietario(int codVehiculo) {
        int codProp = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile("vehiculos.dat", "r");
            raf.seek((codVehiculo-1) * 64); // Suponemos que el código de propietario es el primer dato de cada registro
            codProp = raf.readInt();
        }
        catch (Exception e) {}
        
        return codProp;
    }

    /**
     * Devuelve el tipo asociado a un vehículo
     * @param codVehiculo
     * @return 
     */
    public static int loadTipo(int codVehiculo) {
        int codTipo = 0;
        try {
            RandomAccessFile raf = new RandomAccessFile("vehiculos.dat", "r");
            raf.seek((codVehiculo-1) * 64 + 8); // Suponemos que el tipo es el tercer dato en cada registro (por eso saltamos 8 bytes)
            codTipo = raf.readInt();
        }
        catch (Exception e) {}
        
        return codTipo;
    }
    
    public void setCodigo(int cod) {
        codigoVehiculo = cod;
    }
    
    public void setCodigoProp(int cod) {
        codigoVehiculo = cod;
    }
    
}
