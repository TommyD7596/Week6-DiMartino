module com.example.dimartinoweek6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dimartinoweek6 to javafx.fxml;
    exports com.example.dimartinoweek6;
}