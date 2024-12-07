package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RestaurantList {
	  private String name;
	  private String location;
	  private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

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
		  if(this.getRestaurants() != null && !this.getRestaurants().contains(restaurant)) {
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
	    String fileName = this.getName() + ".csv";
	    try (FileWriter writer = new FileWriter(fileName)) {
	        writer.append("Name,Rating,Location,ImgUrl\n");

	        for (Restaurant restaurant : this.restaurants) {
	            writer.append(restaurant.getName())
	                  .append(",")
	                  .append(String.valueOf(restaurant.getRating()))
	                  .append(",")
	                  .append(restaurant.getLocation())
	                  .append(",")
	                  .append(String.valueOf(restaurant.getImgUrl()))
	                  .append("\n");
	        }
	        System.out.println("CSV file written successfully: " + fileName);
	    } catch (IOException e) {
	        System.err.println("Error writing to file: " + e.getMessage());
	    }
	  }

	  public RestaurantList importRestaurantsFromCSV(String fileName) {
	        RestaurantList restaurantList = new RestaurantList(fileName);

	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;

	            reader.readLine();

	            while ((line = reader.readLine()) != null) {
	                String[] fields = line.split(",");

	                if (fields.length == 4) {
	                	System.out.print("heeeere");
	                    String name = fields[0].replace(".csv", "").trim();
	                    int rating = Integer.parseInt(fields[1].trim());
	                    String location = fields[2].trim();
	                    String imgUrl = fields[3].trim();
	                    System.out.println(fields[3] + " " + imgUrl);
	                    Restaurant restaurant = new Restaurant(name, rating, imgUrl, location);
	                    restaurantList.addRestaurant(restaurant);
	                } else {
	                    System.err.println("Invalid line format: " + line);
	                }
	            }

	            System.out.println("CSV file imported successfully: " + fileName);
	        } catch (IOException e) {
	            System.err.println("Error reading the file: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            System.err.println("Error parsing number from file: " + e.getMessage());
	        }

	        return restaurantList;
	    }
	}