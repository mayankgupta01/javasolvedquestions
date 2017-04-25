package hiredintech_topcoder.dynamic_programming;

/**
 * Created by mayank.gupta on 08/04/17.
 * https://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
 * https://github.com/mgechev/playground/blob/master/algorithms/AvoidRoads.java
 */
public class AvoidRoads {

    public static long numWays(int width, int height, String[] bad) {
//        Initialize map with extra row to avoid writing checks for i,j < 0
        long[][] map = new long[height + 1][width + 1];
        map[0][0] = 1;
        long leftNeighbourPaths;
        long downNeighbourPaths;
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= width; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i !=0 && j != 0) {
                    leftNeighbourPaths = isBadEdge(i,j-1,i,j,bad) || isBadEdge(i,j,i,j-1,bad) ? 0 : map[i][j -1];
                    downNeighbourPaths = isBadEdge(i-1,j,i,j,bad) || isBadEdge(i,j,i-1,j,bad) ? 0 : map[i-1][j];
                    map[i][j] =  leftNeighbourPaths + downNeighbourPaths;
                }
                if(i==0 && j!=0) {
                    leftNeighbourPaths = isBadEdge(i,j-1,i,j,bad) || isBadEdge(i,j,i,j-1,bad) ? 0 : map[i][j -1];
                    map[i][j] =  leftNeighbourPaths;
                }
                if(i !=0 && j == 0) {
                    downNeighbourPaths = isBadEdge(i-1,j,i,j,bad) || isBadEdge(i,j,i-1,j,bad) ? 0 : map[i-1][j];
                    map[i][j] = downNeighbourPaths;
                }
            }
        }
        return map[height][width];
    }

    public static boolean isBadEdge(int i, int j, int p, int q, String[] bad) {
        String s = i + " " + j + " " + p + " " + q;
        for(String badEdge : bad) {
            if(s.equals(badEdge))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        String[] bad = {"0 0 0 1", "6 6 5 6"};
        String[] bad = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
        long result = AvoidRoads.numWays(2,2,bad);
        System.out.println("Num of ways of reaching : " + result);
    }
}
