package udemy.practical_ds_algo.sorting_algos;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 05/03/17.
 */
public class QuickSort {

    public static int partition(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int leftIndex = start - 1;
        int rightIndex = start;

        for (;rightIndex <= end; rightIndex++) {
            if(inputArray[rightIndex] <= pivot) {
                leftIndex++;
                int temp = inputArray[leftIndex];
                inputArray[leftIndex] = inputArray[rightIndex];
                inputArray[rightIndex] = temp;
            }
        }
        return leftIndex;
    }

    public static void sort(int[] inputArray) {
        sort(inputArray, 0 , inputArray.length - 1);
    }

    public static void sort(int[] inputArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int partitionIndex = partition(inputArray,start,end);
        sort(inputArray,start,partitionIndex-1);
        sort(inputArray,partitionIndex+1,end);
    }
}

class TestQuickSort {
    public static void main(String[] args) {
        int[] input = {0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,-1,-2};
        QuickSort.sort(input);
        System.out.println("Result is : " + Arrays.toString(input));
    }
}
