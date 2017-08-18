package grab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 25/04/17.
 */
public class MinTouristPass {

    public int minCost(int tourDurationInDays, Map<Integer,Integer> tourPasses) {

        if(tourDurationInDays == 0) {
            return 0;
        }

        if(tourDurationInDays == 1) {
            return tourPasses.get(1);
        }

        int[] minCostForDuration = new int[tourDurationInDays +1 ];


        minCostForDuration[1] = tourPasses.get(1);

        for(Map.Entry<Integer,Integer> entry : tourPasses.entrySet()) {

            for(int i = 0; i < minCostForDuration.length; i++) {

                if(minCostForDuration[i] !=0) {

                    for(int j=1; i+j < minCostForDuration.length && j <= entry.getKey(); j++) {
                        int temp = minCostForDuration[i+j];
                        if(i+j <= entry.getKey())
                            minCostForDuration[i+j] = (temp == 0) ? entry.getValue() : Math.min(temp, entry.getValue());
                        else
                            minCostForDuration[i+j] = (temp == 0) ? minCostForDuration[i] +entry.getValue() : Math.min(temp, minCostForDuration[i]+ entry.getValue());
                    }
                }
            }
        }
        System.out.println(Arrays.toString(minCostForDuration));
        return minCostForDuration[tourDurationInDays];
    }

    public static void main(String[] args) {
        Map<Integer,Integer> tourPasses = new HashMap<>();
        tourPasses.put(1,2);
        tourPasses.put(7,5);
        tourPasses.put(30,25);

        MinTouristPass min = new MinTouristPass();
        int durationInDays = 30;
        System.out.println("Min Cost of travel for " + durationInDays + " days is : " + min.minCost(durationInDays,tourPasses));
    }
}
