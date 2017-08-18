package udemy.masterOOdesign.ems.coffee_shop;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class Customer implements ICustomer {

    private String name;
    private int orderId;

    Customer(String name) {
        this.name = name;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Override
    public boolean receiveOrderNotification(int orderId) {

        if(this.orderId == orderId) {
            System.out.println("Order received by " + name+ "  ! Thanks !");
            return true;
        }
        return false;
    }
}
