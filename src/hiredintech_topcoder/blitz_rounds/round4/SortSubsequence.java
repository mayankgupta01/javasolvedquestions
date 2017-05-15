package hiredintech_topcoder.blitz_rounds.round4;

/**
 * Created by mayank.gupta on 27/04/17.
 */
public class SortSubsequence {

    public void findMinIndicesForSort(int[] input) {

        int startAt = input.length -1;
        int endAt = -1;
        int currentLargest = input[0];

        for(int i = 1; i < input.length; i++) {

            if(input[i] >= currentLargest) {
                currentLargest = input[i];
                continue;
            }
            endAt = i;
            /*In case we have a startAt position and current candidate is greater than startAt candidate, no need to find
            * a new start position. Also, if current startAt is 0, then no need to find a new startAt
            * */
            if(startAt > 0 && input[i] < input[startAt]) {
                for(int j = 0; j < startAt; j++) {
                    if(input[j] > input[i]) {
                        startAt = j;
                        break;
                    }
                }
            }

        }
        System.out.println("We need to sort indexes : " + startAt + " to " + endAt);
    }

    public static void main(String[] args) {
//        int[] input = new int[]{1,2,3,5,4,6};
        int[] input = new int[]{1,2,4,7,10,11,7,12,6,7,18,19};

        SortSubsequence sort = new SortSubsequence();
        sort.findMinIndicesForSort(input);
    }

}
