package facebook.graphs;

/**
 * Created by mayank.gupta on 11/05/17.
 */
public class PreOrderBST {


    class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public TreeNode construct(int[] preOrder) {
        TreeNode node = construct(preOrder,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return node;

    }

    public TreeNode construct(int[] preOrder, int index, int min, int max) {

        if(index >= preOrder.length)
            return null;

        TreeNode root = null;
        int key = preOrder[index];

        if(key > min && key < max) {
            root = new TreeNode(preOrder[index]);

            /*Left subtree, the first lesser number */
            root.left = construct(preOrder,index+1,min,key);

            /*Right subtree, the first big number*/
            root.right = construct(preOrder,index+1,key,max);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{10,5,1,7,40,50};

        PreOrderBST p = new PreOrderBST();
        p.construct(preOrder);
    }
}
