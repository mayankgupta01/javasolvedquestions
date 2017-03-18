package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mayank.gupta on 15/01/17.
 */
public class CountryMap {

    public int solution(int[][] A) {
        // write your code in Java SE 8
        Set s = new HashSet<Integer>();

        for(int i = 0 ; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                s.add(A[i][j]);
            }
        }
        return s.size();
    }


}
