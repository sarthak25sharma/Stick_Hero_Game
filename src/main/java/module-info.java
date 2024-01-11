module com.example.final_propro {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;
    requires junit;


    opens com.example.final_propro to javafx.fxml;
    exports com.example.final_propro;
}