import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayank.gupta on 01/05/17.
 */
public class ConsecutiveSum {

    static int consecutive(long num) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        int i = 1;
        long sum = 0;

        //Add integers starting from 1 till the sum is either reached or exceeded
        while(i <= num/2 +1) {
            sum = sum + i;
            queue.add(i);

            if(sum == num)
                result = result +1;

            if(sum > num) {
                while(sum > num) {
                    int top = queue.remove();
                    sum = sum - top;
                    if(sum == num)
                        result = result + 1;
                }
            }
            i++;
        }

        return result;
    }


    public static void main(String[] args) {
        ConsecutiveSum.consecutive(15);
    }
}
