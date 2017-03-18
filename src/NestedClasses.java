/**
 * Created by mayank.gupta on 08/12/16.
 */
public class NestedClasses {

    private static String testStaticAccessToOuterClass = "Static Mayank";
    private String testAccessToOuterClass = "Mayank";

    private void outerClassMethod() {
        System.out.println("Inside outer class, Variable value : " + testAccessToOuterClass);
    }

    static class StaticChildClass {
        public void childMethod() {
            System.out.println("Inside static child class method");
            System.out.println("Testing access to outer class private static variable.... Value is : " + testStaticAccessToOuterClass);
        }
    }

    class InnerClass {
        public void innerClassMethod() {
            System.out.println("Inside inner class method");
        }

        public void testAccessToOuterClassMembers() {
            System.out.println("Outer class private variable accessible, value : " + testAccessToOuterClass);
            System.out.println("Invoking private method of outer class : ");
            outerClassMethod();
            System.out.println("Outer class private method invoked successfully");
        }
    }
}
