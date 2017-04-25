package hiredintech_topcoder.dynamic_programming.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mayank.gupta on 11/04/17.
 * Problem : https://community.topcoder.com/stat?c=problem_statement&pm=1593&rd=4494
 * https://community.topcoder.com/tc?module=ProblemDetail&rd=4494&pm=1593
 *
 * Solution with DP: https://github.com/jiemingxin/TopCoder/blob/master/tutorial/graph/Circuits.java
 * Solution just with recursion and not storing any previoulsy calculated values : https://gist.github.com/sreeprasad/3604271
 *
 */
public class Circuits {

    public static int howLong(String[] connects, String[] costs) {
        int[][] graph = new int[connects.length][connects.length];
        boolean[] visited = new boolean[connects.length];

        Arrays.fill(visited,false);
        int result = 0;

        /*Initialize graph is no costs and edges*/
        for(int i = 0; i < connects.length; i++) {
            for(int j = 0; j < connects.length; j++) {
                graph[i][j] = -1;
            }
        }

        /*Populate the graph with costs of edges*/
        for(int i = 0; i < connects.length; i++) {
            if(connects[i].equals("")) {
                continue;
            }
            String[] neighbours = connects[i].split(" ");
            String[] neighbourCosts = costs[i].split(" ");

            for(int j = 0; j < neighbours.length; j++) {
                graph[i][Integer.parseInt(neighbours[j])] = Integer.parseInt(neighbourCosts[j]);
            }
        }

        /*Conduct Depth first search for all vertices and find out max cost*/
        for(int i=0; i < connects.length; i++) {
            result = Math.max(result,dfs(graph,visited,i));
        }
        return  result;
    }

    private static int dfs(int[][] graph, boolean[] visited, int vertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        int costOfTraversal = 0;

        while(!stack.empty()) {
            int node = stack.pop();
            if(visited[node])
                continue;
            visited[node] = true;
            for(int i = 0; i < graph[vertex].length;i++) {
                if(graph[node][i] != -1) {
                    costOfTraversal = costOfTraversal + graph[vertex][i];
                    stack.push(i);
                }
            }
        }
        return costOfTraversal;
    }

    public static void main(String[] args) {
       /* String[] connects = new String[]{"1 2","2",""};
        String[] costs = new String[]{"5 3",
                "7",
                ""};
       */

        String[] connects = new String[]{"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""};
        String[] costs = new String[]{"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""};

        System.out.println("Max cost is : " + howLong(connects,costs));
    }
}
