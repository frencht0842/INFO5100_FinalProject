
import java.io.File;
import java.util.Scanner;

public class Dishes {
    private String name;
    private int rating;
    private double price;
    private File picture;

    // Constructor
    public Dishes(String name, int rating, double price, File picture) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.picture = picture;
    }

    // Method to print all attributes — Chapter 6
    public void getItem() {
        System.out.println("Dish Name: " + name);
        System.out.println("Rating: " + rating);
        System.out.println("Price: $" + price);
        if (picture != null) {
            System.out.println("Picture Path: " + picture.getAbsolutePath());
        } else {
            System.out.println("Picture: No picture available.");
        }
    }

    // Method to set or update the rating
    public void addItemRating(int newRating) {
        this.rating = newRating;
        System.out.println("Rating updated to: " + newRating);
    }

    // Method to set or update the price
    public void addItemPrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Price updated to: $" + newPrice);
    }

    // Method to set or update the picture
    public void addItemPicture(File newPicture) {
        this.picture = newPicture;
        System.out.println("Picture updated to: " + (newPicture != null ? newPicture.getAbsolutePath() : "No picture"));
    }

    // Main method to interact with the user — Chapter 4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dishes dish = null;

        System.out.println("Here are the dishes you've eaten!");
        while (true) {
            System.out.println("Type 'add item' to create a new dish, 'edit item' to modify it, or 'exit' to quit:");
            String input = scanner.nextLine().toLowerCase();

            switch (input) { // Chapter 3
                case "add item":
                    dish = createNewDish(scanner);
                    System.out.println("New dish successfully added!");
                    dish.getItem(); //
                    break; // Chapter 2

                case "edit item":
                    if (dish == null) {
                        System.out.println("No dish found. Please create a new dish first.");
                    } else {
                        editDish(dish, scanner);
                    }
                    break;

                case "exit":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default: // Chapter 1
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    // Method to create new dish with user input
    public static Dishes createNewDish(Scanner scanner) {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();

        System.out.print("Enter rating (integer value): ");
        int rating = Integer.parseInt(scanner.nextLine()); // Chapter 10

        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter picture file path (or leave blank for no picture): ");
        String filePath = scanner.nextLine();
        File picture = filePath.isEmpty() ? null : new File(filePath); // Chapter 12, will need help with this

        return new Dishes(name, rating, price, picture);
    }

    // Method to edit existing dish
    public static void editDish(Dishes dish, Scanner scanner) {
        while (true) {
            System.out.println("\nCurrent Dish Details:");
            dish.getItem();
            System.out.println("\nType 'name' to edit the name, 'rating' to edit the rating, 'price' to edit the price, 'picture' to edit the picture, or 'back' to return:");

            String command = scanner.nextLine().toLowerCase(); // Chapter 3
            switch (command) {
                case "name":
                    System.out.print("Enter new dish name: ");
                    dish.name = scanner.nextLine();
                    System.out.println("Name updated to: " + dish.name);
                    break;

                case "rating":
                    System.out.print("Enter new rating (integer value): ");
                    int newRating = Integer.parseInt(scanner.nextLine());
                    dish.addItemRating(newRating);
                    break;

                case "price":
                    System.out.print("Enter new price: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    dish.addItemPrice(newPrice);
                    break;

                case "picture":
                    System.out.print("Enter new picture file path (or leave blank for no picture): ");
                    String newFilePath = scanner.nextLine();
                    File newPicture = newFilePath.isEmpty() ? null : new File(newFilePath);
                    dish.addItemPicture(newPicture);
                    break;

                case "back":
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }
}