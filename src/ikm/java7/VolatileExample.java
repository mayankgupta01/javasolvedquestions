package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class VolatileExample {
    /**
     * Java program to demonstrate where to use Volatile keyword in Java.
     * In this example Singleton Instance is declared as volatile variable to ensure
     * every thread see updated value for _instance.
     *
     * @author Javin Paul
     */

        private static volatile VolatileExample _instance; //volatile variable

        public static VolatileExample getInstance(){

            if(_instance == null){
                synchronized(VolatileExample.class){
                    if(_instance == null)
                        _instance = new VolatileExample();
                }

            }
            return _instance;

        }

//        If you look at the code carefully you will be able to figure out:
//                1) We are only creating instance one time
//        2) We are creating instance lazily at the time of the first request comes.
//
//        Read more: http://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz4UOshRZwj
//      If we do not make the _instance variable volatile than the Thread which is creating instance of Singleton is not
//      able to communicate other thread, that instance has been created until it comes out of the Singleton block,
//      so if Thread A is creating Singleton instance and just after creation lost the CPU, all other thread will not
//      be able to see value of _instance as not null and they will believe its still null.
//
//    Read more: http://javarevisited.blogspot.com/2011/06/volatile-keyword-java-example-tutorial.html#ixzz4UOsvZcsr
}
