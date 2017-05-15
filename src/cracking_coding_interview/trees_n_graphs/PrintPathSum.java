package cracking_coding_interview.trees_n_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by mayank.gupta on 07/05/17.
 *
 * 4.9
 */
public class PrintPathSum {

    int originalSum;

    public void printPath(BNode root, int sum) {
        if(root == null)
            return;
        originalSum = sum;
        ArrayList<Integer> list = new ArrayList<>();
        printPath(root, sum,list,0);
    }


    public void printPath(BNode root, int sum , ArrayList<Integer> list, int index) {

        if(root == null)
            return;


        /*Either we choose the node to calculate sum or we do not*/
        list.add(index,root.value);

        if(sum -root.value == 0) {
            System.out.println();
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            list.remove(index);
            return;
        }


        /*Choose the index and move on if sum is not yet achieved*/
        printPath(root.left,sum - root.value,list,index+1);
        printPath(root.right,sum - root.value,list,index+1);
    }

    public static void main(String[] args) {
        BNode root = new BNode(30);
        /*Level 2*/
        root.left = new BNode(20);
        root.right = new BNode(40);

        /*Level 3*/
        root.left.left = new BNode(10);
        root.left.right = new BNode(15);
        root.right.right = new BNode(50);
        root.right.left = new BNode(10);

        /*Level 4*/
        root.right.left.left = new BNode(30);

        /*Level 5*/
        root.right.left.left.right = new BNode(10);

        PrintPathSum pps = new PrintPathSum();
        pps.printPath(root,50);

    }
}
