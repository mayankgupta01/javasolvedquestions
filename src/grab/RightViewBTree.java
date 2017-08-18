package grab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mayank.gupta on 17/05/17.
 */
//right view of a binary tree

public class RightViewBTree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    public void print(Node root) {

        //level order traversal using queue
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        Node prev = null;

        while(!queue.isEmpty()) {

            Node top = queue.poll();

            while(top != null) {

                if(top.left != null)
                    queue.add(top.left);

                if(top.right != null)
                    queue.add(top.right);

                prev = top;
                top = queue.poll();
            }

            //whenever we come out of this prev will hold value of rightmost node of that level
            System.out.print(prev.data + " , ");

            //add a new null to mark the end of new level, in case queue is not empty already
            if(!queue.isEmpty())
                queue.add(null);
        }

    }

    public void printNew(Node root) {

        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();

        List<Integer> result = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        System.out.println("New Version ********");

        while(!queue.isEmpty()) {

            Node top = queue.remove();
            Node prev = null;

            while(top != null) {

                if(top.left != null) {
                    queue.add(top.left);
                }

                if(top.right != null) {
                    queue.add(top.right);
                }

                prev = top;
                top = queue.remove();

            }

            if(!queue.isEmpty())
                queue.add(null);

            System.out.print(prev.data + ", ");
        }

    }

    public static void main(String[] args) {
        RightViewBTree.Node root  = new RightViewBTree.Node(50);
        root.left = new RightViewBTree.Node(40);
        root.right = new RightViewBTree.Node(80);

        root.left.left = new RightViewBTree.Node(30);
        root.right.left = new RightViewBTree.Node(70);

        root.left.left.left = new RightViewBTree.Node(20);
        root.left.left.left.left = new RightViewBTree.Node(10);
        root.left.left.left.right = new RightViewBTree.Node(15);

        RightViewBTree rightView = new RightViewBTree();
        rightView.print(root);
        rightView.printNew(root);

    }
}
