package FrontEnd;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.sql.*;

public class Controller {
    //creating ways to update locations on the store front
    public Label name1, name2, name3, name4;
    public ImageView image1, image2 ,image3 , image4;

    public Label name11, name12, name13, name14, name15, name16, name17, name18, name19;
    public ImageView image11, image12, image13, image14, image15, image16, image17, image18, image19;
    public Label price11, price12, price13, price14, price15, price16, price17, price18, price19;
    public Label rating11, rating12,rating13,rating14,rating15,rating16,rating17,rating18,rating19;
    public Label special11, special12,special13,special14,special15,special16,special17,special18,special19;

    //loads the store home page
    @FXML
    public void loadHome(javafx.event.ActionEvent event) throws IOException{
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

        //creates a store home page
        Parent parent = FXMLLoader.load(getClass().getResource("/FrontEnd/storeHome.fxml"));
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

        try {
            //outputs 4 products from the database (name and image) to the store home page as featured products
            //Note: was not able to output images correctly so they are currently commented out
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\timot\\Documents\\COIS 2240H\\Term Project v2\\FinalDatabase.db");
            Statement statement = conn.createStatement();
            name1.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 2")).toString());
            //image1.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 2")));

            name2.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 15")).toString());
            //image2.getGraphics((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 15")));

            name3.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 89")).toString());
            //image3.getGraphics((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 89")));

            name4.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 60")).toString());
            image4.getImage();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //loads the search results page
    @FXML
    public void loadSearchResults(javafx.event.ActionEvent event) throws IOException {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

        //creates new window for the search results
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("searchResults.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);
        Stage stage = new Stage();
        stage.setTitle("TnT Technology Store");
        stage.setScene(scene);
        stage.show();

        String searchName;
        searchName = event.getTarget().toString();
        try {
            //links database to java program
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\timot\\Documents\\COIS 2240H\\Term Project v2\\FinalDatabase.db");
            Statement statement = conn.createStatement();

            switch (searchName) {
                case "CPUs":

                    //Outputs the names of each product from database to the storefront
                    name11.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 0")).toString());
                    name12.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 1")).toString());
                    name13.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 2")).toString());
                    name14.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 3")).toString());
                    name15.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 4")).toString());
                    name16.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 5")).toString());
                    name17.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 6")).toString());
                    name18.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 7")).toString());
                    name19.setText((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 8")).toString());

                    //Note: was not able to output images correctly so they are currently commented out
                    //Outputs the images for each product from database to the storefront
                    /*
                    image11.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 0")));
                    image12.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 1")));
                    image13.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 2")));
                    image14.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 3")));
                    image15.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 4")));
                    image16.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 5")));
                    image17.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 6")));
                    image18.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 7")));
                    image19.setParent((statement.executeQuery("SELECT Image FROM Products WHERE ProductID = 8")));
                    */

                    //Outputs the price of each product from database to the storefront
                    price11.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 0")).toString()));
                    price12.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 1")).toString()));
                    price13.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 2")).toString()));
                    price14.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 3")).toString()));
                    price15.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 4")).toString()));
                    price16.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 5")).toString()));
                    price17.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 6")).toString()));
                    price18.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 7")).toString()));
                    price19.setText("Cost: $" + ((statement.executeQuery("SELECT Name FROM Products WHERE ProductID = 8")).toString()));

                    //Outputs the average review of each product from database to the storefront
                    rating11.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 0")).toString()) + " / 5");
                    rating12.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 1")).toString()) + " / 5");
                    rating13.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 2")).toString()) + " / 5");
                    rating14.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 3")).toString()) + " / 5");
                    rating15.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 4")).toString()) + " / 5");
                    rating16.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 5")).toString()) + " / 5");
                    rating17.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 6")).toString()) + " / 5");
                    rating18.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 7")).toString()) + " / 5");
                    rating19.setText("User Review: " + ((statement.executeQuery("SELECT UserReviews FROM Products WHERE ProductID = 8")).toString()) + " / 5");

                    //Outputs the number of cores of each product from database to the storefront (special value for CPUs)
                    special11.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 0")).toString()));
                    special12.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 1")).toString()));
                    special13.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 2")).toString()));
                    special14.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 3")).toString()));
                    special15.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 4")).toString()));
                    special16.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 5")).toString()));
                    special17.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 6")).toString()));
                    special18.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 7")).toString()));
                    special19.setText("Number of Cores: " + ((statement.executeQuery("SELECT NumCores FROM Products WHERE ProductID = 8")).toString()));

                    break;
                case "GPUs":
                    //similar to first case
                    break;
                case "Motherboards":
                    //similar to first case
                    break;
                case "RAM":
                    //similar to first case
                    break;
                case "Power Supplies":
                    //similar to first case
                    break;
                case "Case Fans":
                    //similar to first case
                    break;
                case "HDDs":
                    //similar to first case
                    break;
                case "SSDs":
                    //similar to first case
                    break;
                case "Cases":
                    //similar to first case
                    break;
                default:
                    break;
            }
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //loads the product page
    @FXML
    public void loadProductPage(javafx.event.ActionEvent event) throws IOException{
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("productPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 850);
        Stage stage = new Stage();
        stage.setTitle("TnT Technology Store");
        stage.setScene(scene);
        stage.show();
    }

    //exits the program
    @FXML
    public void exitStore(javafx.event.ActionEvent event) throws IOException{
        Platform.exit();
        System.exit(0);
    }
}
