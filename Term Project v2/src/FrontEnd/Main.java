package FrontEnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //intializes the program at the store home page
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("storeHome.fxml"));
        primaryStage.setTitle("TnT Technology Store");
        primaryStage.setScene(new Scene(root, 1200, 850));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
