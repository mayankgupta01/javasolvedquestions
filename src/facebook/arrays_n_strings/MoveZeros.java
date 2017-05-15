package facebook.arrays_n_strings;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 09/05/17.
 */
public class MoveZeros {

    public void moveRight(int[] array) {

        int nonZeroIndex = nextNonZeroIndex(array,array.length-1);


        for(int i=0; i < array.length; i++) {
            if(array[i] ==0 && i <= nonZeroIndex) {
                swap(array,i,nonZeroIndex);
                nonZeroIndex = nextNonZeroIndex(array,nonZeroIndex);
            }
        }
    }

    public int nextNonZeroIndex(int[] array, int index) {
        int nonZeroIndex = index;
        while(nonZeroIndex >=0 && array[nonZeroIndex] == 0) {
            nonZeroIndex -= 1;
        }
        return nonZeroIndex;
    }

    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,0,0,1,3,0,2};
        int[] array2 = new int[]{1,2,3,4,0,0,0,0,0,2,0};

        MoveZeros mz = new MoveZeros();
        mz.moveRight(array2);
        System.out.println(Arrays.toString(array2));
    }
}