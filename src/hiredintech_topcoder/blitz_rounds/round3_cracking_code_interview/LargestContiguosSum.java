package hiredintech_topcoder.blitz_rounds.round3_cracking_code_interview;

/**
 * Created by mayank.gupta on 27/04/17.
 *
 * 17.8 Cracking the coding interview - 5th edition
 */
public class LargestContiguosSum {

    public int compute(int[] input) {
        /*DP approach, max sum ending at ith index is , max of Max(Max(i-1) + a[i], a[i]), take a max of all of these */

        int[] maxSum = new int[input.length];
        int maxIndex = 0;
        int maxSumResult = 0;

        maxSum[0] = input[0];

        for(int i=1; i < input.length; i++) {
            maxSum[i] = Math.max(maxSum[i-1] + input[i],input[i]);
            if(maxSumResult < maxSum[i]) {
                maxSumResult = maxSum[i];
                maxIndex = i;
            }
        }

        return maxSumResult;
    }

    public int computeViaSubsets(int[] input) {
        /*Approach is to find out all subsets of the array, and compare the sum. We can do this by iteration from 0 -> 2^N
        * the binary representation of each i , for every 1 we include the corresponding element in array, for 0 we don,t
        *
        * This is effective to find largest sum for non-contiguous selection. For contiguous selection we need to take in
        * only the elements where consecutive ones are present
        *
        *
        * */
        int maxResult = 0;

        for( int i = 0; i < (1 << input.length); i++) {

            int lastIndexOfOne = -1;
            int sum = 0;
            for(int j=0; j < input.length; j++) {
                if((i & (1 << j)) !=0 && (j - lastIndexOfOne == 1 || lastIndexOfOne == -1)) {
                    sum = sum + input[j];
                    lastIndexOfOne = j;
                }
            }
            maxResult = Math.max(maxResult,sum);
        }

        return maxResult;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,-8,3,-2,4,-10};

        LargestContiguosSum lg = new LargestContiguosSum();

        System.out.println(lg.compute(input));
        System.out.println(lg.computeViaSubsets(input));
    }
}
