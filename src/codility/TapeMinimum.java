package codility;

/**
 * Created by mayank.gupta on 15/01/17.
 *
 * A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

 Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

 The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

 In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

 For example, consider array A such that:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3

 We can split this tape in four places:

 P = 1, difference = |3 − 10| = 7
 P = 2, difference = |4 − 9| = 5
 P = 3, difference = |6 − 7| = 1
 P = 4, difference = |10 − 3| = 7

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

 For example, given:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3

 the function should return 1, as explained above.

 Assume that:

 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−1,000..1,000].


 */
public class TapeMinimum {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long tape1Sum = 0;
        long tape2Sum = 0;
        long minTapeDiff = 0;
        long currentDiff = 0;
        long totalSum = 0;
        for(int a : A) {
            totalSum = totalSum + a;
        }
        tape2Sum = totalSum;
        for(int i = 0 ; i < A.length - 1; i++) {
            tape1Sum = tape1Sum + A[i];
            tape2Sum = tape2Sum - A[i];
            currentDiff = Math.abs(tape1Sum - tape2Sum);
            if (minTapeDiff > currentDiff || i == 0)
                minTapeDiff = currentDiff;

        }
        return  (int) minTapeDiff;
    }
}
