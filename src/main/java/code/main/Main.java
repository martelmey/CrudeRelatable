package code.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui.main.fxml"));
        primaryStage.setTitle("MXANA's Crude Relatable");
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
