package ikm.java7;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question29 {

    public static void main(String[] args) {
        String str1 = "My String";
        String str2 = new String("My String");

        /*
        * hashcode of two objects is equal when equals value is same for two objects. However, hashcode can also be equal
        * even when equals is not same.
        * */
        System.out.println(str1.hashCode() == str2.hashCode()); // true
        System.out.println(str1.matches(str2)); // true
//        System.out.println(String.parse(str1) == str2); //compile error
        /*
        * equals compares whatever is overriden in the equals method. In case class does not override, then it will take
        * the implementation of the nearest parent which has overriden equals. In case none is found, then equals method
        * Object class is used. This is same as ==, that both objects refer to the same location in memory.
        *
        * For String, equals method compares the value of both strings and not the memory location. == compares the object
        * reference or memory location of two strings
        *
        *
        * String str1 = "Hello"   This creates a string literal in the string constant pool, any string created this way
        * points to the same object in the pool
        *
        * String str2 = new String("Hello") creates a String object in the heap, this will be created new every time.
        * */
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str2); // false
    }
}
