package Front_End;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    //used just to change the naming of primaryStage to be more representative
    Stage window;

    //stages for customer side of program
    Scene storeHome, searchResults, productPage, checkOut;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //loads the storeHome fxml file to be shown as the default scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeHome.fxml"));
        Parent root = loader.load();
        storeHome = new Scene(root);

        window.setScene(storeHome);
        window.show();

        //use the commented out code to help with linking scenes together
        //mainly the lines like "employee.setOnAction(e -> window.setScene(storeHome));"

        /*
        Label welcomeMSG = new Label("Welcome to the program. Click on the button where you would like to go to");

        Button employee = new Button("Go to employee portal");
        employee.setOnAction(e -> window.setScene(storeHome));

        Button customer = new Button("Go to store");
        customer.setOnAction(e -> window.setScene(storeHome));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(welcomeMSG, employee, customer);
        welcomeScene = new Scene(layout1, 600, 600);

        window.setScene(welcomeScene);
        window.setTitle("COIS 2240H Term Project");
        window.show();
        */
    }


}
