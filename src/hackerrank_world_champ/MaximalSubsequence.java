package hackerrank_world_champ;

/**
 * Created by mayank.gupta on 28/04/17.
 */

import apple.laf.JRSUIUtils;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class MaximalSubsequence {

    static long[] solve(int n, int k, long[] a){
        // Complete this function

        long[] result = new long[2];

        /*Validations here*/
        if(k == n) {
            long x = a[0];
            for(int i =1; i < a.length; i++) {
                x = x & a[i];
            }
            result[0] = x;
            result[1] = 1;
            return result;
        }

        result = findAllSubsetsOfLength(a,k);


        return result;

    }

    public static long[] findAllSubsetsOfLength(long[] s, int length) {



        long[] result = new long[2];
        long maxAnd = Long.MIN_VALUE;
        long count = 0;


        Set<String> maxSubset = new TreeSet<>();


        for(int i = 0; i < (1 << s.length); i++) {
            if(countOfOnes(i,length)) {

                long[] subset = new long[length];
                long x = (1 << 63) -1 ;
                int index = 0;

                for(int j=0; j < s.length; j++) {
                    if((i & (1 << j)) != 0) {
                        subset[index] = s[j];
                        x = x & s[j];
                        index = index+1;
                    }
                }
                if(maxSubset.isEmpty()) {
                    maxSubset.add(Arrays.toString(subset));
                }
                if(maxAnd == x && !isSubsetPresent(maxSubset,subset)) {
                    count = ((count+1) %((long)Math.pow(10,9) + 7));
                    maxSubset.add(Arrays.toString(subset));
                }
                if(maxAnd < x) {
                    count = 1;
                    maxAnd = x;
                    maxSubset.clear();
                    maxSubset.add(Arrays.toString(subset));
                }
            }
        }

        result[0] = maxAnd;
        result[1] = count;
        return result;
    }


    private static boolean isSubsetPresent(Set<String> subsets, long[] subset) {

        String s = Arrays.toString(subset);

        if(subsets.contains(s)) {
            return true;
        }
        HashSet<Long> checkIfDuplicate = new HashSet<>();

        for(String str : subsets) {
            long[] arr = Arrays.stream(str.substring(1, str.length()-1).split(",")) .map(String::trim).mapToLong(Integer::parseInt).toArray();
            checkIfDuplicate.clear();
            for(int i = 0; i < arr.length; i++) {
                checkIfDuplicate.add(arr[i]);
            }
            for(int i =0; i < subset.length; i++) {
                if(!checkIfDuplicate.contains(subset[i]))
                    return false;
            }
        }

        return true;
    }


    private static boolean countOfOnes(long i, int cnt) {
        int count = 0;

        while(i != 0) {
            i = i & (i-1);
            count++;
        }

        return count == cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int k = in.nextInt();
        long[] n = new long[num];
        for(int n_i=0; n_i < num; n_i++){
            n[n_i] = in.nextLong();
        }




        long[] result = solve(num, k, n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != num - 1 ? "\n" : ""));
        }
        System.out.println("");
/*

        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{2,3,1};

        System.out.println(Arrays.equals(arr1,arr2
        ));
*/


    }
}
