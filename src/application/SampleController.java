package application;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SampleController {
    
    @FXML
    private void handleOpenForm() {
        // Create a new Dialog
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Restaurant Review");

        // Configure the form layout using a GridPane
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        // Add fields to the form
        TextField restaurantNameField = new TextField();
        restaurantNameField.setPromptText("Enter restaurant name");

        TextField locationField = new TextField();
        locationField.setPromptText("Enter location");

        TextField ratingField = new TextField();
        ratingField.setPromptText("Enter overall rating");

        TextArea dishesTriedArea = new TextArea();
        dishesTriedArea.setPromptText("List the dishes you've tried");
        dishesTriedArea.setWrapText(true);

        // Add fields to the GridPane
        form.addRow(0, new Label("Restaurant Name:"), restaurantNameField);
        form.addRow(1, new Label("Location:"), locationField);
        form.addRow(2, new Label("Overall Rating:"), ratingField);
        form.addRow(3, new Label("Dishes Tried:"), dishesTriedArea);

        // Set the content of the dialog
        dialog.getDialogPane().setContent(form);

        // Set dialog buttons (OK and Cancel)
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Show the dialog and wait for a response
        dialog.showAndWait();
    }
}
