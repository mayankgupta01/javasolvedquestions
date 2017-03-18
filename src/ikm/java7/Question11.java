package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question11 {
    public Question11() {this(10);}
    public Question11(int data){this.data = data;}

    public void display() {
//        called a local class, this could be an abstract class as well with another class defined
//            here itself extending. Defining an interface here is not allowed. This is used if only one method needs to
//            access or use a class. Also, if you have multiple anonymous classes in a method, such as for Runnable, its
//            to define classes of them.
//        Local class : Anonymous classes are given a name by the compiler and they are treated as local inner classes.
//            This means that anonymous classes can access members of the enclosing class regardless of their access modifiers and they can access final variables declared in the enclosing block of code.
//            See reference : http://stackoverflow.com/questions/2428186/use-of-class-definitions-inside-a-method-in-java
        class Decrementer {
            public void decrement() {
                data--;
            }
        }
        Decrementer decrementer = new Decrementer();
        decrementer.decrement();
        System.out.println("data = " + data);
    }

    private int data;
    public static void main(String[] args) {
        int data = 0;
        Question11 q11 = new Question11();
        q11.display();
        System.out.println("data = " + data);
    }
}
