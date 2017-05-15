package facebook.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayank.gupta on 14/05/17.
 */
public class AverageLevelTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void printAverageByLevel(Node root) {

        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        /*Add a null to mark level end*/
        queue.offer(null);

        while(!queue.isEmpty()) {
            Node top = queue.poll();
            int levelSum = 0;
            int levelCount = 0;

            while(top != null) {


                levelSum += top.data;
                levelCount += 1;

                if(top.left != null){
                    queue.offer(top.left);
                }

                if(top.right != null) {
                    queue.offer(top.right);
                }

                top = queue.poll();

            }

            System.out.println("Level Sum : " + levelSum);
            System.out.println("Level count : " + levelCount);
            System.out.println("Level Average : " + levelSum/levelCount);

            /*Add null to mark level end in case queue has elements after popping the last null value*/
            if(!queue.isEmpty())
                queue.offer(null);
            /*Reinitialize levelSum and levelCount*/
            levelCount = levelSum = 0;
        }
    }

    public static void main(String[] args) {
        AverageLevelTree tree = new AverageLevelTree();
        AverageLevelTree.Node root = tree.new Node(100);

        root.left = tree.new Node(90);
        root.left.left = tree.new Node(80);
        root.left.right = tree.new Node(80);

        root.left.left.left = tree.new Node(70);


        root.right = tree.new Node(110);
        root.right.right = tree.new Node(120);
        root.right.right.right = tree.new Node(130);

        tree.printAverageByLevel(root);
    }
}
