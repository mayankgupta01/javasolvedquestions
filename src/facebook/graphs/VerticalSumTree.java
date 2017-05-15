package facebook.graphs;

import udemy.practical_ds_algo.linkedlists.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class VerticalSumTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void verticalSum(Node root) {

        if(root == null)
            return;

        List<ArrayList<Integer>> leftSubtreeSum = new ArrayList<>();
        List<ArrayList<Integer>> rightSubtreeSum = new ArrayList<>();
        ArrayList<Integer> rootVerticalSum = new ArrayList<>();
        rootVerticalSum.add(root.data);
        leftSubtreeSum.add(rootVerticalSum);
        rightSubtreeSum.add(rootVerticalSum);

        verticalSumLeftSubTree(root.left, leftSubtreeSum, 1);
        verticalSumRightSubTree(root.right, rightSubtreeSum, 1);

        /*Print from left most to right most vertical sum*/
        for(int i=leftSubtreeSum.size()-1; i >= 0; i--) {
            int sum = 0;

            for(int j : leftSubtreeSum.get(i)) {
                sum += j;
            }
            System.out.println("Vertical sum of left, level " + i + " : " + sum);
        }

        for(int i=0; i < rightSubtreeSum.size(); i++) {
            int sum = 0;

            for(int j : rightSubtreeSum.get(i)) {
                sum += j;
            }
            System.out.println("Vertical sum of right, level "+ i + " : " + sum);
        }
    }

    public void verticalSumLeftSubTree(Node root, List<ArrayList<Integer>> list, int level) {

        verticalSumUtil(root,list,level);
        /*Recur for left and right child*/
        if(root != null) {
            verticalSumLeftSubTree(root.left, list, level +1);
            verticalSumLeftSubTree(root.right, list, level - 1);
        }

    }

    public void verticalSumRightSubTree(Node root, List<ArrayList<Integer>> list, int level) {

       verticalSumUtil(root,list,level);

        /*Recur for left and right child*/
        if(root != null) {
            verticalSumLeftSubTree(root.left, list, level-1);
            verticalSumLeftSubTree(root.right, list, level+1);
        }
    }

    public void verticalSumUtil(Node root, List<ArrayList<Integer>> list, int level) {
        if(root == null)
            return;
        ArrayList<Integer> vSum = null;
        if(list.size() == level) {
            vSum = new ArrayList<>();
            vSum.add(root.data);
            list.add(vSum);
        }else {
            vSum = list.get(level);
            vSum.add(root.data);
        }
    }

    public static void main(String[] args) {
        VerticalSumTree vs = new VerticalSumTree();
        VerticalSumTree.Node root = new VerticalSumTree.Node(10);
        root.left = new VerticalSumTree.Node(5);
        root.left.left = new VerticalSumTree.Node(2);
        root.left.right = new VerticalSumTree.Node(7);
        root.left.right.left = new VerticalSumTree.Node(6);
        root.left.left.right = new VerticalSumTree.Node(4);

        root.right = new VerticalSumTree.Node(20);
        root.right.right = new VerticalSumTree.Node(40);
        root.right.left = new VerticalSumTree.Node(15);

        /*
        *                   10
        *                /     \
        *               5       20
        *             /  \     /   \
        *            2   7    15     40
        *           /  /
        *           4 /
        *           6
        * */

        vs.verticalSum(root);
    }
}
