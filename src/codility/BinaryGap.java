package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mayank.gupta on 14/01/17.
 *
 *
 * Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

 For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 */

public class BinaryGap {

    public int solution(int N) {
        List<Integer> positionOfOnesInBinaryOfInt = new ArrayList<>();
        int binaryGap = 0;
        char[] binaryOfInt = Integer.toBinaryString(N).toCharArray();
        System.out.println(Arrays.toString(binaryOfInt));
        for(int i = 0; i < binaryOfInt.length; i++) {
            if(binaryOfInt[i] == '1') {
                positionOfOnesInBinaryOfInt.add(i);
            }
        }
        for(int i=0; i < positionOfOnesInBinaryOfInt.size() - 1; i++) {
            int gap = positionOfOnesInBinaryOfInt.get(i+1) - positionOfOnesInBinaryOfInt.get(i) - 1;
            if(gap > binaryGap) {
                binaryGap = gap;
            }
        }
        return binaryGap;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        System.out.println(bg.solution(1345));
    }
}
