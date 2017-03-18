package udemy.practical_ds_algo.sorting_algos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mayank.gupta on 13/02/17.
 */
public class MergeSort {

    public static int[] merge(int[] partOne, int[] partTwo) {
        int partOneSize = partOne.length;
        int partTwoSize = partTwo.length;
        ArrayList<Integer> sortedResult = new ArrayList<>();
        int partTwoSortedCounter = 0;
        for(int i = 0; i < partOneSize; i++) {
            for(int j = partTwoSortedCounter; j < partTwoSize; j++) {
                if (partOne[i] <= partTwo[j]) {
                    sortedResult.add(partOne[i]);
                    break;
                } else {
                    sortedResult.add(partTwo[j]);
                    partTwoSortedCounter++;
                }
            }
            if (partTwoSortedCounter == partTwoSize) {
                sortedResult.add(partOne[i]);
            }
        }
        if(partTwoSortedCounter < partTwoSize) {
            for(int j = partTwoSortedCounter; j < partTwoSize; j++) {
                sortedResult.add(partTwo[j]);
            }
        }
        int[] result = sortedResult.stream().mapToInt(i -> i).toArray();
//        System.out.println("Merge result : " + Arrays.toString(result));
        return result;
    }

    public static int[] mergeSort(int[] inputArray) {
        int mid;
        if(inputArray.length <= 1) {
            return inputArray;
        }
        if (inputArray.length%2 == 0) {
            mid = inputArray.length/2;
        }else {
            mid = (inputArray.length+1)/2;
        }
        int[] partOne = mergeSort(Arrays.copyOfRange(inputArray,0,mid));
        int[] partTwo = mergeSort(Arrays.copyOfRange(inputArray,mid,inputArray.length));
        return merge(partOne,partTwo);
    }

//    textbook solution using indices rather than actual split arrays
    public static void mergeUsingIndex(int[] inputArray, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int tempArraySlot = 0;
        int leftSlot = start;
        int rightSlot = mid+1;
        while(leftSlot <= mid && rightSlot <= end) {
            if(inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[tempArraySlot] = inputArray[leftSlot];
                leftSlot++;
            }else {
                tempArray[tempArraySlot] = inputArray[rightSlot];
                rightSlot++;
            }
            tempArraySlot++;
        }
        while(leftSlot <= mid) {
            tempArray[tempArraySlot] = inputArray[leftSlot];
            leftSlot++;
            tempArraySlot++;
        }
        while(rightSlot <= end) {
            tempArray[tempArraySlot] = inputArray[rightSlot];
            rightSlot++;
            tempArraySlot++;
        }
        for (int i=0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
        System.out.println("Merge result : " + Arrays.toString(inputArray));
    }

    public static void sort(int[] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    public static void sort(int[] inputArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end)/2;
        /*sort the left side*/
        sort(inputArray,start,mid);
        /*sort the right side*/
        sort(inputArray,mid+1,end);
        mergeUsingIndex(inputArray,start,mid,end);
    }
}

class TestMergeSort {
    public static void main(String[] args) {
        int[] input = {0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29};
//        int[] input = {0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29,0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29};
//        System.out.println(Arrays.toString(MergeSort.mergeSort(input)));

        MergeSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
}