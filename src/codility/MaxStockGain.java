package codility;

/**
 * Created by mayank.gupta on 28/01/17.
 */
public class MaxStockGain {
    public int solution(int[] A) {
        int maxDiff = 0;
        int[] maxDiffForStockSoldOn = new int[A.length];
        for(int i = 1; i < A.length; i++) {
            maxDiff = Math.max(0, maxDiff +  A[i] - A[i-1]);
            maxDiffForStockSoldOn[i] = maxDiff;
        }

        int maxStockGain = 0;
        for(int i = 0; i < maxDiffForStockSoldOn.length; i++) {
            maxStockGain = Math.max(maxStockGain, maxDiffForStockSoldOn[i]);
        }

        return maxStockGain;
    }
}
