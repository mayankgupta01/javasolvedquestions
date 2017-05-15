package hiredintech_topcoder.graphs;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Arrays;

/**
 * Created by mayank.gupta on 11/05/17.
 */
public class DjikstraAlgo {

    int[][] graph;
    int vertices;
    boolean minPathDone[];
    int[] distance;

    DjikstraAlgo(int vertices) {
        this.vertices = vertices;
        graph = new int[vertices][vertices];
        minPathDone = new boolean[vertices];
        distance = new int[vertices];
    }

    public int findMin() {

        int minVertex = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<vertices;i++) {
            if(!minPathDone[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex =i;
            }
        }

        return minVertex;
    }

    public void shortestPath(int vertex) {

        Arrays.fill(minPathDone,false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[vertex] = 0;

        int u = findMin();
        while(u != -1) {

            minPathDone[u] = true;

            for(int v=0; v<vertices; v++) {
                if(!minPathDone[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
            }

            u = findMin();
        }

        System.out.println(Arrays.toString(distance));

    }

    public static void main(String[] args) {
        DjikstraAlgo ds = new DjikstraAlgo(5);

        ds.graph[0][1] = 50;
        ds.graph[0][2] = 20;
        ds.graph[0][3] = 30;
        ds.graph[1][3] = 10;
        ds.graph[2][3] = 5;
        ds.graph[2][4] = 2;
        ds.graph[1][4] = 100;

        ds.shortestPath(0);
    }


}
