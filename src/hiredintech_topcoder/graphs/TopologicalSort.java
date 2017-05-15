package hiredintech_topcoder.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mayank.gupta on 28/04/17.
 * http://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSort {

    private boolean[] visited;

    TopologicalSort() {

    }

    public void sort(TopoGraph graph) {

        /*start from any vertex*/
        visited = new boolean[graph.vertices];

        Stack<Integer> dfsStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        for(int i = 0; i < graph.vertices; i++) {
            if(!visited[i]) {
                dfsStack.push(i);
                visited[i] = true;
                while(!dfsStack.isEmpty()) {

                    int top = dfsStack.pop();

                    for(int node : graph.getEdges(top)) {
                        if(!visited[node]) {
                            visited[node] = true;
                            tempStack.push(node);
                            dfsStack.push(node);
                        }
                    }
                }
                tempStack.push(i);
            }
        }

        System.out.println("Topological sort : ");

        while(!tempStack.isEmpty())  {
            System.out.println(tempStack.pop());
        }

    }



    public static void main(String[] args) {
        TopoGraph graph = new TopoGraph(6);
        graph.addEdge(5,2);
        graph.addEdge(5,0);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(4,1);
        graph.addEdge(4,0);

        TopologicalSort tsort = new TopologicalSort();
        tsort.sort(graph);

    }
}

class TopoGraph {

    int vertices;

    private List<Integer>[] adjList;

    TopoGraph(int number) {
        this.vertices = number;
        adjList = new LinkedList[number];

        for(int i=0; i < number; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int a, int b) {
        adjList[a].add(b);
    }

    public List<Integer> getEdges(int a) {
        return adjList[a];
    }
}
