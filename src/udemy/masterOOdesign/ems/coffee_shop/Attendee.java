package udemy.masterOOdesign.ems.coffee_shop;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class Attendee {


    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();

        Customer c1 = new Customer("Bob");
        Customer c2 = new Customer("Michelle");
        Customer c3 = new Customer("Tom");
        Customer c4 = new Customer("Jerry");


        coffeeShop.takeOrder(c1);
        coffeeShop.registerCustomer(c1);

        coffeeShop.takeOrder(c2);
        coffeeShop.registerCustomer(c2);

        coffeeShop.takeOrder(c3);
        coffeeShop.registerCustomer(c3);

        coffeeShop.takeOrder(c4);
        coffeeShop.registerCustomer(c4);

        coffeeShop.prepareCoffee();
        coffeeShop.prepareCoffee();
        coffeeShop.prepareCoffee();
    }
}
