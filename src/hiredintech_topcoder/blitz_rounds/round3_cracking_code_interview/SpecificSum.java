package hiredintech_topcoder.blitz_rounds.round3_cracking_code_interview;

/**
 * Created by mayank.gupta on 27/04/17.
 *
 * 17.12 Cracking the coding interview, edition 5th
 *
 */
public class SpecificSum {

    public void printSubsetsWithSum(int[] input, int sum, int maxElementsInSubset) {
        int[] subset = new int[maxElementsInSubset];
        printSubsetWithSum(input,sum,0,subset,0);
    }

    private void printSubsetWithSum(int[] input, int sum, int inputIndex, int[] subset, int subsetIndex) {

        /*Base condition*/
        if(sum == 0) {
            for(int i = 0; i < subset.length; i++) {
                System.out.print(subset[i] + ", ");
            }
            System.out.println();
            return;
        }

        if(subsetIndex >= subset.length || inputIndex >= input.length)
            return;

        subset[subsetIndex] = input[inputIndex];
        printSubsetWithSum(input,sum - input[inputIndex],inputIndex+1,subset,subsetIndex+1);
        printSubsetWithSum(input,sum,inputIndex+1,subset,subsetIndex);
        subset[subsetIndex] = 0;

    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,7,8,10};
        int sum = 8;

        SpecificSum ss = new SpecificSum();
        ss.printSubsetsWithSum(input,sum,2);
    }
}
