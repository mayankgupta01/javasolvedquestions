package grab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 30/04/17.
 *
 * Find out the only non duplicated element in an array, return -1 if no unique
 */
public class UniqueElementArray {

    public int findUnique(int[] array) {

        /*Validate if only one element or no elements then return*/
        if(array.length == 1)
            return array[0];

        if(array.length == 0)
            return -1;


        Map<Integer,Integer> count = new HashMap<>();

        for(int i=0; i<array.length; i++) {
            if(count.containsKey(array[i])) {
                int cnt = count.get(array[i]);
                count.put(array[i],cnt+1);
            }else {
                count.put(array[i],1);
            }
        }

        /*Traverse the Map again to find the first key with count = 1*/

        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }

        return -1;
    }

    /*Another approach is to sort the array and see for only once occuring element*/
    public int findUniqueBySort(int[] array) {

        if(array.length == 1)
            return array[0];

        if(array.length == 0)
            return -1;

        Arrays.sort(array);

        /*Check boundary conditions*/
        if(array[0] != array[1])
            return array[0];

        if(array[array.length -1] != array[array.length -2])
            return array[array.length -1];

        /*Loop for rest of the elements*/
        for(int i=1; i <array.length -1; i++) {
            if(array[i-1] != array[i] && array[i+1] != array[i])
                return array[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,2,3,4,4,5,5,6,1,8,3,6};

        UniqueElementArray u = new UniqueElementArray();

        System.out.println(u.findUnique(array));
        System.out.println(u.findUniqueBySort(array));
    }


}
