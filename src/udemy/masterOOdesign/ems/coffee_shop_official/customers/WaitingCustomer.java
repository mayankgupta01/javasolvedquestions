package udemy.masterOOdesign.ems.coffee_shop_official.customers;


// Observer
public interface WaitingCustomer {

	void orderReady(String preparedDrink);
	public String getName();
	public String getDrinkOrdered();
}
