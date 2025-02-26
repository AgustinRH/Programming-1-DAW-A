package com.gestion.dispositivos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ImpresoraController {
    
    
    @FXML 
    private void save() throws IllegalAccessException, SecurityException, Exception {
        // Guardar los datos de la impresora en el archivo impresoras.dat
        Impresora impresora = new Impresora("HP", "LaserJet", 1, true, false);
        impresora.save();
        // Cerrar la ventana

        closeWindow();

    }

    // Método para cerrar la ventana
    private void closeWindow() throws Exception, IllegalAccessException, SecurityException {
        // Obtener el Stage actual (ventana)
        Stage stage = (Stage) this.getClass().getDeclaredFields()[0].get(null);
        
        // Cerrar el Stage (ventana)
        stage.close();
    }


}
