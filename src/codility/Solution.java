package codility;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 15/01/17.
 */
public class Solution {
    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        System.out.println("lenth = " + l);
        System.out.println(Arrays.toString(d));

        for (p = 1; p < (1 + l)/2; ++p) {
            int i;
            boolean ok = true;
            for (i = l-1; i < l - p -1; --i) {
                if (d[i] != d[i - p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(147));
    }
}
