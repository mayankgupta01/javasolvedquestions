package codility;

import java.util.ArrayList;

/**
 * Created by mayank.gupta on 29/01/17.
 */
public class BinaryGapRetry {
    public int solution(int N) {
        String binaryOfN = Integer.toBinaryString(N);
        ArrayList<Integer> gapCount = new ArrayList<>();
        boolean shouldCount = false;
        int count = 0;
        for(char c : binaryOfN.toCharArray()) {
            if(c == '1' && count == 0)
                shouldCount = true;
            if(c == '1' && count != 0) {
                gapCount.add(count);
                count = 0;
            }
            if(c == '0' && shouldCount) {
                count++;
            }
        }
        int maxGap = 0;
        for(int gap : gapCount) {
            maxGap = Math.max(gap, maxGap);
        }

        return maxGap;
    }
}
