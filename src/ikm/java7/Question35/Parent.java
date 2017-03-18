package ikm.java7.Question35;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Parent {
    protected static int count = 0;
    public Parent() {
        count++;
    }
    static int getCount() {
        return count;
    }
}
