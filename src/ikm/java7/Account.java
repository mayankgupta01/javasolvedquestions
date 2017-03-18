package ikm.java7;

/**
 * Created by mayank.gupta on 30/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class Account<S> {
    private S accountType;
    public void add (S newType){};
    public S get(){return accountType;}
}
