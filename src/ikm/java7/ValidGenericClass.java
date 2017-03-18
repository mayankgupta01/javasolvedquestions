package ikm.java7;

/**
 * Created by mayank.gupta on 30/12/16.
 * http://betterwebapp.blogspot.in/2015/11/test-java-7-programming-java-se-7.html
 */
public class ValidGenericClass<T> {

//    private <T extends Object> accountType; # Wrong statement, only classes and methods can be declared generic
//    public void add(<T extends Object> newType) {} # Generic methods, type declaration should be done before return type,
//                                                      not in method params

    private T accountType;
    public void add(T newType){}; // When class is declared generic, then methods need not define the generic again.
    public T get() {return accountType;}
}


//public class AttemptGenericDeclarationWithNormalClass {
//    public <T> accountType; // Cannot declare variables as generic using <>
//    public <T extends Object> void add(T newType){};  // This is correct generic method declaraion when class is not generic
//}