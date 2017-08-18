package grab;

/**
 * Created by mayank.gupta on 29/04/17.
 */
public class FlipIthBitInteger {

    public static int flip(int number, int position) {

        /*Approach 1 : find out if ith bit is 1 or 0, do & with (1 << i), if 0 then ith bit is 0, to flip 0 to 1, do OR with 1 << i,
         *
         * if ith bit is 1, then do XOR with 1 << i
          *
          *
          * Basically, directly XOR with 1 << i, ith bit will flip
          * */


        return number ^ (1 << position);

    }

    public static void main(String[] args) {
        int number = 100;
        int i = 2;
        System.out.println("Binary of " + number + " : " + Integer.toBinaryString(number));

        System.out.println("After swithching off bit index " + i + " : " + Integer.toBinaryString(flip(number,i)));
    }
}
