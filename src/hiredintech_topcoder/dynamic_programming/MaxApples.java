package hiredintech_topcoder.dynamic_programming;

/**
 * Created by mayank.gupta on 08/04/17.
 */
public class MaxApples {

    public static int maxApples(int[][] appleMatrix) {
        int[][] maxAtPosition = new int[appleMatrix.length][appleMatrix[0].length];
//        maxAtPosition[0][0] = appleMatrix[0][0];
        int result = 0;

        for(int i = 0; i < appleMatrix.length; i++) {
            for(int j = 0; j < appleMatrix[0].length; j++) {
                int maxAtPositionUp = (i == 0) ? 0 : maxAtPosition[i - 1][j];
                int maxAtPositionLeft = (j == 0) ? 0 : maxAtPosition[i][j - 1];
                maxAtPosition[i][j] = (i == 0 && j == 0) ? appleMatrix[0][0] : Math.max(maxAtPositionLeft + appleMatrix[i][j], maxAtPositionUp + appleMatrix[i][j]);
                result = Math.max(result,maxAtPosition[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] apples = new int[][]{{10,20,5},{5,20,50}};
        int result = maxApples(apples);
        System.out.println("Max apples collected are : " + result);
    }
}
