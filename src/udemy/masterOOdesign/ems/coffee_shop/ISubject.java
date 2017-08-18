package udemy.masterOOdesign.ems.coffee_shop;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public interface ISubject {

    public void registerCustomer(ICustomer c);
    public void unregisterCustomer(ICustomer c);
    public void notifyCustomers();
}
