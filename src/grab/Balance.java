package grab;

import java.util.*;

/**
 * Created by mayank.gupta on 24/05/17.
 */
public class Balance {

    public String parathesis(String s) {

        //we will do bfs, by removing on bracket at each level and see if string is balanced

        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        queue.add(null);
        int level = 0;
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()) {

            String top = queue.remove();

            while(top != null) {

                if(isBalanced(top)) {
                    return top;
                }

                //find all children by removing one ()

                for(int i=0; i < top.length(); i++) {
                    if(top.charAt(i) == '(' || top.charAt(i) == ')') {
                        String child = top.substring(0,i) + top.substring(i+1);
                        if(!visited.contains(child)) {
                            queue.add(child);
                        }
                    }
                }

                top = queue.remove();
            }

            //
            if(!queue.isEmpty()) {
                queue.add(null);
            }

            level += 1;
        }

        return null;

    }

    public boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(') {
                stack.push(c);
            }

            if(c == ')') {
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "abc)(((asd())))";

        Balance balance = new Balance();
        System.out.println(balance.parathesis(s));
    }
}