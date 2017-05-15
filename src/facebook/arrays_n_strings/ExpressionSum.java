package facebook.arrays_n_strings;

/**
 * Created by mayank.gupta on 14/05/17.
 *
 * You have a string of numbers, i.e. 123. You can insert a + or - sign in front of ever number, or you can leave it empty.
 * Find all of the different possibilities, make the calculation and return the sum. For example; +1+2+3 = 6 +12+3 = 15 +123 = 123 +1+23 = 24 ... -1-2-3 = 6 ... Return the sum of all the results
 */
public class ExpressionSum {

    public int findSum(int num) {
        if(num == 0)
            return 0;

        /*Change num to string representation*/
        String s = String.valueOf(num);
        int sum = 0;

        /*sum is of all the numbers which don't have any sign before 1st digit*/

    }


}
