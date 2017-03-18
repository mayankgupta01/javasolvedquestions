package codility;

/**
 * Created by mayank.gupta on 15/01/17.
 */
public class FrogJump {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        int result = 0;
        if((Y - X) < D)
            return 1;
        if (Y == X)
            return 0;
        result = (Y - X)/D;
        return (Y-X)%D == 0 ? result : result + 1;
    }

    public static void main(String[] args) {
        int i = 10;
        int j = 3;
        System.out.println(i/j);

    }
}
