package udemy.masterOOdesign.ems.coffee_shop;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public interface ICustomer {

    public boolean receiveOrderNotification(int orderId);
    public void setOrderId(int orderId);
}
