package cracking_coding_interview.trees_n_graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class GraphRoute {

    public boolean exists(int a, int b, CGraph graph) {

        if(a == b)
            return true;

        if(a < 0 || b < 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];

        /*Add the source*/
        visited[a] = true;
        queue.add(a);


        while(!queue.isEmpty()) {

            int top = queue.remove();

            if(top == b)
                return true;

            for(int neighbour : graph.getAdjList(top)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CGraph graph = new CGraph(5);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,0);

        GraphRoute route = new GraphRoute();

        System.out.println(route.exists(3,4,graph));
    }
}
