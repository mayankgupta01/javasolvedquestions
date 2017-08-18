package grab;

/**
 * Created by mayank.gupta on 24/05/17.
 */
public class TestStrings {

    static class Nested {

        private int number;
        private String name;
    }

    public static void main(String[] args) {

        String s2 = new String("abc");
        String s1 = "abc";

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Nested nested = new Nested();
        nested.name = "Abd";
        nested.number = 1235;

        System.out.println(nested.name);
    }
}
