package udemy.masterOOdesign.ems.coffee_shop_official.client;


import udemy.masterOOdesign.ems.coffee_shop_official.coffeeshop.CoffeeAttendent;
import udemy.masterOOdesign.ems.coffee_shop_official.customers.Customer;

public class CoffeeShop {
	
	public static void main(String args[]){
		
		
		Customer robert = new Customer("Robert", "French Vanilla");
		Customer bill = new Customer("Bill", "Hot Coffee");
		
		CoffeeAttendent coffeeAttendent = new CoffeeAttendent();
		coffeeAttendent.takeOrder(robert);
		coffeeAttendent.takeOrder(bill);
		
		// prepare drink
		coffeeAttendent.prepareDrink("French Vanilla");
		coffeeAttendent.prepareDrink("Hot Coffee");

		// order up...
		coffeeAttendent.callOutCompletedOrders();
	}
}
