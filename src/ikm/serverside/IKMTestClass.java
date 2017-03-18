package ikm.serverside;

import com.sun.xml.internal.ws.api.model.CheckedException;

/**
 * Created by mayank.gupta on 06/01/17.
 */
public class IKMTestClass {

    public static void main(String[] args) {
        Integer num1 = new Integer(1);
        Integer num2 = num1;

        num1+=1;
        System.out.println(num1);
        System.out.println(num2);
    }
}

