package codility;

/**
 * Created by mayank.gupta on 15/01/17.
 *
 *
 *
 * A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

 For example, array A such that:
 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8

 contains the following example slices:

 slice (1, 2), whose average is (2 + 2) / 2 = 2;
 slice (3, 4), whose average is (5 + 1) / 2 = 3;
 slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

 The goal is to find the starting position of a slice whose average is minimal.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

 For example, given array A such that:
 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8

 the function should return 1, as explained above.

 Assume that:

 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−10,000..10,000].

 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).


 */
public class MinAvgTwoSlice {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] prefixSum = getPrefixSum(A);
        int minAvg = Integer.MAX_VALUE;
        int minAvgIndex = A.length;
        for(int i = 2; i < A.length; i++) {
            for(int j = A.length-1; j > i; j--) {
                int avg = (prefixSum[j] - prefixSum[j - i])/(j - i);
                if (avg < minAvg) {
                    minAvg = avg;
                    minAvgIndex = (j - i) < minAvgIndex ? j-i : minAvgIndex;
                }
            }

        }
        return minAvgIndex;
    }
    public int[] getPrefixSum(int[] A) {
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for(int i = 1 ; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        return prefixSum;
    }
}

/*
* The above solution is wrong, doesnt work. Actual solution
* def solution(a)
* # write your code in Ruby 2.2]
  n = a.size
  min_avg = 10000.00
  r = 0

  (0..(n-2)).each do |i|
    if i+1 < n
      t = ( a[i].to_f + a[i+1].to_f ) / 2.to_f

      if min_avg > t
        min_avg = t
        r = i
      end
    end

    if i+2 < n
      t = ( a[i].to_f + a[i+1].to_f + a[i+2].to_f ) / 3.to_f

      if min_avg > t
        min_avg = t
        r = i
      end
    end
  end
  r
 end
* */