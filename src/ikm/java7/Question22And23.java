package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question22And23 {

    /*
    * Command to create jar file with main class in manifest : jar -cvfe HelloWorld.jar HelloWorld HelloWorld.class
    * jar -e for entry point and entry point or main class name should come after jar file name and before directory or file needs to be included in JAR.
    *
    * You can now run your executable jar file by issuing "java -jar" command as shown in following example:
    *
    * javin@localhost:~/Java java -jar HelloWorld.jar
      Read more: http://javarevisited.blogspot.com/2012/03/how-to-create-and-execute-jar-file-in.html#ixzz4UQ0wDbvZ
    *Command to extract from jar : jar -xvf hellp.jar
    * */



    public static void main(String[] args) {
        int[] abc = new int[10];
        System.out.println(abc[9]);
        System.out.println(abc.length);
    }

    /*Question 24
    * use java -classpath .;c:/ikmutils/lib/* com.ikmtest.ClasspathTester
    *
    * not sure if it will work without *
    *
    *
    *
    *
    *
    * */
}
