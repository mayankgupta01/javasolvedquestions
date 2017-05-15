package hiredintech_topcoder.blitz_rounds.round2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by mayank.gupta on 25/04/17.
 */
public class ContestWinner {

    public int getWinner(int[] events) {

        Map<Integer,Stack<Integer>> submissions = new HashMap<>();

        if(events.length == 1) {
            return events[0];
        }

        for(int i = 0; i < events.length; i++) {
            if(submissions.containsKey(events[i])) {
                submissions.get(events[i]).push(i);
            }else {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                submissions.put(events[i],stack);
            }
        }

        /*Loop over the Map to find the winner's list*/
        int winner = 0;
        int maxSubmissions = 0;
        int minSubmissionEvent = 0;

        for(Map.Entry<Integer,Stack<Integer>> entry : submissions.entrySet()) {
            if(entry.getValue().size() > maxSubmissions) {
                winner = entry.getKey();
                maxSubmissions = entry.getValue().size();
                minSubmissionEvent = entry.getValue().peek();
            }

            /*If num of submissions are equal, make the guy who made last submission fastest as winner*/
            if(entry.getValue().size() == maxSubmissions && entry.getValue().peek() < minSubmissionEvent ) {
                winner = entry.getKey();
                minSubmissionEvent = entry.getValue().peek();
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        ContestWinner contest = new ContestWinner();
        int[] events = new int[]
                {1,2,2,3,3,3,4,4,4,4};

        System.out.println(contest.getWinner(events));
    }
}
