import udemy.masterOOdesign.ems.builder.Vehicle;

/**
 * Created by mayank.gupta on 08/06/17.
 */
public interface InterfaceJava8 {

    public void firstInterface();
    public default void print() {
        System.out.println("Java 8 default implementation");
    }
}

interface SecondInterface {

    public void secondInterface();
    public default void print() {
        System.out.println("Second interface print implementation");
    }
}

class Tester implements InterfaceJava8,SecondInterface {

    @Override
    public void firstInterface() {

    }

    @Override
    public void secondInterface() {

    }

    public  void print() {
        System.out.println("My own implementation");
        SecondInterface.super.print();
    }
}
