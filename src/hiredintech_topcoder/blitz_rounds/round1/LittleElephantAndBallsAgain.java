package hiredintech_topcoder.blitz_rounds.round1;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 22/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=12794
 */
public class LittleElephantAndBallsAgain {

    int getNumber(String S) {

        int rowLength = S.length();
        int[] maxSameBalls = new int[rowLength];

        if(rowLength == 1) {
            return 0;
        }

        int i = 0;
        int j =  0;
        while(i < rowLength-1) {
            j = 0;
            while(i+j < rowLength) {
                if(S.charAt(i) == S.charAt(i+j)) {
                    maxSameBalls[i]++;
                    j++;
                }else {
                    break;
                }
            }
            i = i + j;
        }

        int max = 0;
        for(int k : maxSameBalls) {
            max = Math.max(max, k);
        }

        return rowLength - max;
    }

    public static void main(String[] args) {
        LittleElephantAndBallsAgain elephant = new LittleElephantAndBallsAgain();
        String s = "RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR";
        System.out.println(elephant.getNumber(s));
    }
}
