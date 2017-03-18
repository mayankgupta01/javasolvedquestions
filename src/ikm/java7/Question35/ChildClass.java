package ikm.java7.Question35;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class ChildClass extends Parent {
    public ChildClass() {count++;}

//    public int count = 0; // you can declare same name variable in child class. When you do so, will need to change
//    the constructor to Parent.count, or else it will assume childclass count variable

    public static void main(String[] args) {
        System.out.println("Count = " + getCount());
        ChildClass child = new ChildClass();
        System.out.println("Count = " + getCount());
    }
}
