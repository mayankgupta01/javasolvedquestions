package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question12 {
    public static void main(String[] args) {
        int x = 5, y = 0;
        try {
            try{
                System.out.println(x);
                System.out.println(x/y);
                System.out.println(y);
            }catch (ArithmeticException ex) {
                System.out.println("Inner Catch 1");
                throw ex;
            }catch (RuntimeException ex) {
                System.out.println("Inner Catch 2");
                throw ex;
            }
            finally {
                System.out.println("Inner Finally");
            }
        }catch(Exception e) {
            System.out.println("Outer Catch");
        }

        /*
        *
        * Also, although it's bad practice, if there is a return statement within the finally block, it will trump any other return from the regular block. That is, the following block would return false:

            try { return true; } finally { return false; }
            Same thing with throwing exceptions from the finally block.
        *
        *public static void main(String[] args) {
            System.out.println(Test.test());
        }

        public static int test() {
            try {
                return 0;
            }
            finally {
                System.out.println("finally trumps return.");
            }
        }

        Output: finally trumps return
                0

        *
        * */
    }
}
