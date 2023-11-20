module com.lisa.infhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lisa.infhotel to javafx.fxml;
    exports com.lisa.infhotel;
}