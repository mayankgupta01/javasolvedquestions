package hiredintech_topcoder.graphs;

import java.util.*;

/**
 * Created by mayank.gupta on 23/04/17.
 */
public class LongestPathBetweenVertices {

    UndirectedGraph graph;
    ArrayList<ArrayList<Integer>> result;
    boolean[] visited;

    LongestPathBetweenVertices(int vertices) {
        result = new ArrayList<>();
        visited = new boolean[vertices];
        graph = new UndirectedGraph(vertices);
    }

    public int[] findLongestPath(int a, int b) {
        dfsFindAllPaths(a,b,new ArrayList<>(),0);
        ArrayList<Integer> maxPath = new ArrayList<>();
        Arrays.fill(visited,false);

        for(ArrayList<Integer> path : result) {
            System.out.println(Arrays.toString(path.toArray()));
            if(path.size() > maxPath.size())
                maxPath = path;
        }

        return maxPath.stream().mapToInt(i -> i).toArray();
    }

    public void dfsFindAllPaths(int a, int b, List<Integer> path, int index) {

        if (a == b) {

            /*for(int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i) + ", ");
            }
            */System.out.println();

            ArrayList<Integer> newPath = new ArrayList<>(path);
            result.add(newPath);


            return;
        }

        visited[a] = true;
        path.add(index,a);
        index++;

        for(int neighbour : graph.getEdges(a)) {
            if(!visited[neighbour])
                dfsFindAllPaths(neighbour, b, path,index);
        }

        index--;
        path.remove(index);
        visited[a] = false;

    }

    public void dfsUsingStack(int a, int b, List<Integer> path) {

        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        visited[a] = true;

        /*Logic to do DFS and record path*/
        while(!stack.isEmpty()) {

            int top = stack.pop();

            if(top != a)
                visited[top] = false;

            if(top == b) {
                System.out.println(Arrays.toString(path.toArray()));
                path.clear();
            }else {
                if(top != a)
                    path.add(top);
                for(int node : graph.getEdges(top)) {
                    if(!visited[node]) {
                        visited[node] = true;
                        stack.push(node);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LongestPathBetweenVertices longestPath = new LongestPathBetweenVertices(5);
        longestPath.graph.addEdge(0,1);
        longestPath.graph.addEdge(0,2);
        longestPath.graph.addEdge(0,3);
        longestPath.graph.addEdge(0,4);
        longestPath.graph.addEdge(1,3);
        longestPath.graph.addEdge(3,2);
        longestPath.graph.addEdge(2,4);

        /*
        *
        *                       0
        *                   /  \ \ \
        *                  1- 3 - 2 \
        *                          \ \
        *                          \ /
        *                           4
        *
        * */


        System.out.println(Arrays.toString(longestPath.findLongestPath(0, 4)));

    }
}


class UndirectedGraph {
    int vertices;
    private List<ArrayList<Integer>> adjList;

    UndirectedGraph(int number) {
        this.vertices = number;
        adjList = new ArrayList<>();
        for(int i = 0; i < number; i++ ) {
            adjList.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    public List<Integer> getEdges(int a) {
        return adjList.get(a);
    }
}