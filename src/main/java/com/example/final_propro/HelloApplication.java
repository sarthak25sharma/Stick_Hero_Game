package com.example.final_propro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 474);
        stage.setTitle("Stick Hero Warriors");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws InterruptedException {
        CounterThread th = new CounterThread();

        th.start();
        launch();

        th.wait();
        th.join();



    }
}
//add a button to take me to main menu in code for scene 3.
//colour setting and pause score control.
