package com.gestion.dispositivos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class menuDispositivosController {
    @FXML 
    Button switchToDispositivos;
    
    @FXML
    private void switchToDispositivos() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dispositivo.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Dispositivos");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    Button switchToImpresoras;

    @FXML
    private void switchToImpresoras() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("impresora.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Impresoras");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    Button switchToOrdenadores;

    @FXML
    private void switchToOrdenadores() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ordenador.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Ordenadores");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
