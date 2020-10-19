package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        // should be using different approach
        Parent root = loader.load();
            primaryStage.setTitle("Schulteam Veranstalter");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
