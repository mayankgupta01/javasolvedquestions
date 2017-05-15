package hiredintech_topcoder.blitz_rounds.round4;

/**
 * Created by mayank.gupta on 27/04/17.
 *
 * Cracking the coding interview : 4.7, edition 5th
 */
public class FirstCommonAncestor {

    BinTree bTree;
    boolean[] found = new boolean[2];
    BinNode firstAncestor;

    FirstCommonAncestor(BinTree bTree) {
        this.bTree = bTree;

        firstAncestor = bTree.root;
    }

    public BinNode find(BinNode a, BinNode b) {

//        dfsFind(bTree.root,a,b);
        boolean[] found = new boolean[2];
        dfsFindFinal(bTree.root,a,b,found);
        return firstAncestor;

    }

    private void dfsFind(BinNode current, BinNode a, BinNode b) {



        if(current == a ) {
            found[0] = true;
            return;
        }

        if(current == b ) {
            found[1] = true;
            return;
        }

        BinNode leftChild = current.left;
        BinNode rightChild = current.right;

        if(leftChild != null && !leftChild.visited) {
            leftChild.visited = true;
            dfsFind(leftChild,a,b);
        }

        if(rightChild != null  && !rightChild.visited){
            rightChild.visited = true;
            dfsFind(rightChild,a,b);
        }

        if(found[0] && found[1]) {
            firstAncestor = current;
            found[0] = false;
            found[1] = false;
        }


    }

    private void dfsFindFinal(BinNode current, BinNode a, BinNode b, boolean[] isFound) {
        boolean[] bothNodesPresent = new boolean[2];

        if(current == a ) {
            isFound[0] = true;
            return;
        }

        if(current == b ) {
            isFound[1] = true;
            return;
        }

        BinNode leftChild = current.left;
        BinNode rightChild = current.right;

        if(leftChild != null && !leftChild.visited) {
            leftChild.visited = true;
            dfsFindFinal(leftChild, a, b, bothNodesPresent);
        }

        if(rightChild != null  && !rightChild.visited){
            rightChild.visited = true;
            dfsFindFinal(rightChild, a, b, bothNodesPresent);
        }

        if(bothNodesPresent[0] && bothNodesPresent[1]) {
            firstAncestor = current;
            isFound[0] = false;
            isFound[1] = false;
            return;
        }

        if(bothNodesPresent[0]) {
            isFound[0] = true;
            return;
        }

        bothNodesPresent[1] = true;
        return;


    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree(10);
        BinNode a = new BinNode(20);
        BinNode b = new BinNode(30);
        BinNode c = new BinNode(40);
        BinNode d = new BinNode(50);
        BinNode e = new BinNode(60);
        BinNode f = new BinNode(70);
        BinNode g = new BinNode(80);
        BinNode h = new BinNode(90);

        binTree.insertLeft(binTree.root,a);
        binTree.insertRight(binTree.root,b);
        binTree.insertLeft(a,c);
        binTree.insertRight(a, d);
        binTree.insertLeft(b,e);
        binTree.insertRight(b, f);
        binTree.insertLeft(c,g);
        binTree.insertRight(c, h);

        FirstCommonAncestor commonAncestor = new FirstCommonAncestor(binTree);
        BinNode result = commonAncestor.find(g,d);
        System.out.println(result.value);
    }

}

class BinNode {
    int value;

    BinNode right;
    BinNode left;
    boolean visited;

    BinNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        visited = false;
    }
}

class BinTree {
    BinNode root;


    BinTree(int value) {
        root = new BinNode(value);

    }

    public void insertRight(BinNode a, BinNode b) {
        a.right = b;

    }

    public void insertLeft(BinNode a, BinNode b) {
        a.left = b;

    }
}
