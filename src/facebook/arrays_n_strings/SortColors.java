package facebook.arrays_n_strings;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 14/05/17.
 *
 * Given arrays of 0s, 1s and 2s sort 0s then 1s then 2s
 */
public class SortColors {

    public void sort(int[] array) {

        int start  = 0;
        int mid = 0;
        int end = array.length -1;

        if(array.length <= 1)
            return;


        while(mid < end) {

            switch (array[mid]) {
                case 0:
                    /*Swap with start*/
                    int temp = array[mid];
                    array[mid] = array[start];
                    array[start] = temp;
                    mid += 1;
                    start += 1;
                    break;

                case 1:
                    mid += 1;
                    break;

                case 2:
                    temp = array[end];
                    array[end] = 2;
                    array[mid] = temp;
                    end -= 1;
                    break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,1,1,1,2,2,2,1,0,2,1,0,0,1,0};

        SortColors sc = new SortColors();
        sc.sort(num);
    }

}
