package ikm.java7;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question40 {

    public static void main(String[] args) {
        /*
        * Math.random gives random from 0 to 1
        * */
//        System.out.println(Math.random(10)); // cannot pass arguments
//        System.out.println(Math.random(0, 10));
        System.out.println(Math.round(Math.random() % 10));
        System.out.println(Math.round(Math.random() * 10));
        System.out.println(Math.random() * 10);
    }
}
