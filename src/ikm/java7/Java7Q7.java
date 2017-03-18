package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class Java7Q7 {
    public static void main(String[] args) {
        Integer before = new Integer(25);
        Integer check = new Integer(25);
        System.out.println("Checking whether new Integer(25) == 25");
        System.out.println(before == 25);
        System.out.println("Checking whether new Integer(25) == new Integer(25)");
        System.out.println(before == check);


        Integer after = ++before == 26? 5: new Integer(10);
        System.out.println(after.intValue() - before.intValue());
            }

}
