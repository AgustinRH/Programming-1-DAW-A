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
public class Turismo extends Vehiculo {
    
    int numPlazas;
    
    public void save() {
        try {
            // Abrimos el flujo de escritura y nos colocamos al final
            raf = new RandomAccessFile("vehiculos.dat", "rw");
            raf.seek(raf.length());
            // Pedimos a la superclase que escriba todos los datos comunes
            // (matricula, marca, modelo, etc)
            super.save();
            // Escribimos los datos específicos de esta subclase
            dos.writeInt(numPlazas);
            dos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void load() {
        try {
            // Abrimos el flujo para lectura con acceso aleatorio.
            // Supondremos que ya tenemos un valor en la variable "codigoVehiculo" para acceder al fichero
            raf = new RandomAccessFile("vehiculos.dat", "r");

            // Suponemos que los códigos empiezan en 1, y que el tamaño del registro es 60 bytes
            // (calculado a ojo sobre las variables de la clase y el tamaño de los strings en el método save())
            raf.seek((codigoVehiculo-1) * 64);
            
            // Llamamos a la superclase para que cargue los datos comunes
            // (matricula, marca, modelo, etc)
            super.load();
            // Y ahora cargamos los datos específicos de este subtipo
            numPlazas = raf.readInt();
            raf.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
