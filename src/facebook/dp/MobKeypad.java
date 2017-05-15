package facebook.dp;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mayank.gupta on 11/05/17.
 */
public class MobKeypad {


    LinkedList<Integer>[] adjList;

    MobKeypad() {
        adjList = new LinkedList[10];

        for(int i=0; i<10; i++) {
            adjList[i] = new LinkedList<>();
        }

        createKeyPad();
    }
    public void createKeyPad() {
        addEdge(0,0);
        addEdge(0,8);
        addEdge(1,1);
        addEdge(1,2);
        addEdge(1,4);
        addEdge(2,2);
        addEdge(2,3);
        addEdge(2,5);
        addEdge(3,3);
        addEdge(3,6);
        addEdge(4,5);
        addEdge(4,7);
        addEdge(4,4);
        addEdge(5,6);
        addEdge(5,8);
        addEdge(5,5);
        addEdge(6,9);
        addEdge(6,6);
        addEdge(7,8);
        addEdge(7,7);
        addEdge(8,9);
        addEdge(8,8);
        addEdge(9,9);
    }

    public void addEdge(int a, int b) {
        if(a == b) {
            adjList[a].add(a);
        }else {
            adjList[a].add(b);
            adjList[b].add(a);

        }
    }

    public int findCombo(int length) {

        if(length == 0)
            return 0;

        if(length == 1)
            return 10;

        int[][] count = new int[10][length+1];

        for(int i=0; i < 10; i++) {
            count[i][0] = 0;
            count[i][1] = 1;
        }

        for(int k=2; k<=length; k++) {

            /*Build the count from 2 to length for a number starting with i*/
            for(int i=0; i < 10; i++) {
                for(int j : adjList[i]) {
                    count[i][k] += count[j][k-1];
                }

            }

        }

        int result = 0;
        for(int i=0; i< 10; i++) {
            result = result + count[i][length];
        }

        return result;
    }


    public static void main(String[] args) {
        MobKeypad mk = new MobKeypad();

        System.out.println(mk.findCombo(4));
    }

}
