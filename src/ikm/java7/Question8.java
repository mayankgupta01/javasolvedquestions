package ikm.java7;



/**
 * Created by mayank.gupta on 31/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class Question8 {

    public static void main(String[] args) {
        System.out.println(Math.random());  // output could be any float and not an integer
        System.out.println(Math.round(10.55)); // rounded to 11
        System.out.println(Math.floor(10.99)); // floored to 10.0
        System.out.println(Math.nextUp(10.22)); // 10.22000000000002
        System.out.println(Math.nextAfter(10.22, 0.01)); // 10.21999999999999
    }
}
