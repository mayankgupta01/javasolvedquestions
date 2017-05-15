package cracking_coding_interview.trees_n_graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class CGraph {

    int vertices;

    List<Integer>[] adjList;

    CGraph(int vertices) {
        this.vertices = vertices;

        adjList = new LinkedList[vertices];

        for(int i=0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        if(a > vertices || b > vertices)
            throw new IllegalArgumentException("values should be less than number of vertices");

        if(adjList[a].contains(b))
            return;

        adjList[a].add(b);
    }

    public List<Integer> getAdjList(int a) {
        if(a >= vertices || a < 0)
            throw new IllegalArgumentException(" should be in range 0 to " + vertices + "-1");

        return adjList[a];
    }
}
