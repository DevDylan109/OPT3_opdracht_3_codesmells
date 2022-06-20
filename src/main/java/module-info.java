module com.example.opt3_opdracht_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.opt3_opdracht_2 to javafx.fxml;
    exports com.example.opt3_opdracht_2;
}