package codility;


import java.util.Arrays;



/**
 * Created by mayank.gupta on 28/01/17.
 */
public class DoubleSlice {
    public int solution(int[] A) {
        int[] movingSum = calculateMovingSum(A);

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int minValueIndex = 0;
        int firstSliceIndex = -1;
        int maxdoubleSliceSum = 0;
        for (int i = 1; i < movingSum.length; i++) {
            if(movingSum[i] > 0 && firstSliceIndex == -1) {
                firstSliceIndex = i -1;

            }

            else {
                if (minValue > movingSum[i]) {
                    minValue =  movingSum[i];
                    minValueIndex = i;
                }
                maxValue = maxValue < movingSum[i] ? movingSum[i] : maxValue;
            }

        }

        int rightSlice = maxValue - movingSum[minValueIndex];
        int leftSlice = minValueIndex == 1 ? 0 : movingSum[minValueIndex - 1] - movingSum[firstSliceIndex];
        maxdoubleSliceSum = rightSlice + leftSlice;

        return maxdoubleSliceSum > 0 ? maxdoubleSliceSum : 0;
    }

    public int[] calculateMovingSum(int[] A) {
        int sum = 0;
        int[] movingSum = new int[A.length - 1];
        for(int i = 1; i < A.length -1; i++) {
            sum = sum + A[i];
            movingSum[i] = sum ;
        }
        System.out.println(Arrays.toString(movingSum));
        return movingSum;
    }

}

// test - [3, 2, 6, -1, 4, 5, -1, 2] answer = 17
// moving sum - [0, 2, 8, 7, 11, 16, 15]