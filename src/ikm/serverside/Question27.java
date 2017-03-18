package ikm.serverside;

/**
 * Created by mayank.gupta on 06/01/17.
 */

class SuperClass {
    SuperClass() {
        this(0);
        System.out.println("1");
    }
    SuperClass(int x) {
        System.out.printf("2" + x);
    }
}
public class Question27 extends SuperClass {

    Question27(int x) {
        System.out.println("3" +x);
    }

    Question27(int x, int y) {
        this(x);
        System.out.printf("4" +x +y);
    }
    public static void main(String[] args) {
        new Question27(2, 3);
    }
}
