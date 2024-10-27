module com.example.app_bookyourstay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.app_bookyourstay to javafx.fxml;
    exports com.example.app_bookyourstay;
}