package com.gestion.dispositivos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainController {

    public static List<Dispositivo> dispositivo = new ArrayList<Dispositivo>();

    @FXML
    private TableView<Dispositivo> dispositivos;

    @FXML
    private TableView<Ordenador> ordenadores;

    @FXML
    private TableView<Impresora> impresoras;

    // ATRIBUTOS DISPOSITIVOS
    @FXML
    private TableColumn<Dispositivo, Integer> idDisp;
    @FXML
    private TableColumn<Dispositivo, String> marcaDisp;
    @FXML
    private TableColumn<Dispositivo, String> modeloDisp;
    @FXML
    private TableColumn<Dispositivo, Boolean> estadoDisp;

    // ATRIBUTOS ORDENADORES
    @FXML
    private TableColumn<Ordenador, Integer> idOrd;
    @FXML
    private TableColumn<Ordenador, String> marcaOrd;
    @FXML
    private TableColumn<Ordenador, String> modeloOrd;
    @FXML
    private TableColumn<Ordenador, Boolean> estadoOrd;
    @FXML
    private TableColumn<Ordenador, String> procesador;
    @FXML
    private TableColumn<Ordenador, Integer> ram;
    @FXML
    private TableColumn<Ordenador, Integer> disco;

    // ATRIBUTOS IMPRESORAS
    @FXML
    private TableColumn<Impresora, Integer> idImp;
    @FXML
    private TableColumn<Impresora, String> marcaImp;
    @FXML
    private TableColumn<Impresora, String> modeloImp;
    @FXML
    private TableColumn<Impresora, Boolean> estadoImp;
    @FXML
    private TableColumn<Impresora, Integer> tipoImp;
    @FXML
    private TableColumn<Impresora, Boolean> color;
    @FXML
    private TableColumn<Impresora, Boolean> escaner;

    @FXML
    private void menuDispositivos() throws IOException {
        App.setRoot("");
    }

    @FXML
    private void mostrar() {
        // Inicializamos las columnas de la tabla de dispositivos
        idDisp.setCellValueFactory(new PropertyValueFactory<>("id"));
        marcaDisp.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloDisp.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estadoDisp.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Inicializamos las columnas de la tabla de ordenadores
        idOrd.setCellValueFactory(new PropertyValueFactory<>("id"));
        marcaOrd.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloOrd.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estadoOrd.setCellValueFactory(new PropertyValueFactory<>("estado"));
        procesador.setCellValueFactory(new PropertyValueFactory<>("procesador"));
        ram.setCellValueFactory(new PropertyValueFactory<>("ram"));
        disco.setCellValueFactory(new PropertyValueFactory<>("disco"));

        // Inicializamos las columnas de la tabla de impresoras
        idImp.setCellValueFactory(new PropertyValueFactory<>("id"));
        marcaImp.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloImp.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        estadoImp.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tipoImp.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        escaner.setCellValueFactory(new PropertyValueFactory<>("escaner"));

        // Cargamos los datos de los dispositivos
        ObservableList<Dispositivo> listaDispositivos = FXCollections.observableArrayList();
        ObservableList<Ordenador> listaOrdenadores = FXCollections.observableArrayList();
        ObservableList<Impresora> listaImpresoras = FXCollections.observableArrayList();

        for (Dispositivo disp : dispositivo) {
            if (disp instanceof Ordenador) {
                listaOrdenadores.add((Ordenador) disp);
            } else if (disp instanceof Impresora) {
                listaImpresoras.add((Impresora) disp);
            } else {
                listaDispositivos.add(disp);
            }
        }

        dispositivos.setItems(listaDispositivos);
        ordenadores.setItems(listaOrdenadores);
        impresoras.setItems(listaImpresoras);

        idDisp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        marcaDisp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getMarca()));
        modeloDisp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getModelo()));
        estadoDisp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEstado()));

        idOrd.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        marcaOrd.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getMarca()));
        modeloOrd.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getModelo()));
        estadoOrd.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEstado()));
        procesador.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getProcesador()));
        ram.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRam()));
        disco.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDisco()));

        idImp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        marcaImp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getMarca()));
        modeloImp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getModelo()));
        estadoImp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEstado()));
        tipoImp.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getTipo()));
        escaner.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getScanner()));
    }

    @FXML
    public void initialize() {
        cargarDatos();
        mostrar();

    }

    @FXML
    private Button add;

    @FXML
    private void switchToAdd() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuDispositivos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("menuDispositivos");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToSearch() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("buscar.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("buscar");
            stage.setScene(new Scene(root));

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToModify() throws IOException {
        Dispositivo seleccionado = dispositivos.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modificar.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("modificar");
                stage.setScene(new Scene(root));

                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar mensaje si no hay un dispositivo seleccionado
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Ningún dispositivo seleccionado");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un dispositivo para modificar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void switchToDelete() throws IOException {
        Dispositivo seleccionado = dispositivos.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            // Confirmación antes de eliminar
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Confirmar eliminación");
            alerta.setHeaderText("¿Estás seguro de que deseas eliminar este dispositivo?");
            alerta.setContentText("ID: " + seleccionado.getId() + " - Marca: " + seleccionado.getMarca());

            if (alerta.showAndWait().get() == ButtonType.OK) {
                // Eliminar de la lista y actualizar la tabla
                dispositivos.getItems().remove(seleccionado);
                dispositivo.remove(seleccionado); // Eliminar también del ArrayList para evitar que reaparezca
                System.out.println("Dispositivo eliminado correctamente.");
            }
        } else {
            // Mostrar mensaje si no hay un dispositivo seleccionado
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Ningún dispositivo seleccionado");
            alerta.setHeaderText(null);
            alerta.setContentText("Por favor, selecciona un dispositivo para eliminar.");
            alerta.showAndWait();
        }
    }

    @FXML
    private void cargarTabla() {
        borrarTabla();
        cargarDatos();
        mostrar();
        
    }

    @FXML
    private void borrarTabla() {
        // Borrar los datos de la tabla
        dispositivos.getItems().clear();
        dispositivos.refresh();
        ordenadores.getItems().clear();
        ordenadores.refresh();
        impresoras.getItems().clear();
        impresoras.refresh();
    }
    // Método cargarDatos que carga los datos de un fichero a arraylist
    @FXML
    public static void cargarDatos() {
        int id = 0;
        boolean terminar = false;
        do {
            Dispositivo d = new Dispositivo(id);
            if (d.load() == 0) {
                // El dispositivo existe y se ha cargado correctamente
                switch (d.getTipo()) {
                    case 1: // Ordenador
                        Ordenador o = new Ordenador(id);
                        o.load();
                        dispositivo.add(o);
                        break;
                    case 2: // Impresora
                        Impresora i = new Impresora(id);
                        i.load();
                        dispositivo.add(i);
                        break;
                    default: // Resto (dispositivos genéricos)
                        dispositivo.add(d);
                        break;
                }
            } else {
                // El dispositivo no existe en el fichero de datos. Terminamos la carga
                terminar = true;
            }
            id++;
        } while (!terminar);
        System.out.println("Se han cargado " + dispositivo.size() + " dispositivos");
    }
}
