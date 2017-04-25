package hiredintech_topcoder.bit_manipulation;

/**
 * Created by mayank.gupta on 24/04/17.
 * https://www.hackerearth.com/practice/notes/bit-manipulation/
 */
public class CountOnes {

    public int countBinaryOnes(int x) {
        String s = Integer.toBinaryString(x);
        System.out.println("Binary of " + x + " : " + s);
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '1')
                count++;
        }
        return count;
    }

    public int countOnesUsingBits(int x) {
        int count = 0;

        while(x != 0) {
            x = x & (x-1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountOnes c = new CountOnes();
        int x = 1023;
        System.out.println("Num of Ones in " + x + " : " + c.countBinaryOnes(x));
        System.out.println("Num of Ones in " + x + " : " + c.countOnesUsingBits(x));

    }
}
