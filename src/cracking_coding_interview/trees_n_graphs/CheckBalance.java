package cracking_coding_interview.trees_n_graphs;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class CheckBalance {


    public boolean isBalanced(BNode root) {

        /*Tree is balanced if subtrees have a height difference of not more than 1*/
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(rightHeight - leftHeight) > 1)
            return false;
        /*This code runs in O(Nsqaure)*/
        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int height(BNode node) {
        if(node == null)
            return 0;

        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;

        return Math.max(leftHeight,rightHeight);
    }

    public boolean isBalancedBetter(BNode root) {

        int height = checkHeight(root);

        return height != -1;
    }

    public int checkHeight(BNode root) {

        /*Base case*/
        if(root == null)
            return 0;

        /*This code runs in O(N)*/
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return  Math.max(leftHeight,rightHeight) + 1;
    }

    public static void main(String[] args) {
        /*Construct binary tree balanced*/
        BNode root = new BNode(10);
        root.left = new BNode(20);
        root.right = new BNode(30);
        root.left.left = new BNode(40);
        root.right.right = new BNode(50);
        root.left.left.left = new BNode(60);
        root.left.left.left.left = new BNode(70);



        CheckBalance cb = new CheckBalance();
        System.out.println(cb.isBalanced(root));
        System.out.println(cb.isBalancedBetter(root));
    }
}
