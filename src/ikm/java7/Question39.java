package ikm.java7;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question39 {

    public static void main(String[] args) {
        /*
        * LinkedHashSet maintains insertion order and uniqueness
        * */
        Set<String> set = new LinkedHashSet<String>();
        set.add("3");
        set.add("1");
        set.add("3");
        set.add("2");
        set.add("3");
        set.add("1");

        for(String str : set) {
            System.out.println(str + "-"); // 3-1-2-
        }
    }
}
