package FinalProject;

import java.util.ArrayList;

public class RestaurantList {
  private String name;
  private String location;
  private ArrayList<Object> restaurants;
  
  // Constructor, name only
  public RestaurantList(String name) {
	  this.name = name;
  }
  
  // Constructor, name & list of restaurants
  public RestaurantList(String name, ArrayList<Object> restaurants) {
	  this.name = name;
	  this.restaurants = restaurants;
  }
  
  public ArrayList<Object> getRestaurants() {
	  return this.restaurants;
	  
  }
  
  public void addRestaurant(Object restaurant) {
	  if(!this.restaurants.contains(restaurant)) {
		  this.restaurants.add(restaurant);
	  }	 else {
		  System.out.println(this.name + " already contains this restaurant.");
	  }
  }
  
  public void removeRestaurant(Object restaurant) {
	  this.restaurants.remove(restaurant);
  }
}
