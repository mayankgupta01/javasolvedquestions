package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 * http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */

//How would you implement a singleton pattern? lazy load

public class SingletonExample {

    private static SingletonExample singletonObj = null;

    private SingletonExample() {

        //Steps to construct the object
    }

    //This may have params in case we need some params to construct the object
    public static SingletonExample getInstanceRaw() {

        if(singletonObj == null) {

            singletonObj = new SingletonExample();
        }

        return singletonObj;
    }

    // Thread safe example
    public static synchronized SingletonExample getInstance() {

        if(singletonObj == null) {
            //construct the object
        }

        return singletonObj;
    }

    //Double check singleton creation
    public static SingletonExample getInstanceDoubleCheck() {

        if(singletonObj == null) {

            synchronized(SingletonExample.class) {

                if(singletonObj == null) {
                    //construct the object
                }

            }
        }
        return singletonObj;
    }
}

//Enum singleton - gives protection against destroying singleton pattern via reflection
//http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples

enum SingletonEnumEx {

    INSTANCE;

    //methods we need to define
    public static void doSomething() {

    }

    SingletonEnumEx() {

    }
}

//Lazy loading without null check
/*
* Notice the private inner static class that contains the instance of the singleton class.
* When the singleton class is loaded, SingletonHelper class is not loaded into memory and only when someone calls the
* getInstance method, this class gets loaded and creates the Singleton class instance.
* This is the most widely used approach for Singleton class as it doesn’t require synchronization.
*
* */
class LazyLoadSingletonEx {

    private LazyLoadSingletonEx(){}

    private static class SingletonHelper {

        private static final LazyLoadSingletonEx INSTANCE = new LazyLoadSingletonEx();
    }

    public static LazyLoadSingletonEx getInstance() {
        return SingletonHelper.INSTANCE;
    }
}



