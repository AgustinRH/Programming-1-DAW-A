package com.gestion.dispositivos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DispositivoController {

    @FXML
    private TextField marca, modelo;


    @FXML
    private void saveDispo() throws IOException {
        String marca = this.marca.getText();
        String modelo = this.modelo.getText();

        Dispositivo d = new Dispositivo(marca, modelo, true);

        d.save();

        mainController.dispositivo.add(d);
        

    }
    
}
