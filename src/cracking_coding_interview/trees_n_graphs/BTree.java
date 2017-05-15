package cracking_coding_interview.trees_n_graphs;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class BTree {

    BNode root;

    BTree(BNode root) {
        this.root = root;
    }

    public void insertLeft(BNode node, int value) {
        BNode newNode = new BNode(value);
        if(node.left != null)
            throw new IllegalArgumentException("Right node already exists !");

        node.left = newNode;
    }


    public void insertRight(BNode node, int value) {
        BNode newNode = new BNode(value);
        if(node.right != null)
            throw new IllegalArgumentException("Right node already exists !");

        node.right = newNode;
    }
}

class BNode {

    BNode left;
    BNode right;

    int value;

    BNode(int value) {
        this.value = value;
        left = right = null;
    }
}

