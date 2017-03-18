/**
 * Created by mayank.gupta on 06/12/16.
 */
public class JVMMethodInvocationOrder {

    static {
        System.out.println("Inside <clinit>");
    }

    public JVMMethodInvocationOrder() {
        System.out.println("Inside <init>");
    }

    public void getName() {
        System.out.println("Inside getName");
    }
}
