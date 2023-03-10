module e.doc.edocserver {
    requires javafx.controls;
    requires javafx.fxml;


    opens e.doc.edocserver to javafx.fxml;
    exports e.doc.edocserver;
}