package codility;

/**
 * Created by mayank.gupta on 29/01/17.
 *
 * Below solution fails for N =  2,147,483,647, as i * i overflows 32 bits. Hence typecase i*i to long.
 */
public class CountFactors {
    public int solution(int N) {
        int countOfFactors = 0;
        int i = 1;
        for(; i*i < N; i++) {
            if(N % i == 0)
                countOfFactors = countOfFactors + 2;
        }
        if(i*i == N)
            countOfFactors++;

        return countOfFactors;
    }
}
