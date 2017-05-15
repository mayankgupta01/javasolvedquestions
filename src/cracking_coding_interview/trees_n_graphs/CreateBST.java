package cracking_coding_interview.trees_n_graphs;

/**
 * Created by mayank.gupta on 07/05/17.
 */
public class CreateBST {

    BTree bTree;
    boolean[] visited;
    int[] sortedArray;

    CreateBST(int[] array) {
        sortedArray = array;
        visited = new boolean[array.length];
    }


    public BTree create() {
        int start = 0;
        int end = sortedArray.length -1;
        int mid = (start+end)/2;
        visited[mid] = true;

        BNode root = new BNode(sortedArray[mid]);

        create(start,mid-1,root,true);
        create(mid+1,end,root,false);

        BTree tree = new BTree(root);
        return tree;
    }

    public void create( int start, int end,BNode root, boolean isLeft) {

        if(start > end)
            return;

        int mid = (start + end)/2;
        if(visited[mid])
            return;

        BNode node = new BNode(sortedArray[mid]);
        if(isLeft)
            root.left = node;
        else
            root.right = node;

        visited[mid] = true;
        create(start,mid-1,node,true);
        create(mid+1,end,node,false);
    }

    public void inOrderTraversal(BNode root) {

        if(root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};

        CreateBST bst = new CreateBST(array);

        BTree tree = bst.create();

        BNode root = tree.root;
        bst.inOrderTraversal(root);


    }
}
