package FinalProject;

import java.util.ArrayList;

public class Restaurant {
	private String name;
	private ArrayList<Dishes> dishes;
	private ArrayList<String> categories;
	private int rating;
	
	// Constructor
	public Restaurant(String name) {
		this.name = name;
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
	
	// TODO: test in main
	public static void main() {}
}
