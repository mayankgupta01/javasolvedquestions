package ikm.java7;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question10 {

    private static int count;

    static {
        System.out.println("In Block 1");
        count = 10;
    }

    private int[] data;
    {
        System.out.println("In Block 2");
        data = new int[count];
        for(int i = 0; i < count; i++) {
            data[i] = i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Count = " + count);
        System.out.println("Before 1st call to new");
        Question10 q10 = new Question10();
        System.out.println("Before 2nd call to new");
        Question10 q10new = new Question10();
    }
}
