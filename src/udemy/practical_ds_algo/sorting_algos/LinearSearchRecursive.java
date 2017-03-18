package udemy.practical_ds_algo.sorting_algos;

/**
 * Created by mayank.gupta on 13/02/17.
 */
public class LinearSearchRecursive {

    public static int linearSearch(int[] array, int value, int index) {
        int result = -1;
        if (index < array.length) {
            if (array[index] == value)
                result =  index;
            else {
                result = linearSearch(array, value, index + 1);
                System.out.println("Index at : " + index);
            }
        }
        return  result;
    }
}

class TestLinearSearchRecursive {
    public static void main(String[] args) {
        int[] input = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,20,29};
        System.out.println("Result is : " + LinearSearchRecursive.linearSearch(input,19,0));
    }
}
