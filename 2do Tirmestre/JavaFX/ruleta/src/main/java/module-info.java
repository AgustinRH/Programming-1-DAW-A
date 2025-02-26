module com.ruleta {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ruleta to javafx.fxml;
    exports com.ruleta;
}
