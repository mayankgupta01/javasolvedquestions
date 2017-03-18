package ikm.java7;

import java.math.BigDecimal;

/**
 * Created by mayank.gupta on 01/01/17.
 */

interface AccountInterface {
    BigDecimal balance = new BigDecimal(0.00); // All initializations are final in interface

}
public class Question33 implements AccountInterface {

    public Question33(BigDecimal initialValue) {
//        balance = initialValue; // compilation error
    }

    public String toString() {
        return balance.toString();
    }
}
