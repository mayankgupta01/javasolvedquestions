package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 14/01/17.
 *
 * A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

 For example, in array A such that:
 A[0] = 9  A[1] = 3  A[2] = 9
 A[3] = 3  A[4] = 9  A[5] = 7
 A[6] = 9

 the elements at indexes 0 and 2 have value 9,
 the elements at indexes 1 and 3 have value 3,
 the elements at indexes 4 and 6 have value 9,
 the element at index 5 has value 7 and is unpaired.

 Write a function:

 int solution(int A[], int N);

 that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

 ANSWER: We can also use the XOR function to solve. Applying XOR will cancel out the same integers occuring twice.
 XOR is , same digits give 0 as result, different digits give 1.

 As well as avoiding the sort you can save a single xor and the space for the return int by
 for (i = 1; i < A.Length; ++i)
 A[0] ^ A[i];
 return A[0];
 */
public class OddNumberInArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        HashMap<Integer, Integer> elementOccurenceMap = new HashMap<>();
        int result = 0;
        for(int i : A) {
            if(elementOccurenceMap.containsKey(i)) {
                elementOccurenceMap.put(i,elementOccurenceMap.get(i)+1);
            }else{
                elementOccurenceMap.put(i,1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : elementOccurenceMap.entrySet() ) {
            if(entry.getValue() == 1)
                result = entry.getKey();
        }
        return result;
    }
}
