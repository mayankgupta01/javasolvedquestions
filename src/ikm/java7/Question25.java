package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class Question25 {

//    http://stackoverflow.com/questions/817856/when-and-how-should-i-use-a-threadlocal-variable
    /*
    *
    * ThreadLocal variables are used when I don't want to syncrhonize the methods. So, instead I give each thread its own copy of
    * variable. Also, threadlocal variables can be accessed from anywhere in the method stack within the same thread. So, they dont
    * need to passed as params
    *
    *
    * Thread safety is enhanced by:
    * Use of ThreadLocal variables
    * Write classes so they are immutable
    *
    * final classes do NOT increase thread safety. final classes cannot be extended that is the only thing.
    * */
}
