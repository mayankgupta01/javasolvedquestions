package facebook.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class Museum {

    class QueueNode {

        int i;
        int j;

        QueueNode(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public String[][] distanceFromGuard(String[][] matrix) {



        for(int i=0; i < matrix.length; i++) {

            for(int j=0; j < matrix[0].length; j++) {

                if(matrix[i][j].equals("O")) {
                    /*Do BFS to find out the shortest distance from guard, return -1 if not possible without crossing walls*/

                    matrix[i][j] = String.valueOf(bfs(matrix,i,j));
                }
            }
        }

        return matrix;
    }

    public int bfs(String[][] matrix, int i, int j) {

        int[] row = new int[]{1,-1,0,0};
        int[] col = new int[]{0,0,1,-1};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<QueueNode> queue = new LinkedList<>();

        QueueNode node = new QueueNode(i,j);
        visited[i][j] = true;
        queue.offer(node);
        queue.offer(null);
        int count = 0;

        while(!queue.isEmpty()) {

            /*Level traversal - need to keep a count of levels traversed to find guard*/
            QueueNode top = queue.poll();

            while(top != null) {
                if(matrix[top.i][top.j].equals("G"))
                    return count;

                /*Add all valid neighbours which are not walls*/
                for(int k= 0; k < row.length; k++) {
                    int rowIndex = top.i + row[k];
                    int colIndex = top.j + col[k];

                    if(rowIndex >= 0 && rowIndex < matrix.length && colIndex >= 0 && colIndex < matrix[0].length && !matrix[rowIndex][colIndex].equals("W") && !visited[rowIndex][colIndex]) {
                        queue.offer(new QueueNode(rowIndex,colIndex));
                        visited[rowIndex][colIndex] = true;
                    }
                }
                top = queue.poll();
            }

            /*Add new null to mark level end if queue is not already empty*/
            if(!queue.isEmpty())
                queue.offer(null);

            count += 1;
        }

        return -1;

    }



    public static void main(String[] args) {
        String[][] matrix = {{"O","W","G"},{"W","O","O"},{"G","W","G"}};

        Museum ms = new Museum();
        ms.distanceFromGuard(matrix);
        for(int i=0; i< matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }


}
