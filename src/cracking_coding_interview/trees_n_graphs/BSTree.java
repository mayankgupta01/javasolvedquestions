package cracking_coding_interview.trees_n_graphs;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class BSTree {

    public boolean isBST(BNode root) {
        /*To check BST left < node < right recursively*/
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean isBST(BNode root, int min, int max) {

        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return isBST(root.left,min,root.value) && isBST(root.right,root.value,max);
    }

    public static void main(String[] args) {
        BNode root = new BNode(30);
        /*Level 2*/
        root.left = new BNode(60);
        root.right = new BNode(40);

        /*Level 3*/
        root.left.left = new BNode(10);
        root.right.right = new BNode(50);

        BSTree bsTree = new BSTree();
        System.out.println(bsTree.isBST(root));
    }
}
