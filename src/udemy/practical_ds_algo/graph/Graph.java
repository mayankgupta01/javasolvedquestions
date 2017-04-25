package udemy.practical_ds_algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayank.gupta on 21/03/17.
 */
public class Graph<T> {
    private Map<T,ArrayList<T>> adjacencyMap;
    private int verticesCount;
    private int edgeCount;
    private boolean isDirectional;

    public Graph(boolean isDirectional) {
        this.adjacencyMap = new HashMap<>();
        verticesCount = 0;
        edgeCount = 0;
        this.isDirectional = isDirectional;
    }

    public void addVertex(T key) {
        adjacencyMap.put(key,new ArrayList<T>());
        verticesCount++;
    }

    public void addEdge(T from, T to) {
        if(!adjacencyMap.containsKey(from) || !adjacencyMap.containsKey(from)) {
            System.out.println("Either one or both Vertices are not present in the Graph. -  " + from.toString() +  ", " + to.toString());
            return;
        }
        if(isDirectional) {
            adjacencyMap.get(from).add(to);
            edgeCount++;
        }else {
            adjacencyMap.get(from).add(to);
            adjacencyMap.get(to).add(from);
            edgeCount++;
        }
    }

    public void printGraph() {
        for(Map.Entry<T,ArrayList<T>> entry : adjacencyMap.entrySet()) {
            System.out.println(entry.getKey() + " ---->" + Arrays.toString(entry.getValue().toArray()));
        }
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }
}


class TestGraph {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(false);
        graph.addVertex("Delhi");
        graph.addVertex("Mumbai");
        graph.addVertex("Kolkata");
        graph.addVertex("Bangalore");
        graph.addVertex("Gwalior");
        graph.addVertex("Chandausi");

        graph.addEdge("Delhi","Bangalore");
        graph.addEdge("Kolkata", "Delhi");
        graph.addEdge("Kolkata", "Bangalore");
        graph.addEdge("Bangalore", "Gwalior");
        graph.addEdge("Gwalior", "Delhi");

        graph.printGraph();
        System.out.println("Numger of edges : "+graph.getEdgeCount());
        System.out.println("Number of vertices : "+graph.getVerticesCount());
    }
}