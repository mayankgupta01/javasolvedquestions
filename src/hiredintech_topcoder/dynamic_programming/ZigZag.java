package hiredintech_topcoder.dynamic_programming;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class ZigZag {

    public int longestSubsequence(int[] input) {

        int length = input.length;

        if(length <=2) {
            return input.length;
        }

        int[] maxUp = new int[length];
        int[] maxDown = new int[length];
        int[] maxZigZag = new int[length];

        maxUp[0] = maxDown[0] = maxZigZag[0] = 1;


        /*Construct max increasing and max decreasing subsequences ending at i*/

        for(int i=1; i<length; i++) {

            /* Initialize with 1, counting only the actual element at ith index */
            maxUp[i] = 1;
            maxDown[i] = 1;

            for(int j=0; j<i; j++) {

                if(input[i] > input[j])
                    maxUp[i] = Math.max(maxUp[i], maxDown[j] + 1);

                if(input[i] < input[j])
                    maxDown[i] = Math.max(maxDown[i],maxUp[j] + 1);
            }
            maxZigZag[i] = Math.max(maxDown[i], maxUp[i]);
        }


        /*Traverse zig zag to find the max*/
        int max = 0;

        for(int i =0; i < length; i++) {
            max = Math.max(max,maxZigZag[i]);
        }

        return max;

    }


    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,1,3};

        ZigZag z = new ZigZag();
        System.out.println(z.longestSubsequence(input));
    }
}
