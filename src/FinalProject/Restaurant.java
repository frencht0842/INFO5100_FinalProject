package FinalProject;

import java.util.ArrayList;

public class Restaurant {
	private String name;
	private ArrayList<Dishes> dishes;
	private ArrayList<String> categories;
	private int rating;
	private String imgUrl;
	private String location;
	
	// Constructor
	public Restaurant(String name) {
		this.name = name;
	}
	
	public Restaurant(String name, int rating) {
		this.name = name;
		this.rating = rating;
	}
	
	public Restaurant(String name, int rating, String imgUrl, String location) {
		this.name = name;
		this.rating = rating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public String getImgUrl() {
		return this.imgUrl;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void addDish(Dishes dish) {
		if(!this.dishes.contains(dish)){
			this.dishes.add(dish);
		} else {
			System.out.println(this.name + " already includes dish " + dish.name);
		}
	}
	
	public void removeDish(Dishes dish) {
		this.dishes.remove(dish);
	}
	
	public void addCategory(String category) {
		if(!this.categories.contains(category)){
			this.categories.add(category);
		} else {
			System.out.println(this.name + " already includes category " + category);
		}
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public void printRestaurantDetails() {
		System.out.println("Name: " + this.name);
		System.out.println("Rating: " + this.rating);
	}
	
	// TODO: test in main
	public static void main() {}
}
