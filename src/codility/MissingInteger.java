package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by mayank.gupta on 15/01/17.
 */
public class MissingInteger {
    public int solution(int[] A) {
        //        long[] count = new long[Integer.MAX_VALUE];   //this declaration gives runtime error. Requested array size exceeds VM limit

        long maxValue = 0;
        long result = 0;
        for(int a : A) {
            if(a > maxValue)
                maxValue = a;
        }
        if (maxValue == 0)
            return 1;

        if (maxValue == 1)
            return 2;

        int[] count = new int[(int)maxValue + 1]; // using this results in performance issues when array goes to 40000 index.
//        ArrayList<Long> countList = new ArrayList<>();
        for(int a : A ) {
            if (a > 0) {
                count[a]++;
            }
        }
        for(int i = 1; i < maxValue+1; i++) {
            if (count[i] == 0) {
                result = i;
                break;
            }
        }
        return (int)result;
    }
}
