package FinalProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RestaurantList {
  private String name;
  private String location;
  private ArrayList<Restaurant> restaurants;;

  // Constructor, name only
  public RestaurantList(String name) {
	  this.name = name;
  }

  // Constructor, name & list of restaurants
  public RestaurantList(String name, ArrayList<Restaurant> restaurants) {
	  this.name = name;
	  this.restaurants = restaurants;
  }

  public String getName(){
    return this.name;
  }

  public ArrayList<Restaurant> getRestaurants() {
	  return this.restaurants;

  }

  public void addRestaurant(Restaurant restaurant) {
	  if(!this.restaurants.contains(restaurant)) {
		  this.restaurants.add(restaurant);
	  }	 else {
		  System.out.println(this.name + " already contains this restaurant.");
	  }
  }

  public void removeRestaurant(Restaurant restaurant) {
	  this.restaurants.remove(restaurant);
  }

  public void printRestaurants(){
	  for(int i=0; i < this.restaurants.size(); i++) {
		  this.restaurants.get(i).printRestaurantDetails();
	  }
  }

  public void writeRestaurantsToCSV() {
    String fileName = this.getName();
    try (FileWriter writer = new FileWriter(fileName)) {
        // Write the header line
        writer.append("Name,Rating,Location\n");

        // Write each restaurant's details
        for (Restaurant restaurant : this.restaurants) {
            writer.append(restaurant.getName())
                  .append(",")
                  .append(String.valueOf(restaurant.getRating()))
                  .append(",")
                  .append(restaurant.getLocation())
                  .append("\n");
        }
        System.out.println("CSV file written successfully: " + fileName);
    } catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
