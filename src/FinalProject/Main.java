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

        Scene restaurantCreationScene = new Scene(root, 480, 800);
        primaryStage.setTitle("Create a New Restaurant");
        primaryStage.setScene(restaurantCreationScene);




        submitButton.setOnAction(e -> {
            String name = nameInput.getText();
//            String category = categoryInput.getText();
            int rating = Integer.parseInt(ratingInput.getText());
            String location = locationInput.getText();
            String imgUrl = imgUrlInput.getText();
            System.out.println(name + rating + imgUrl + location);
            Restaurant newRestaurant = new Restaurant(name, rating, imgUrl, location);
            restaurants.add(newRestaurant);
            newRestaurant.printRestaurantDetails();
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
    	GridPane restaurantPane = new GridPane();
        restaurantPane.setHgap(10);
        restaurantPane.setVgap(10);
        restaurantPane.setStyle("-fx-padding: 20;");
		restaurantPane.add(new Label("Title"), 0, 1);  // Column 0, Row (i + 1)
		restaurantPane.add(new Label("Rating"), 1, 1);
		restaurantPane.add(new Label("Location"), 2, 1);

    	for(int i = 0; i < restaurants.size(); i++) {
    		Restaurant res = restaurants.get(i);
    		 restaurantPane.add(new Label(res.getName()), 0, i + 2);  // Column 0, Row (i + 1)
             restaurantPane.add(new Label(Integer.toString(res.getRating())), 1, i + 2); // Column 1, Row (i + 1)
             restaurantPane.add(new Label(res.getLocation()), 2, i + 2);

//             Image image = new Image(res.getImgUrl()); // Replace with your image URL
//             ImageView imageView = new ImageView(image);

//             imageView.setFitWidth(200); // Set width
//             imageView.setPreserveRatio(true); // Preserve aspect ratio
//             restaurantPane.add(imageView, i, i+4);
//             restaurantPane.add(new Label(res.getCategory()), 2, i + 1); // Column 2, Row (i + 1)
    	}

    	return restaurantPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
