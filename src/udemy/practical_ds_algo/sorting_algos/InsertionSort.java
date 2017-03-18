package udemy.practical_ds_algo.sorting_algos;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 13/02/17.
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return  array;
    }
}

class TestInsertionSort {
    public static void main(String[] args) {
        int[] input = {0,11,22,11,4,5,60,7,8,9,100,11,12,13,14,15,115,15,16,17,17,8,20,29};
        System.out.println(Arrays.toString(InsertionSort.sort(input)));
    }
}
