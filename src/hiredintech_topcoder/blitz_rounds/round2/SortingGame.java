package hiredintech_topcoder.blitz_rounds.round2;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

/**
 * Created by mayank.gupta on 25/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=8745
 */
public class SortingGame {

    public int fewestMoves(int[] board, int k) {

        if(board.length == 1) {
            return 0;
        }

        int[] sortedArray = board.clone();
        Arrays.sort(sortedArray);

        Queue<String> queue = new LinkedList<>();

        String originalState ="";
        String finalState = "";

        for(int i : board) {
            originalState += i;
        }

        for(int i : sortedArray) {
            finalState += i;
        }

        Map<String, Boolean> visited = new HashMap<>();
        int moves = 0;

        /*Perform bfs to reach to final state*/
        queue.add(originalState);
        visited.put(originalState,true);
        int count = 1;
        int levelCount = 0;
        while(!queue.isEmpty()) {
            while(count > 0) {
                String top = queue.remove();
                count--;

                if(top.equals(finalState)) {
                    return moves;
                }

            /*Get all non visited next states*/
                List<String> nextStates = nextStates(top,k);

                for(String state : nextStates) {
                    if(!visited.containsKey(state)) {
                        visited.put(state,true);
                        queue.add(state);
                        levelCount++;
                    }else {
                        if(!visited.get(state)) {
                            visited.put(state,true);
                            queue.add(state);
                            levelCount++;
                        }
                    }
                }
            }
            moves++;
            count = levelCount;
            levelCount = 0;
        }

        return -1;
    }

    private List<String> nextStates(String s, int k) {
        List<String> nextStates = new ArrayList<>();

        for(int i=0; i+k <= s.length();i++) {
            String nextState = s.substring(0,i) + new StringBuilder(s.substring(i,i+k)).reverse().toString() + s.substring(i+k,s.length());
//            System.out.println(nextState + " : " + nextState.hashCode());
            nextStates.add(nextState);
        }

        return nextStates;
    }

    public static void main(String[] args) {
//        int[] board = new int[]{7,2,1,6,8,4,3,5};
//        int[] board = new int[]{3,2,1};
        int[] board = new int[]{3,2,4,1,5};
        SortingGame s = new SortingGame();
        System.out.println(s.fewestMoves(board,4));
    }
}
