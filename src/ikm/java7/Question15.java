package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
//    Declaring another class in some other class file is okay if we do NOT declare it as public. If class A is declared public
//    it will throw compilation error, saying that a public class should be declared in a separate file A.java
class A{
    public void m1(){
        System.out.println("m1");
    }
    protected  void m2(){
        System.out.println("m2");
    }
    private void m3() {
        System.out.println("m3");
    }
    void m4() {
        System.out.println("m4");
    }
}



public class Question15 {

    public static void main(String[] args) {
        A a = new A();
        a.m1();
        a.m2();
//        a.m3();
        a.m4();
    }
}
