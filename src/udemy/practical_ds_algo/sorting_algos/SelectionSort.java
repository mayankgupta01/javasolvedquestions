package udemy.practical_ds_algo.sorting_algos;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 13/02/17.
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        int minNum;
        int minIndex;
        int stepCounter = 0;
        for(int i = 0; i < array.length; i++) {
            minNum = array[i];
            minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                stepCounter++;
                if (minNum > array[j]) {
                    minNum = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = minNum;
            }
        }
        System.out.println("Total num of steps executed for array of size : " + array.length + " : " + stepCounter);
        return array;
    }
}

class TestSelectionSort {
    public static void main(String[] args) {
        int[] input = {0,20,21,21,4,5,6,7,8,90,10,11,12,13,14,15,18,20,29};
        System.out.println(Arrays.toString(SelectionSort.sort(input)));
    }
}
