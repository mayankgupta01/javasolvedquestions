package facebook.dp;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class MinJumps {

    public int toReachEnd(int[] array) {


        int[] moves = new int[array.length];
        Arrays.fill(moves,Integer.MAX_VALUE);
        moves[0] = 0;

        if(array[0] == 0)
            return -1;


        /*Bottoms up approach*/
        for(int i=0; i < array.length; i++) {

            int maxJumpFromI = array[i];

            for(int j=1; j<=maxJumpFromI; j++) {
                if(i+j < array.length && moves[i] != Integer.MAX_VALUE && moves[i+j] > moves[i] + 1)
                    moves[i+j] = moves[i] + 1;
            }
        }

        return moves[array.length-1] == Integer.MAX_VALUE ? -1 : moves[array.length -1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        MinJumps mj = new MinJumps();
        System.out.println(mj.toReachEnd(array));
    }
}
