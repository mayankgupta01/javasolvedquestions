package codility;

/**
 * Created by mayank.gupta on 15/01/17.
 *
 *
 * that, given a zero-indexed array A, returns the value of the missing element.

 For example, given array A such that:
 A[0] = 2
 A[1] = 3
 A[2] = 1
 A[3] = 5

 the function should return 4, as it is the missing element.

 Assume that:

 N is an integer within the range [0..100,000];
 the elements of A are all distinct;
 each element of array A is an integer within the range [1..(N + 1)].


 */
public class MissingNumber {
    public int solution(int[] A) {
        // write your code in Java SE 8. The following solution has 60% performance. This is because for array ~100000
       //  The sum actually overflows int, on overflow it sets the value to minimum value
        int n = A.length;
        int sumIncludingMissingNumber = (n + 1) * (n + 2)/2;
        int actualSum = 0;
        for(int a : A) {
            actualSum = actualSum + a;
        }
        return sumIncludingMissingNumber - actualSum;
    }
}

/*
* The following solution is ideal.
* // write your code in Java SE 8
        long n = A.length;
        long sumIncludingMissingNumber = (n + 1) * (n + 2)/2;
        long actualSum = 0;
        for(int a : A) {
            actualSum = actualSum + a;
        }
        return (int)(sumIncludingMissingNumber - actualSum);
* */
