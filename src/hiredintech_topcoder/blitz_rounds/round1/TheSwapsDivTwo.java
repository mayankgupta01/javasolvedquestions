package hiredintech_topcoder.blitz_rounds.round1;

import java.util.*;

/**
 * Created by mayank.gupta on 22/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=12499
 */
public class TheSwapsDivTwo {

    public int find(int[] sequence) {

        List<int[]> resultSet = new ArrayList<>();

        for(int i = 0; i < sequence.length; i++) {
            for(int j = i+1; j < sequence.length; j++) {
                int[] swappedArray = swap(i, j, sequence);
                if(!checkDuplicate(swappedArray,resultSet))
                    resultSet.add(swappedArray);
            }
        }

        return resultSet.size();
    }

    private int[] swap(int index1, int index2, int[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = array[i];
            if(i == index1)
                result[i] = array[index2];
            if(i == index2)
                result[i] = array[index1];

        }
        return result;
    }

    private boolean checkDuplicate(int[] a, List<int[]> resultSet) {
        for(int[] result : resultSet) {
            if (Arrays.equals(a,result))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TheSwapsDivTwo swapTwo = new TheSwapsDivTwo();
        int[] seq = new int[]{22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37};
        System.out.println(swapTwo.find(seq));
    }
}
