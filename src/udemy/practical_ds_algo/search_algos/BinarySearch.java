package udemy.practical_ds_algo.search_algos;

/**
 * Created by mayank.gupta on 12/02/17.
 */
public class BinarySearch {

    public int binarySearch(int findValue, int[] inputSortedArray) {
        int arrayStartIndex = 0;
        int arrayLastIndex = inputSortedArray.length -1;
        int binaryIndex = (arrayLastIndex - arrayStartIndex)/2;
        int oldBinaryIndex = 0;
        while(oldBinaryIndex != binaryIndex) {
            System.out.println("Binary Index = " + binaryIndex + " : {" + arrayStartIndex + " : " + arrayLastIndex + "}");
            if(inputSortedArray[binaryIndex] == findValue) {
                return binaryIndex;
            }
            if(inputSortedArray[binaryIndex] < findValue) {
                arrayStartIndex = binaryIndex;
            }
            if(inputSortedArray[binaryIndex] > findValue) {
                arrayLastIndex = binaryIndex;
            }
            oldBinaryIndex = binaryIndex;
            binaryIndex =  arrayStartIndex + (arrayLastIndex - arrayStartIndex)/2;
        }

        if(inputSortedArray[0] == findValue) {
            return  0;
        }
        if(inputSortedArray[inputSortedArray.length - 1] == findValue) {
            return inputSortedArray.length - 1;
        }
        return -1;
    }
}

class BinarySearchBetterImplementation {
    public static int binarySearch(int value, int[] sortedArray) {
        int length = sortedArray.length;
        int searchWindowStart = 0;
        int searchWindowEnd = length - 1;

        while(searchWindowStart <= searchWindowEnd) {
            int binaryIndex = (searchWindowStart + searchWindowEnd)/2;
            System.out.println("Binary Index = " + binaryIndex + " : {" + searchWindowStart + " : " + searchWindowEnd + "}");
            if (sortedArray[binaryIndex] == value)
                return binaryIndex;
            if (sortedArray[binaryIndex] > value)
                searchWindowEnd = binaryIndex - 1;
            if (sortedArray[binaryIndex] < value)
                searchWindowStart = binaryIndex + 1;
        }
        return -1;
    }
}

class testBinarySearch {
    public static void main(String[] args) {
        int[] input = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,18,20,29};
        BinarySearch bs = new BinarySearch();
        System.out.println("Found value at index : " + bs.binarySearch(0,input));

        System.out.println("Better Implementation result : " + BinarySearchBetterImplementation.binarySearch(0, input));
    }
}
