package hiredintech_topcoder.dynamic_programming.graphs;

import udemy.practical_ds_algo.graph.Graph;

import java.util.*;

/**
 * Created by mayank.gupta on 12/04/17.
 * Problem : https://community.topcoder.com/stat?c=problem_statement&pm=12426
 * Solution : http://apps.topcoder.com/wiki/display/tc/SRM+570
 */
public class CentaurCompanyDiv2 {

   /* private int[][] graph;
    private int numOfVertices;
    private boolean[] visited;

    public long count(int[] a, int b[]) {
        numOfVertices = a.length + 1;
        graph = new int[numOfVertices + 1][numOfVertices + 1];
        visited = new boolean[numOfVertices + 1];

        *//* Fill graph with default value to show no edges *//*
        for(int i=0; i < graph.length;i++) {
            Arrays.fill(graph[i],-1);
        }

        *//* Make all vertices as not visited *//*
        Arrays.fill(visited,false);

        *//*Basically we need to find the number of components of the graph, each component can be given to either horse or
        * Human company. So there will be 2 to the power of components  ways
        * Since number of vertices is small , dfs via recursion should work fine*//*
        populateGraph(a, b);
        long component = 0;

        for(int i=1; i <= numOfVertices; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                component++;
            }
        }
        return  (long)Math.pow(2,component);
    }

    private void populateGraph(int[] a, int[] b) {
        for(int i=0; i <a.length; i++) {
            graph[a[i]][b[i]] = 1;
            graph[b[i]][a[i]] = 1;
        }
    }

    private void dfs(int vertex) {
        for(int i=0; i < numOfVertices; i++) {
            if(graph[vertex][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
*/

    List<int[]> serverDist;
    List<int[]> rejectedCombos;
    int vertices;
    Graph graph;

    private static class Graph {
       private int vertices;
       private ArrayList<LinkedList<Integer>> adjList;

       public Graph(int n) {
           this.vertices = n;
           adjList = new ArrayList<>();
           for(int i=0; i <= n; i++) {
               adjList.add(i,new LinkedList<>());
           }
       }

       public void addEdge(int v1, int v2) {
           adjList.get(v1).add(v2);
           adjList.get(v2).add(v1);
       }

       public LinkedList<Integer> getEdge(int vertex) {
           return adjList.get(vertex);
       }
    }

    public long count(int[] a, int[] b) {
        vertices = a.length + 1;
        serverDist = new ArrayList<>();
        rejectedCombos = new ArrayList<>();
        graph = new Graph(vertices);

        populateGraph(graph,a,b);

        /* Find all combos of server distribution, starting with have atleast 2 servers */
        for(int i=1; i <= vertices; i++) {
            int[] combo = new int[i];
            findCombos(i, combo, 0, 1);
        }

        /*From all combos, reject the if servers are not connected to each other  */
        for(int[] combo : serverDist) {
            for(int i=0; i < combo.length;i++) {
                if(!dfs(combo,combo[i])){
                    rejectedCombos.add(combo);
                    break;
                }
            }
        }

        /* Result should include condition where no servers are given to Human company */
        return 1 + serverDist.size() - rejectedCombos.size();
    }

    private boolean dfs(int[] combo, int vertex) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices + 1];
        visited[vertex] = true;
        stack.push(vertex);
        int countConnection = 0;

        while(!stack.empty()) {
            int top = stack.peek();
            stack.pop();

            LinkedList<Integer> neighbours = graph.getEdge(top);

            for(int node : neighbours) {
                if(!visited[node]) {
                    if(contains(combo,node) && contains(combo,top))
                        countConnection++;
                    visited[node] = true;
                    stack.push(node);
                }
            }
        }
        if(countConnection < combo.length - 1)
            return false;

        return true;
    }

    private boolean contains(int[] array, int value) {
        for(int i=0; i < array.length; i++) {
            if(value == array[i])
                return true;
        }
        return false;
    }

    private void populateGraph(Graph graph, int[] a, int[] b) {
        for(int i=0; i < a.length; i++) {
            graph.addEdge(a[i],b[i]);
        }
    }

    private void findCombos(int comboSize, int[] combo, int index,int i) {

        if(comboSize == index) {
            int[] addCombo = new int[comboSize];
            for(int j = 0; j < comboSize; j++) {
                addCombo[j] = combo[j];
            }
            serverDist.add(addCombo);
            return;
        }

        if(i > vertices) return;

        /*Add to combo and call to fill next position*/
        combo[index] = i;
        findCombos(comboSize,combo,index+1,i+1);

        /*Ignore this number and fill index position with some other number by overwriting*/
        findCombos(comboSize,combo,index,i+1);
    }

    public static void main(String[] args) {
        CentaurCompanyDiv2 c = new CentaurCompanyDiv2();

      /*  int[] a = new int[]{1};
          int[] b = new int[]{2};
      */

       /* int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        int[] b = new int[]{2,3,4,5,6,7,8,9,10};*/

   /*     int[] a = new int[]{10, 7, 2, 5, 6, 2, 4, 9, 7};
        int[] b = new int[]{8, 10, 10, 4, 1, 6, 2, 2, 3};*/

        /*int[] a = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] b = new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};*/

        int[] a = new int[]{2,2};
        int[] b = new int[]{1,3};
        System.out.println("Num of ways of dividing servers is : " + c.count(a,b));
    }
}
