package ikm.java7;

import java.io.*;

/**
 * Created by mayank.gupta on 01/01/17.
 *
 * http://stackoverflow.com/questions/7151711/java-why-doesnt-deserialization-invoke-constructor-whats-the-best-workaroun
 *
 * http://stackoverflow.com/questions/8141440/how-are-constructors-called-during-serialization-and-deserialization
 *
 *
 * The only requirement on the constructor for a class that implements Serializable is that the first non-serializable
 * superclass in its inheritence hierarchy must have a no-argument constructor.
 *
 *
 *
 * For serializable objects, the no-arg constructor for the first non-serializable supertype is run. For serializable
 * classes, the fields are initialized to the default value appropriate for its type.
 * Then the fields of each class are restored by calling class-specific readObject methods,
 * or if these are not defined, by calling the defaultReadObject method.
 * Note that field initializers and constructors are not executed for serializable classes during deserialization.
 *
 *
 *
 * Deserialization doesn't invoke the constructor because the purpose of it is to express the state of the object
 * as it was serialized, running constructor code could interfere with that.
 *
 *
 *  the standard way of working around problems with the default behavior is to provide your own readObject()
 *  or writeObject() implementations for your class.
 */
public class Question50 {
    public Question50() {
        System.out.println("File");
    }

    public static void main(String[] args) throws Exception {
        Ikm obj = new Ikm("XYZ");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/mayank.gupta/Desktop/Data.txt");
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        os.writeObject(obj);
        os.close();

        FileInputStream fileInputStream = new FileInputStream("/Users/mayank.gupta/Desktop/Data.txt");
        ObjectInputStream is = new ObjectInputStream(fileInputStream);
        Ikm newObj = (Ikm) is.readObject();
        System.out.println(newObj.getName());
    }
}

class Ikm extends Question50 implements Serializable{
    private String name;

    Ikm(String name) {
        this.name = name;
        System.out.println("Test");
    }

    public String getName(){return name;}
}
