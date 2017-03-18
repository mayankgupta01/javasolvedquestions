package ikm.java7;

import java.util.Scanner;

/**
 * Created by mayank.gupta on 30/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class StringBuilderDemo {

    public static void main(String[] argList) {
        StringBuilder str = new StringBuilder();
        for(String arg : argList) {
            if(str.indexOf(arg) < 1)
                str.append(arg + " ");
        }
        System.out.println(str.toString());
        Scanner sc = new Scanner(str.toString());
        while(sc.hasNext()) {
            if(sc.hasNextInt())
                System.out.println(sc.nextInt() + " ");
            else
                sc.next();
        }
    }
}
