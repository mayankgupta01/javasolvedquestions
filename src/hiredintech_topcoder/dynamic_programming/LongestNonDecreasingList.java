package hiredintech_topcoder.dynamic_programming;

/**
 * Created by mayank.gupta on 25/03/17.
 */
public class LongestNonDecreasingList {

    public static void main(String[] args) {
        int[] input = new int[]{-1, 1,2,2,2,3,1,2,5,-1,0,0,0,0,0,100,200,50};
        System.out.println("Max non decreasing length is : " + longestNonDecreasingList(input));
    }

    public static int longestNonDecreasingList(int[] input) {
        if(input.length <= 1) {
            return input.length;
        }

        int maxLength = 0;
        int[] maxNonDecreasingLength = new int[input.length];
        maxNonDecreasingLength[0] = 1;
        for(int i = 1 ; i < input.length; i++) {
            if(maxNonDecreasingLength[i] <= maxNonDecreasingLength[i - 1] && input[i] >= input[i - 1]) {
                maxNonDecreasingLength[i] = maxNonDecreasingLength[i - 1] + 1;

            }else {
                maxNonDecreasingLength[i] = 1;
            }
            maxLength = Math.max(maxLength,maxNonDecreasingLength[i]);
        }
        return maxLength;
    }
}
