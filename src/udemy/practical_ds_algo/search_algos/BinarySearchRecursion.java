package udemy.practical_ds_algo.search_algos;

/**
 * Created by mayank.gupta on 13/02/17.
 */
public class BinarySearchRecursion {

    public static int binarySearch(int value, int[] sortedArray) {
        int searchWindowStartIndex = 0;
        int searchWindowEndIndex = sortedArray.length -1;
        return binarySearchWithinWindow(value, sortedArray, searchWindowStartIndex, searchWindowEndIndex);
    }

    public static int binarySearchWithinWindow(int value, int[] sortedArray, int begin, int end) {
        if(begin > end) return -1;
        else {
            int searchIndex = (begin + end)/2;
            System.out.println("Binary Index = " + searchIndex + " : {" + begin + " : " + end + "}");
            if (sortedArray[searchIndex] > value) searchIndex = binarySearchWithinWindow(value, sortedArray, begin, searchIndex -1);
            if (sortedArray[searchIndex] < value) searchIndex = binarySearchWithinWindow(value, sortedArray, searchIndex + 1, end);
            return searchIndex;
        }
    }
}

class testBinarySearchRecursive {
    public static void main(String[] args) {
        int[] input = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,20,29};

        System.out.println("Result  : " + BinarySearchRecursion.binarySearch(20,input));
    }
}