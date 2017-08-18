package hiredintech_topcoder.graphs.binarytree;

/**
 * Created by mayank.gupta on 07/06/17.
 */
public class Mirror {

    public void createMirror(Node root) {

        //base state check
        if(root == null)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        createMirror(root.left);
        createMirror(root.right);
    }



    public static void main(String[] args) {
        Node root = new Node(100);

        /*
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(25);

        root.right = new Node(200);
        root.right.left = new Node(150);
        */

        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(1);

        Mirror mirror = new Mirror();
        mirror.createMirror(root);

        System.out.println(root.data);
    }
}


class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}