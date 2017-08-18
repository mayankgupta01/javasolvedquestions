package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class SortedRotatedArray {

   /*Returns index of element found*/
    public int binarySearch(int[] input, int element) {
       return  binarySearch(input,element,0,input.length-1);

    }

    private int binarySearch(int[] input, int element, int start, int end) {

        /*base case*/
        if(start > end)
            return -1;

        int result = -1;
        int mid = (start+end)/2;

        /*Check if element found*/
        if(input[mid] == element)
            result = mid;

        /*Ensure that we are solving smaller problem with each iteration, thus give range mid-1*/
        if(input[mid] > element)
            result =  binarySearch(input,element,start,mid-1);

        if(input[mid] < element)
            result =  binarySearch(input,element,mid+1,end);

        return result;
    }

    public int findResetPointer(int[] input) {
        return findResetPointer(input,0,input.length-1);

    }

    private int findResetPointer(int[] input, int start, int end) {

       /*If no rotation then return -1, base case*/
        if(start > end)
            return -1;

        if(start == end)
            return start;

        int mid = (start+end)/2;

        if(mid < end && input[mid] > input[mid+1])
            return mid;

        if(mid > start && input[mid] < input[mid-1])
            return mid-1;

        if(input[mid] >= input[start])
            return findResetPointer(input,mid+1,end);

        return findResetPointer(input,start,mid-1);


    }

    public static void main(String[] args) {
        int[]  input = new int[]{12,13,1,2,3,10};

        SortedRotatedArray sr = new SortedRotatedArray();

//        System.out.println(sr.binarySearch(input,10));
        System.out.println(sr.findResetPointer(input));
    }
}


/*
interface I3 extends I1,I2 {

}

interface Foo<T> { void m(T arg); }
interface Bar<T> { void m(T arg); }
interface FooBar<X, Y> extends Foo<X>, Bar<Y> {}
*/
