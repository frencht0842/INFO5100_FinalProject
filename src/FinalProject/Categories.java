package FinalProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Categories {
	public class RestaurantList {
	    private static class RestaurantCategory {
	        private String name;
	        private String description;
	        private ArrayList<Restaurant> restaurants;

	        public RestaurantCategory(String name, String description) {
	            this.name = name;
	            this.description = description;
	            this.restaurants = new ArrayList<>();
	        }

	        public String getName() {
	            return name;
	        }

	        public String getDescription() {
	            return description;
	        }

	        public void addRestaurant(RestaurantList restaurant) {
	            restaurants.add(restaurant);
	        }

	        public void viewRestaurants() {
	            if (restaurants.isEmpty()) {
	                System.out.println("This list is empty.");
	            } else {
	                System.out.println("Restaurants in the list:");
	                for (int i = 0; i < restaurants.size(); i++) {
	                    System.out.println((i + 1) + ". " + restaurants.get(i));
	                }
	            }
	        }

	        @Override
	        public String toString() {
	            return "List Name: " + name + ", Description: " + description + ", Items: " + restaurants.size();
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ArrayList<RestaurantList> userLists = new ArrayList<>();
	        boolean exit = false;

	        System.out.println("Welcome to the Restaurant Lists Manager!");

	        while (!exit) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Create a new list");
	            System.out.println("2. Add a restaurant to a list");
	            System.out.println("3. View all lists");
	            System.out.println("4. View a specific list");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline

	            switch (choice) {
	                case 1: // Create a new list
	                    System.out.print("Enter the name of the list: ");
	                    String listName = scanner.nextLine();
	                    System.out.print("Enter a description for the list: ");
	                    String listDescription = scanner.nextLine();
	                    userLists.add(new RestaurantList(listName, listDescription));
	                    System.out.println("List \"" + listName + "\" created!");
	                    break;

	                case 2: // Add a restaurant to a list
	                    if (userLists.isEmpty()) {
	                        System.out.println("No lists available. Please create a list first.");
	                        break;
	                    }
	                    System.out.println("Available Lists:");
	                    for (int i = 0; i < userLists.size(); i++) {
	                        System.out.println((i + 1) + ". " + userLists.get(i).getName());
	                    }
	                    System.out.print("Choose a list to add to (1-based index): ");
	                    int listIndex = scanner.nextInt() - 1;
	                    scanner.nextLine(); // Consume the newline

	                    if (listIndex >= 0 && listIndex < userLists.size()) {
	                        ArrayList<RestaurantList.Restaurant> catalog = RestaurantList.getCatalog();
	                        System.out.println("Available Restaurants:");
	                        for (int i = 0; i < catalog.size(); i++) {
	                            System.out.println((i + 1) + ". " + catalog.get(i));
	                        }
	                        System.out.print("Choose a restaurant to add (1-based index): ");
	                        int restaurantIndex = scanner.nextInt() - 1;
	                        scanner.nextLine(); // Consume the newline

	                        if (restaurantIndex >= 0 && restaurantIndex < catalog.size()) {
	                            userLists.get(listIndex).addRestaurant(catalog.get(restaurantIndex));
	                            System.out.println("Restaurant added to the list!");
	                        } else {
	                            System.out.println("Invalid restaurant choice.");
	                        }
	                    } else {
	                        System.out.println("Invalid list choice.");
	                    }
	                    break;

	                case 3: // View all lists
	                    if (userLists.isEmpty()) {
	                        System.out.println("No lists available.");
	                    } else {
	                        System.out.println("All Lists:");
	                        for (int i = 0; i < userLists.size(); i++) {
	                            System.out.println((i + 1) + ". " + userLists.get(i));
	                        }
	                    }
	                    break;

	                case 4: // View a specific list
	                    if (userLists.isEmpty()) {
	                        System.out.println("No lists available.");
	                        break;
	                    }
	                    System.out.println("Available Lists:");
	                    for (int i = 0; i < userLists.size(); i++) {
	                        System.out.println((i + 1) + ". " + userLists.get(i).getName());
	                    }
	                    System.out.print("Choose a list to view (1-based index): ");
	                    int viewIndex = scanner.nextInt() - 1;
	                    scanner.nextLine(); // Consume the newline

	                    if (viewIndex >= 0 && viewIndex < userLists.size()) {
	                        System.out.println("Viewing List: " + userLists.get(viewIndex).getName());
	                        userLists.get(viewIndex).viewRestaurants();
	                    } else {
	                        System.out.println("Invalid list choice.");
	                    }
	                    break;

	                case 5: // Exit
	                    exit = true;
	                    System.out.println("Closed");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        scanner.close();
	    }
	}
}