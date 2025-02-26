module com.gestion.dispositivos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.gestion.dispositivos to javafx.fxml;
    exports com.gestion.dispositivos;
}
