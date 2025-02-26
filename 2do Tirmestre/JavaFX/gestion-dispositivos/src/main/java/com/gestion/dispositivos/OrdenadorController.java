package com.gestion.dispositivos;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class OrdenadorController {
    
    @FXML
    TextField Marca, Modelo, Procesador, Ram, Disco; 

    @FXML
    CheckBox estado;

    @FXML
    private void saveOrd() throws IOException {
        

        System.out.println("Marca: " + Marca.getText());
        System.out.println("Modelo: " + Modelo.getText());
        System.out.println("Procesador: " + Procesador.getText());
        System.out.println("Ram: " + Ram.getText());
        System.out.println("Disco: " + Disco.getText());
        System.out.println("Estado: " + estado.isSelected());
    }

}
