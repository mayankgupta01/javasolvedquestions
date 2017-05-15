package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 09/05/17.
 */
/*
contiguous subset sum == given sum

        use sliding window
*/

public class SubsetSum {

    public int[] find(int[] array, int sum) {

        //if no negative integers allowed and integers > 0 then check for 0 to return;

        int start = 0;
        int end = 0;
        int windowSum = array[0];
        boolean foundSum = false;

        while(end < array.length && start < array.length) {

            if(windowSum == sum) {
                foundSum = true;
                break;
            }

            if(windowSum < sum) {
                end++;
                windowSum = windowSum + array[end];
            }else {
                windowSum = windowSum - array[start];
                start++;
            }
        }

        if(foundSum) {
            //create new array using start and end indexes and return
        }
        return  new int[2];

    }
}
