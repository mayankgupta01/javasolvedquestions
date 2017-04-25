package hiredintech_topcoder.bit_manipulation;

/**
 * Created by mayank.gupta on 24/04/17.
 * https://www.hackerearth.com/practice/notes/bit-manipulation/
 */
public class CheckPowerOfTwo {

    public boolean isPowerOfTwo(int x) {
        if(x == 0)
            return  true;

        return (x & (x-1)) == 0;
    }

    public static void main(String[] args) {
        CheckPowerOfTwo cp = new CheckPowerOfTwo();
        int x = 1024;
        System.out.println("Is " + x + " a power of 2? " + cp.isPowerOfTwo(x));
    }
}
