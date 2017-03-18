package codility;

/**
 * Created by mayank.gupta on 15/01/17.
 *
 *

 Write a function:

 class Solution { public int solution(int A, int B, int K); }

 that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

 { i : A ≤ i ≤ B, i mod K = 0 }

 For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

 Assume that:

 A and B are integers within the range [0..2,000,000,000];
 K is an integer within the range [1..2,000,000,000];
 A ≤ B.

 Complexity:

 expected worst-case time complexity is O(1);
 expected worst-case space complexity is O(1).


 */
public class CountDiv {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        boolean isAdivisible = (A % K == 0);
        if (A == B || (B - A) < K)
            return isAdivisible ? 1 : 0;

        if (K == 1)
            return B - A + 1;

        int count = (B - A)/K;
        return isAdivisible || A < K ? count + 1 : count;

    }

}


/*
* Using Prefix sums :
* (A-1)/K is the sum of all the occurrences of the numbers <=(A-1) that are divisible by K.
B/K is the sum of all the occurrences of the numbers <= B that are divisible by K.
To know the sum of all the occurrences of the numbers between A and B that are divisible by K, just subtract (A-1)/K to B/K.
And remember that 0 is divisible by any non-zero number.
*
* */
