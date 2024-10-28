module com.example.app_bookyourstay {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.BookYourStay to javafx.fxml;
    exports co.edu.uniquindio.BookYourStay;
}