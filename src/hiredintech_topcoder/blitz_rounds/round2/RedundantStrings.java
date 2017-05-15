package hiredintech_topcoder.blitz_rounds.round2;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 25/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=4505
 * https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm238
 */
public class RedundantStrings {

    public int howMany(int length) {
        List<Integer> divisors = new ArrayList<>();

        if(length == 1) {
            return 0;
        }

        if(length == 2) {
            return 2;
        }

        /*
        We need to remove all common divisors - that is a divisor which is also a divisor of some other element in divisors list,
        so list of divisors should contain only elements which are non-divisable by each other, otherwise we will be counting same roots multiple times
        */

        for(int i=1; i <= length/2; i++) {
            if(length%i == 0) {
                divisors.add(i);
            }

        }

        /*added count for a and b as root */
        int result = 0;

        for(int divisor : divisors) {
            result += (1 << (divisor)) -howMany(divisor); // ensuring only unique roots are counted
        }

        return result ;

    }

    public static void main(String[] args) {
        RedundantStrings rs = new RedundantStrings();

        System.out.println(rs.howMany(10));
    }
}
