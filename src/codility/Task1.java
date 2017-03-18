package codility;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 15/01/17.
 */
public class Task1 {

    public static void main(String[] args) {
        int[] d = new int[30];
        int l = 0;
        int p;
        int n =11;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        System.out.println(Arrays.toString(d));
    }

}
