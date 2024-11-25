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
	static ArrayList <Restaurant> restaurants = new ArrayList();

    @Override
    public void start(Stage primaryStage) {
    	// TODO: use RestaurantList class
    	// TODO: Add print all restaurants method to resList class
      	GridPane root = new GridPane();

      	// Restaurant inputs
        TextField nameInput = new TextField();
        nameInput.setPromptText("Name: ");

        TextField categoryInput = new TextField();
        categoryInput.setPromptText("Category");

        TextField ratingInput = new TextField();
        ratingInput.setPromptText("Rating");

        TextField imgUrlInput = new TextField();
        imgUrlInput.setPromptText("Image URL");

        Button submitButton = new Button("+ Create Restaurant");

        // Add components to the grid
        root.add(nameInput, 0, 0); // Column 0, Row 0
        root.add(categoryInput, 0, 1); // Column 0, Row 1
        root.add(ratingInput, 0, 2);
        root.add(submitButton, 0, 3);

        // Set some padding and spacing
        root.setHgap(10); // Horizontal spacing between columns
        root.setVgap(10); // Vertical spacing between rows
        root.setStyle("-fx-padding: 20;");

        Scene restaurantCreationScene = new Scene(root, 480, 800);
        primaryStage.setTitle("Create a New Restaurant");
        primaryStage.setScene(restaurantCreationScene);




        submitButton.setOnAction(e -> {
            String name = nameInput.getText();
            String category = categoryInput.getText();
            int rating = Integer.parseInt(ratingInput.getText());
            Restaurant newRestaurant = new Restaurant(name, rating);
            restaurants.add(newRestaurant);
            newRestaurant.printRestaurantDetails();
            System.out.println(restaurants.size());
            //TODO: clear inputs after submit

            // CHange screens on submit
            GridPane root2 = renderRestaurants();
            Button changeSceneButton = new Button("Switch to add res scene");
            root2.add(changeSceneButton, 0,0);
            changeSceneButton.setOnAction(evt -> {
                primaryStage.setScene(restaurantCreationScene);
            });
            Scene secondScene = new Scene(root2, 480, 800);

            primaryStage.setScene(secondScene);
        });



        // Display the stage
        primaryStage.show();
    }

    public static GridPane renderRestaurants() {
    	GridPane rezzies = new GridPane();
		 rezzies.add(new Label("Title"), 0, 1);  // Column 0, Row (i + 1)
		 rezzies.add(new Label("Rating"), 1, 1);

    	for(int i = 0; i < restaurants.size(); i++) {
    		Restaurant res = restaurants.get(i);
    		 rezzies.add(new Label(res.getName()), 0, i + 2);  // Column 0, Row (i + 1)
             rezzies.add(new Label(Integer.toString(res.getRating())), 1, i + 2); // Column 1, Row (i + 1)
//             rezzies.add(new Label(res.getCategory()), 2, i + 1); // Column 2, Row (i + 1)
    	}

    	return rezzies;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
