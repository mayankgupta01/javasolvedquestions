package facebook.arrays_n_strings;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class MoveZerosRight {


    public void move(int[] array) {

        //input validations
        if(array.length <=1)
            return ;

        int nonZeroCounter = 0;

        for(int i=0; i< array.length; i++) {

            if(array[i] != 0) {
                array[nonZeroCounter] = array[i];
                nonZeroCounter++;
            }
        }

        //from nonzero counter to end of array, put zeros
        for( int i= nonZeroCounter; i < array.length; i++) {
            array[i] = 0;
        }


    }

    public static void main(String[] args) {
        int[] array = new int[]{0,0,0,0,0,1,1,2,3,0,0};
        MoveZerosRight mvr = new MoveZerosRight();
        mvr.move(array);
        System.out.println( Arrays.toString(array));

    }
}
