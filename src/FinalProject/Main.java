package FinalProject;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	// TODO: use RestaurantList class
    	// TODO: Add print all restaurants method to resList class
    	ArrayList <Restaurant> restaurants = new ArrayList();
      	GridPane root = new GridPane();

      	// Restaurant inputs
        TextField textField1 = new TextField();
        textField1.setPromptText("Name: ");

        TextField textField2 = new TextField();
        textField2.setPromptText("Category");

        TextField textField3 = new TextField();
        textField3.setPromptText("Ratng");

        TextField textField4 = new TextField();
        textField3.setPromptText("Image URL");

        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {
            String input1 = textField1.getText();
            String input2 = textField2.getText();
            int rating = Integer.parseInt(textField3.getText());
            Restaurant newRestaurant = new Restaurant(input1, rating);
            restaurants.add(newRestaurant);
            newRestaurant.printRestaurantDetails();
            System.out.println(restaurants.size());
            //TODO: change screens on submit
        });

        // Add components to the grid
        root.add(textField1, 0, 0); // Column 0, Row 0
        root.add(textField2, 0, 1); // Column 0, Row 1
        root.add(textField3, 0, 2);
        root.add(submitButton, 0, 3);

        // Set some padding and spacing
        root.setHgap(10); // Horizontal spacing between columns
        root.setVgap(10); // Vertical spacing between rows
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 480, 800);
        primaryStage.setTitle("Create a New Restaurant");
        primaryStage.setScene(scene);

        // Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
