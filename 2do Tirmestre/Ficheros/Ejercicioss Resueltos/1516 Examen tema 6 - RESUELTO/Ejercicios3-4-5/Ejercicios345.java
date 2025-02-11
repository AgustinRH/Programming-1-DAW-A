/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfebrero2016;

/**
 * Esta es la clase "Principal" del ejercicio 3.
 * (Le hemos cambiado el nombre para seguir con la terminología del resto del examen.)
 * @author alfredo
 */
public class Ejercicios345 {
    
    /**
     * EJERCICIO 4 del examen
     * @param propietarioBuscado 
     */
    public void mostrarVehiculos(int propietarioBuscado) {
        // Creamos un objeto propietario, le asignamos el código y le pedimos que cargue sus datos del fichero
        Propietario p = new Propietario();
        p.setCodigo(propietarioBuscado);
        p.load();
        p.show();   // Método nuevo (muestra por pantalla los datos de un propietario)
       
        // Averiguamos cuántos vehículos hay en el archivo de vehículos (método estático nuevo)
        int numVehiculos = Vehiculo.getTotalVehiculos();
        Vehiculo v = null;

        // Buscamos secuencialmente los vehículos de ese propietario. 
        for (int i = 0; i < numVehiculos; i++) {
            // Este método carga SOLO el propietario del vehículo i
            int propietario = Vehiculo.loadPropietario(i);
            if (propietario == propietarioBuscado) {
                // Este método carga SOLO el tipo del vehículo i
                int tipo = Vehiculo.loadTipo(i);
                
                // Instanciamos la clase adecuada
                switch (tipo) {
                    case 1: v = new Turismo(); break;
                    case 2: v = new Moto(); break;
                    case 3: v = new Camion(); break;
                }
                // Asignamos el código de vehículo y lo cargamos completo del fichero
                v.setCodigo(i);
                v.load();
                v.show(); // Método nuevo. Muestra por pantalla los datos de un vehículo
            }
            
        }
        
    }
    
    /**
     * EJERCICIO 5 del examen
     */
    public void marcarErroneos() {
        // Recorremos secuencialmente el archivo de vehículos, como en el método anterior
        // Averiguamos cuántos vehículos hay en el archivo de vehículos (método estático nuevo)
        int numVehiculos = Vehiculo.getTotalVehiculos();
        Vehiculo v = null;

        // Buscamos secuencialmente los vehículos de ese propietario. 
        for (int i = 0; i < numVehiculos; i++) {
            // Este método carga SOLO el propietario del vehículo i
            int propietario = Vehiculo.loadPropietario(i);
            
            // Tratamos de cargar ese propietario del archivo, a ver si existe
            Propietario p = new Propietario();
            p.setCodigo(propietario);
            p.load();
            
            // Si el registro no existía, el manejador de excepciones habrá puesto 
            // un valor especial en los campos del propietario (por ejemplo, un null en el nombre)
            if (p.getNombre() == null) {
                // Ese propietario no existe. Vamos a ponerlo a -1 en el archivo de vehículos.
                // Primero cargamos el vehículo.
                int tipo = Vehiculo.loadTipo(i);
                // Instanciamos la clase adecuada
                switch (tipo) {
                    case 1: v = new Turismo(); break;
                    case 2: v = new Moto(); break;
                    case 3: v = new Camion(); break;
                }
                // Asignamos el código de vehículo y lo cargamos completo del fichero
                v.setCodigo(i);
                v.load();
                // Ahora cambiamos el código del propietario
                v.setCodigoPropietario(-1);
                // Y volvemos a salvar el vehículo
                v.save();
            }
            
        }

    }
}
