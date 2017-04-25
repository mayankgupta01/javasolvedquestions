package hiredintech_topcoder.blitz_rounds.round1;

/**
 * Created by mayank.gupta on 23/04/17.
 * Problem : https://community.topcoder.com/stat?c=problem_statement&pm=12697
 * Solution: https://apps.topcoder.com/wiki/display/tc/SRM+585
 */
public class TrafficCongestionDivTwo {

    long[] minCars;

   public long theMinCars(int treeHeight) {

       minCars = new long[treeHeight +1];
       return minCarsRecursive(treeHeight);
       /*
       //Iterative solution

       minCars[0] = minCars[1] = 1;

       for(int i = 2; i <= treeHeight; i++) {
           minCars[i] = 1;
           for(int j = 0; j <= i - 2; j++) {
               minCars[i] = minCars[i] + 2*minCars[j];
           }
       }

       return minCars[treeHeight];
       */
   }

    /*recursive solution with DP memoization*/
    public long minCarsRecursive(int treeHeight) {

        if(treeHeight == 0 || treeHeight == 1) {
            return 1;
        }

        if(minCars[treeHeight] != 0) {
            return minCars[treeHeight];
        }

        minCars[treeHeight] = 1;
        for(int i = treeHeight - 2; i >= 0; i--) {
            minCars[treeHeight] = minCars[treeHeight] + 2*minCarsRecursive(i);
        }

        return minCars[treeHeight];
    }



    public static void main(String[] args) {
        TrafficCongestionDivTwo cars = new TrafficCongestionDivTwo();
        System.out.println(cars.theMinCars(60));
    }
}