package FinalProject;

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
}
