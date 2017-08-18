package facebook.arrays_n_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 14/05/17.
 *
 * You have a string of numbers, i.e. 123. You can insert a + or - sign in front of ever number, or you can leave it empty.
 * Find all of the different possibilities, make the calculation and return the sum. For example; +1+2+3 = 6 +12+3 = 15 +123 = 123 +1+23 = 24 ... -1-2-3 = 6 ... Return the sum of all the results
 */
public class ExpressionSum {
    List<Integer> sums = new ArrayList<>();

    public int findSum(int num) {
        if(num == 0)
            return 0;

        /*Change num to string representation*/
        String s = String.valueOf(num);

        /*sum is of all the numbers which don't have any sign before 1st digit*/
        findSum(s,s.length()-1,s.length()-1,0);

        int sum = 0;
        for(int i : sums) {
            sum += i;
        }

        return sum;
    }

    public void findSum(String s, int start, int end, int sum) {
        /*Base case*/
        if(start == 0) {
            sum = sum + Integer.parseInt(s.substring(start,end+1));
            sums.add(sum);
            return;
        }

        /*Three cases are made, no sign, + sign, -sign */
        /*No sign*/
        findSum(s,start-1,end,sum);

        /*+ sign*/
        int num = Integer.parseInt(s.substring(start,end+1));

        findSum(s,start-1,start-1,sum + num);

        /* - sign */
        findSum(s,start-1,start-1,sum - num);
    }

    public static void main(String[] args) {
        ExpressionSum ex = new ExpressionSum();
        System.out.println(ex.findSum(01));
    }

}
