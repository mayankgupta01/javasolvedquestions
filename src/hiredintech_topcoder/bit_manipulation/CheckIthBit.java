package hiredintech_topcoder.bit_manipulation;

/**
 * Created by mayank.gupta on 24/04/17.
 * https://www.hackerearth.com/practice/notes/bit-manipulation/
 */
public class CheckIthBit {

    public boolean checkBitIsOne(int i, int number) {
        if(number == 0)
            return false;

        if((number & (1 << i)) == (1 << i))
            return true;

        return false;
    }

    public static void main(String[] args) {
        int x = 100;

        int i = 0;

        CheckIthBit c = new CheckIthBit();

        System.out.println("binary of " + x + " : " + Integer.toBinaryString(x));
        System.out.println(i + "th bit is 1? " + c.checkBitIsOne(i,x));
    }
}
