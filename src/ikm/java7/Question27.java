package ikm.java7;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by mayank.gupta on 06/01/17.
 */
public class Question27 {

    public static void main(String[] args) {
        Locale locale = new Locale("th", "TH");
        ResourceBundle bundle = ResourceBundle.getBundle("TestBundle", locale);
        System.out.println("" + bundle.getString("sayHello"));
    }
}
