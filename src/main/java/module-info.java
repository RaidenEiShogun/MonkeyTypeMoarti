module com.example.keytyper {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.keytyper to javafx.fxml;
    exports com.example.keytyper;
    exports com.example.keytyper.Controllers;
    opens com.example.keytyper.Controllers to javafx.fxml;
}