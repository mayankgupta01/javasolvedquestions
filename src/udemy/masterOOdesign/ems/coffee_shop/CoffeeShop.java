package udemy.masterOOdesign.ems.coffee_shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class CoffeeShop implements ISubject {

    private List<ICustomer> customers;
    private List<Integer> orders;
    private int orderId;
    private static int orderCounter = 0;

    CoffeeShop() {
        orders = new ArrayList<>();
    }
    
    public void prepareCoffee() {
        System.out.println("Prepared coffee for : " + orders.get(0));
        orderId = orders.get(0);
        orders.remove(0);
        notifyCustomers();
    }

    public void takeOrder(ICustomer c) {
        orders.add(++orderCounter);
        c.setOrderId(orderCounter);
    }

    @Override
    public void registerCustomer(ICustomer c) {
        if(customers == null) {
            customers = new ArrayList<>();
            customers.add(c);
        }else {
            customers.add(c);
        }
    }

    @Override
    public void unregisterCustomer(ICustomer c) {
        if(customers == null)
            return;
        customers.remove(c);
    }

    @Override
    public void notifyCustomers() {
        for(ICustomer customer : customers) {
            if(customer.receiveOrderNotification(orderId)) {
                unregisterCustomer(customer);
                break;
            }
        }
    }
}
