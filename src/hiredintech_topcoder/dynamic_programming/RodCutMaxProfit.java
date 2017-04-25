package hiredintech_topcoder.dynamic_programming;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 25/03/17.
 */
public class RodCutMaxProfit {
    public static int maxProfit(int[] prices, int rodLength) {
        int[] maxProfitForLength = new int[rodLength + 1];
        Arrays.fill(maxProfitForLength, -1);
        maxProfitForLength[0] = 0;

        for(int i = 1 ; i < prices.length; i++) {
            if(prices[i] != 0 && i <= rodLength) {
                for(int j = 0; i+ j < maxProfitForLength.length; j++) {
                    if(maxProfitForLength[j] != -1 && maxProfitForLength[j + i] < maxProfitForLength[j] + prices[i]) {
                        maxProfitForLength[i + j] = maxProfitForLength[j] + prices[i];
                    }
                }
            }
        }

        for(int i = maxProfitForLength.length - 1; i >=0; i--) {
            if(maxProfitForLength[i] != -1)
                return maxProfitForLength[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{0,2,5,0,12,13};
        int rodLength = 4;
        int maxProfit = maxProfit(prices,rodLength);
        System.out.println("Max Profit for length " + rodLength + " is : " + maxProfit);
    }
}


