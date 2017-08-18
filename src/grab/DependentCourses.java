package grab;

import udemy.practical_ds_algo.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mayank.gupta on 24/05/17.
 */
public class DependentCourses {

    static class Graph {

        LinkedList<Integer>[] adjList;
        int vertices;

        Graph(int size) {

            adjList = new LinkedList[size];
            this.vertices = size;

            for(int i=0; i < size; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int a, int b) {

            if(a >= vertices || b >= vertices)
                return;

            adjList[a].add(b);
        }

        public LinkedList<Integer> getNeighbours(int a) {
            if(a >= vertices)
                throw new IllegalArgumentException("index out of bounds, invalid input");

            return adjList[a];
        }
    }

    public void printInOrder(Graph graph) {

        if(graph == null)
            return;

        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.vertices];

        for(int i=0; i< graph.vertices; i++) {
            if(!visited[i]) {
                //recursive solution
                printInOrder(i,stack,graph,visited);

                //iterative solution
                //dfsIterative(graph,i,visited,stack);
            }

        }


        while(!stack.isEmpty()) {

            System.out.print(stack.pop() + " ,");
        }
        System.out.println("**************");


    }

    public void printInOrder(int vertex, Stack<Integer> stack, Graph graph,boolean[] visited) {

        visited[vertex] = true;


        for(int neighbour : graph.getNeighbours(vertex)) {
            if(!visited[neighbour]) {
                printInOrder(neighbour, stack,graph,visited);
            }
        }

        stack.push(vertex);
    }


    public void dfsIterative(Graph graph, int vertex, boolean[] visited, Stack<Integer> result) {

        visited[vertex] = true;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        stack.push(vertex);

        while(!stack.isEmpty()) {

            int top = stack.pop();

            temp.push(top);

            for(int node : graph.getNeighbours(top)) {
                if(!visited[node]) {
                    visited[node] = true;
                    stack.push(node);
                }
            }
        }

        while(!temp.isEmpty()) {
            result.push(temp.pop());
        }

    }

    public static void main(String[] args) {
        DependentCourses.Graph graph = new Graph(5);

       /* graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);

        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(4,3);*/

        graph.addEdge(4,0);
        graph.addEdge(0,2);
        graph.addEdge(0,3);


        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(4,3);

        DependentCourses dc = new DependentCourses();
        dc.printInOrder(graph);
    }
}