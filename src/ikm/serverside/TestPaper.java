package ikm.serverside;

import java.io.DataInput;
import java.io.FilterReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * Created by mayank.gupta on 06/01/17.
 */

class A {

    static int total = 10;

    public void call() {
        int total = 5;
        System.out.println(this.total);
    }
    public static void main(String[] args) {
        A a1 = new A();
        a1.call();
    }
}
//public class TestPaper<T> extends  A{
//    TestPaper(int a) {};
//    TestPaper(int a, int b){
//        super(a,b);
//    }
//
//    List<T> abc;
//
//    public List<T> getCollection() {
//        return this.abc;
//    }
//    public static void main(String[] args) {
//
//    }
//
//    public void testCollection(TestPaper<?> abc) {
//        List<?> set = abc.getCollection();
//    }
//}
