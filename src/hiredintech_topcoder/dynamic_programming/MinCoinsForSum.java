package hiredintech_topcoder.dp.dynamic_programming;

/**
 * Created by mayank.gupta on 25/03/17.
 */
public class MinCoinsForSum {
    int[] minCoinsForSum;
    int[] listOfCoins;

    public MinCoinsForSum(int[] listOfCoins) {
        this.listOfCoins = listOfCoins;
    }

    public int minimumCoinsRequiredForSum(int sum) {
        if(sum <= 0)
            return 0;

        this.minCoinsForSum = new int[sum+1];
        for(int coin : listOfCoins) {
            for(int subsetSum = 0; subsetSum + coin <= sum; subsetSum++) {
                if(minCoinsForSum[subsetSum] != 0 || subsetSum == 0) {
                    if(minCoinsForSum[subsetSum + coin] == 0 || minCoinsForSum[subsetSum + coin] > minCoinsForSum[subsetSum] + 1) {
                        minCoinsForSum[subsetSum + coin] = minCoinsForSum[subsetSum] + 1;
                  }
                }
            }
        }
        return minCoinsForSum[sum];
    }
}

class TestMinCoinsForSum {
    public static void main(String[] args) {
        MinCoinsForSum mc = new MinCoinsForSum(new int[]{3,6,7});
        System.out.println(mc.minimumCoinsRequiredForSum(11));
    }
}
