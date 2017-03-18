package codility;

import java.util.ArrayList;

/**
 * Created by mayank.gupta on 29/01/17.
 */
public class MiminalParameter {
    public int solution(int N) {
        ArrayList<Integer> perimeterArray = new ArrayList<>();
        int sqrt = (int) Math.sqrt(N);

        if (sqrt*sqrt == N)
            return sqrt*4;

        for(int i = 1; (long) i * i < N; i++) {
            if(N % i == 0) {
                int perimeter =( N/i + i ) * 2;
                perimeterArray.add(perimeter);
            }
        }
        int minParameter = Integer.MAX_VALUE;
        for (int perimeter : perimeterArray) {
            minParameter = Math.min(minParameter, perimeter);
        }

        return minParameter;
    }
}
