package FrontEnd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    Scene storeHome, productPage, searchResults, checkOut;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("storeHome.fxml"));
        window = primaryStage;
        window.setTitle("TnT Technology Store");
        window.setScene(new Scene(root, 1200, 850));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
