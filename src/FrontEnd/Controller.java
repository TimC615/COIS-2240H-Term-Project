package FrontEnd;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    //TIPS
    //Track what the current scene is to fix
    //Stage stage = (Stage) ((Node) ((MenuItem)event.getSource()... line

    @FXML
    public void loadHome(javafx.event.ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/FrontEnd/storeHome.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void loadSearchResults(javafx.event.ActionEvent event) throws IOException {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("searchResults.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1200, 850);
                Stage stage = new Stage();
                stage.setTitle("TnT Technology Store");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
    }

    @FXML
    public void loadProductPage(javafx.event.ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("/FrontEnd/productPage.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    //@FXML
    //public void loadCheckOut(ActionEvent event) throws Exception {
    //FXMLLoader loader = new FXMLLoader(getClass().getResource("checkOut.fxml"));
    //}
    public enum StageFactory {
        INSTANCE ;

        private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

        public ObservableList<Stage> getOpenStages() {
            return openStages ;
        }

        private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);
        public final ObjectProperty<Stage> currentStageProperty() {
            return this.currentStage;
        }
        public final javafx.stage.Stage getCurrentStage() {
            return this.currentStageProperty().get();
        }
        public final void setCurrentStage(final javafx.stage.Stage currentStage) {
            this.currentStageProperty().set(currentStage);
        }

        public void registerStage(Stage stage) {
            stage.addEventHandler(WindowEvent.WINDOW_SHOWN, e ->
                    openStages.add(stage));
            stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e ->
                    openStages.remove(stage));
            stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
                if (isNowFocused) {
                    currentStage.set(stage);
                } else {
                    currentStage.set(null);
                }
            });
        }

        /*
        public Stage createStage() {
            Stage stage = new Stage();
            registerStage(stage);
            return stage ;
        }
        */
    }
}
