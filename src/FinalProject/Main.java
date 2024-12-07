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
		static RestaurantList restaurants = new RestaurantList("My Restaurants");

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
        imgUrlInput.setPromptText("Image URL (optional)");

        TextField locationInput = new TextField();
        locationInput.setPromptText("City, State, Country");

        Button submitButton = new Button("+ Create Restaurant");

        root.add(new Label("Name: "), 0, 0);
        root.add(nameInput, 1, 0);

        root.add(new Label("Rating: "), 0, 1);
        root.add(ratingInput, 1, 1);

        root.add(new Label("Location: "), 0, 2);
        root.add(locationInput, 1, 2);

        root.add(imgUrlInput, 1, 3);
        root.add(new Label("Link to image: "), 0, 3);

        root.add(submitButton, 1, 4);

        root.setHgap(10);
        root.setVgap(10);
        root.setStyle("-fx-padding: 20;");

        Scene addRestaurantsScene = new Scene(root, 480, 800);
        primaryStage.setTitle("Add a New Restaurant");
        primaryStage.setScene(addRestaurantsScene);




        submitButton.setOnAction(e -> {
            String name = nameInput.getText();
            //String category = categoryInput.getText();
            int rating = Integer.parseInt(ratingInput.getText());
            String location = locationInput.getText();
            String imgUrl = imgUrlInput.getText();
            System.out.println(name + rating + imgUrl + location);
            Restaurant newRestaurant = new Restaurant(name, rating, imgUrl, location);
            restaurants.addRestaurant(newRestaurant);
            newRestaurant.printRestaurantDetails();
            //TODO: clear inputs after submit

            // Change screens on submit
            GridPane root2 = renderRestaurants();
            Button changeSceneButton = new Button("+ Add New ");
            root2.add(changeSceneButton, 0, 0);
            changeSceneButton.setStyle(
                    "-fx-background-color: #4CAF50; " +  // Green background
                    "-fx-text-fill: white; " +          // White text color
                    "-fx-font-size: 14px; " +           // Font size
                    "-fx-font-weight: bold; " +         // Bold text
                    "-fx-padding: 10px 20px; " +        // Padding inside the button
                    "-fx-background-radius: 5px; " +   // Rounded corners
                    "-fx-border-radius: 5px; " +       // Border rounding
                    "-fx-border-color: #388E3C; " +    // Border color
                    "-fx-border-width: 2px;"           // Border width
                );

            Button exportButton = new Button("> Export CSV");
            exportButton.setStyle(
                    "-fx-background-color: #4CAF50; " +  // Green background
                    "-fx-text-fill: white; " +          // White text color
                    "-fx-font-size: 14px; " +           // Font size
                    "-fx-font-weight: bold; " +         // Bold text
                    "-fx-padding: 10px 20px; " +        // Padding inside the button
                    "-fx-background-radius: 5px; " +   // Rounded corners
                    "-fx-border-radius: 5px; " +       // Border rounding
                    "-fx-border-color: #388E3C; " +    // Border color
                    "-fx-border-width: 2px;"           // Border width
                );

            exportButton.setOnAction(ev -> {
                restaurants.writeRestaurantsToCSV();
            });

            Button importButton = new Button("< Import CSV");
            importButton.setStyle(
                    "-fx-background-color: #4CAF50; " +  // Green background
                    "-fx-text-fill: white; " +          // White text color
                    "-fx-font-size: 14px; " +           // Font size
                    "-fx-font-weight: bold; " +         // Bold text
                    "-fx-padding: 10px 20px; " +        // Padding inside the button
                    "-fx-background-radius: 5px; " +   // Rounded corners
                    "-fx-border-radius: 5px; " +       // Border rounding
                    "-fx-border-color: #388E3C; " +    // Border color
                    "-fx-border-width: 2px;"           // Border width
                );
            importButton.setOnAction(ev -> {
            	restaurants = restaurants.importRestaurantsFromCSV("My Restaurants.csv");
            	// TODO: refresh scene / reredner list
            });

            root2.add(exportButton, 1, 0);
            root2.add(importButton, 2, 0);
            changeSceneButton.setOnAction(evt -> {
                primaryStage.setScene(addRestaurantsScene);
            });
            Scene viewRestaurantsScene = new Scene(root2, 480, 800);

            primaryStage.setScene(viewRestaurantsScene);
        });


        primaryStage.show();
    }

    public static GridPane renderRestaurants() {
    	GridPane restaurantPane = new GridPane();
        restaurantPane.setHgap(10);
        restaurantPane.setVgap(5);
        restaurantPane.setStyle("-fx-padding: 20;");

        Label titleLabel = new Label("My Restaurants");
        titleLabel.setStyle("-fx-font-family: 'Helvetica'; -fx-font-size: 30px; -fx-padding: 10px;");

        restaurantPane.add(titleLabel, 0, 1);


		// List of restaurants
    	for(int i = 0; i < restaurants.getRestaurants().size(); i++) {
    		Restaurant res = restaurants.getRestaurants().get(i);

    		int numRowsPerRes = 4;
    		int firstRowIndex = i * numRowsPerRes;

    		Label nameLabel = new Label(res.getName());
    		nameLabel.setStyle("-fx-font-family: 'Helvetica'; -fx-font-size: 21px; -fx-font-weight: bold; -fx-padding: 10px;");
    		restaurantPane.add(nameLabel, 0, firstRowIndex + 3);

    		int rating = res.getRating(); // Get the integer rating
    		Label ratingLabel = new Label(rating + "/10");

    		// Determine color based on rating value
    		String textColor;
    		if (rating >= 8) {
    		    textColor = "#4CAF50"; // Green for high ratings
    		} else if (rating >= 5) {
    		    textColor = "#FFA500"; // Orange for medium ratings
    		} else {
    		    textColor = "#FF0000"; // Red for low ratings
    		}

    		// Set the style for the rating label
    		ratingLabel.setStyle(
    		    "-fx-font-size: 21px; " +
    		    "-fx-text-fill: " + textColor + "; " + // Apply the dynamic color
    		    "-fx-font-weight: bold;" +
    		    "-fx-background-color: mintcream; " +
    		    "-fx-padding: 10px 10px; " + // Adds space inside the circle
    		    "-fx-border-radius: 50%; " +
    		    "-fx-background-radius: 50%;"  // Makes the background a circle
    		);

    		// Add the label to the GridPane
    		restaurantPane.add(ratingLabel, 1, firstRowIndex + 3);

    		// Label for the location
    		Label locationLabel = new Label(res.getLocation());
    		locationLabel.setStyle("-fx-font-size: 17px; -fx-text-fill: gray; -fx-padding: 10px; ");
    		restaurantPane.add(locationLabel, 0, firstRowIndex + 4);

             if(res.getImgUrl() != "test") {
            	 Image image = new Image(res.getImgUrl());
                 ImageView imageView = new ImageView(image);
                 imageView.setFitHeight(70);
                 imageView.setPreserveRatio(true);
                 restaurantPane.add(imageView, 0, firstRowIndex+5);
             }

    	}

    	return restaurantPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}