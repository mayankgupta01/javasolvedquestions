import java.util.Scanner;

/**
 * Created by mayank.gupta on 08/12/16.
 */
public class TestNestedClasses {

    public static void main(String[] args) {

    //  Initialize static nested class object
        NestedClasses.StaticChildClass nestedClassObj = new NestedClasses.StaticChildClass();

    //  Initialize Outer Class object
        NestedClasses outerClassObj = new NestedClasses();

    //  Initialize inner class object
        NestedClasses.InnerClass innerClassObj = outerClassObj.new InnerClass();

    //  Test access to outer class private variables and methods from inner class
    //  This access is not allowed outside of the outer class

    //  Test access to outer class private members from inside the inner class
        innerClassObj.testAccessToOuterClassMembers();

    //  Static nested class will have access to only static members of the outer class. These members can be accessed
    //  only from INSIDE the class declaration
    //  nestedClassObj.testStaticAccessToOuterClass DOES NOT WORK from TestNestedClasses
    //  EVEN WHEN testStaticAccessToOuterClass is declared public static.

    }
}
