package ikm.java7.Question35;

/**
 * Created by mayank.gupta on 01/01/17.
 *
 * Removing public from both the class definitions
 */
class Question35 {
    protected static int count = 0;
    public Question35() {
        count++;
    }
    static int getCount() {
        return count;
    }
}

class Child extends Question35 {
    public Child() {count++;}

    public static void main(String[] args) {
        System.out.println("Count = " + getCount());
        Child child = new Child();
        System.out.println("Count = " + getCount());
    }
}
