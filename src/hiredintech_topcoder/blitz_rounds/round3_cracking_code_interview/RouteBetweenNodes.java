package hiredintech_topcoder.blitz_rounds.round3_cracking_code_interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mayank.gupta on 25/04/17.
 */
public class RouteBetweenNodes {

    DirectedGraph graph;
    boolean[] visited;

    RouteBetweenNodes(int vertices) {
        graph = new DirectedGraph(vertices);
        visited = new boolean[vertices];
    }

    public boolean routeExists(int a, int b) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(a);
        visited[a] = true;

        while(!queue.isEmpty()) {
            int top = queue.remove();

            /* Check whether b is reached */
            if(top == b) {
                return  true;
            }

            /* Get all neighbours of top and add to queue if not visited */
            for(int node : graph.getEdges(top)) {
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

        /*If reached here means that no route is available*/
        return false;
    }

    public static void main(String[] args) {
        RouteBetweenNodes route = new RouteBetweenNodes(5);
        route.graph.addEdge(0,1);
        route.graph.addEdge(0,2);
//        route.graph.addEdge(1,3);
        route.graph.addEdge(3,4);

        System.out.println(route.routeExists(0,4));
    }

}

class DirectedGraph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    DirectedGraph(int vertices) {
        this.vertices = vertices;

        adjList = new LinkedList[vertices];

        for(int i=0 ; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        if(a >= vertices || b >= vertices)
            throw new IllegalArgumentException();

        adjList[a].add(b);
    }

    public List<Integer> getEdges(int a) {
        return adjList[a];
    }
}
