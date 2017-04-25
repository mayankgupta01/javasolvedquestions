package udemy.practical_ds_algo.binary_tree;

import java.util.ArrayList;

/**
 * Created by mayank.gupta on 18/03/17.
 *
 * Check out official solution at : http://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class SelfBalancingBST<T extends Comparable<? super T>> {
    private BSTNode<T> root;

    public SelfBalancingBST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /*Logically clear the tree*/
    public void clear() {
        root = null;
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    private BSTNode<T> insert(T data, BSTNode<T> root) {
        if(root == null) {
            return new BSTNode<>(data);
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if(data.compareTo(root.data) < 0) {
            root.left = insert(data, root.left);
        }
        if(data.compareTo(root.data) > 0) {
            root.right = insert(data, root.right);
        }
        if(data.compareTo(root.data) == 0) {
            root.duplicateCounter++;
            return root;
        }

        leftHeight = height(root.left) + 1;
        rightHeight = height(root.right) + 1;

        if(leftHeight - rightHeight == 2) {
            if(root.left.height == 1) {
                root = rightRotate(root);
            }else {
                root = leftRightRotate(root);
            }
        }
        if(rightHeight - leftHeight == 2) {
            if(root.right.height == 1) {
                root = leftRotate(root);
            }else {
                root = rightLeftRotate(root);
            }
        }
        root.height = height(root);
        return root;
    }

    private BSTNode<T> rightRotate(BSTNode<T> node) {
        BSTNode<T> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = height(node);
        newRoot.height = height(newRoot);
        return newRoot;
    }

    private BSTNode<T> leftRightRotate(BSTNode<T> node) {
        BSTNode<T> child = node.left;
        BSTNode<T> grandChild = child.right;
        child.right = grandChild.left;
        node.left = grandChild.right;
        grandChild.left = child;
        grandChild.right = node;
        node.height = height(node);
        child.height = height(child);
        grandChild.height = height(grandChild);
        return grandChild;
    }

    private BSTNode<T> leftRotate(BSTNode<T> node) {
        BSTNode<T> child = node.right;
        BSTNode<T> grandChild = child.right;
        node.right = child.left;
        child.left = node;
        node.height = height(node);
        grandChild.height = height(grandChild);
        child.height = height(child);
        return child;
    }

    private BSTNode<T> rightLeftRotate(BSTNode<T> node) {
        BSTNode<T> child = node.right;
        BSTNode<T> grandChild = child.left;
        node.right = grandChild.left;
        child.left = grandChild.right;
        grandChild.left = node;
        grandChild.right = child;
        child.height = height(child);
        node.height = height(node);
        grandChild.height = height(grandChild);
        return grandChild;
    }

    private int height(BSTNode<T> node) {
        if (node == null){
            return -1;
        }
        return Math.max(height(node.left),height(node.right)) + 1;
    }

    public ArrayList<BSTNode<T>> inOrderTraversal() {
        ArrayList<BSTNode<T>> orderedNodes = new ArrayList<>();
        if(root == null) {
            System.out.println("Binary Tree is empty!");
            return orderedNodes;
        }
        inOrderTraversal(root,orderedNodes);
        return orderedNodes;
    }

    private void inOrderTraversal(BSTNode<T> root, ArrayList<BSTNode<T>> orderedNodes) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, orderedNodes);
        System.out.print(root.data.toString() + ", ");
        orderedNodes.add(root);
        inOrderTraversal(root.right,orderedNodes);
    }
}

class BSTNode<T> {
    BSTNode<T> left;
    BSTNode<T> right;
    T data;
    int height;
    int duplicateCounter = 0;

    public BSTNode(T data) {
        this.data = data;
        left = right = null;
        height = 0;
    }
}

class TestSelfBalancingTree {
    public static void main(String[] args) {
//        testLeftRotation();
//        testRightRotation();
        testleftRightRotation();
    }

    public static void testLeftRotation() {
        SelfBalancingBST<Integer> sb = new SelfBalancingBST<>();
        sb.insert(100);
        sb.insert(200);
        sb.insert(300);
        sb.insert(400);
        sb.insert(500);

        ArrayList<BSTNode<Integer>> arr = new ArrayList<>();
        arr = sb.inOrderTraversal();
    }
/*
* Result should be :
*                                 900
*                                /   \
*                              700   1000
*                             /  \
*                          600   800
*
* Original :
*                          1000
*                          /
*                       900
*                       /
*                     800
  *                   /
    *               700
        *           /
            *     600
*
*
* */
    public static void testRightRotation() {
        SelfBalancingBST<Integer> sb = new SelfBalancingBST<>();
        sb.insert(1000);
        sb.insert(900);
        sb.insert(800);
        sb.insert(700);
        sb.insert(600);

        ArrayList<BSTNode<Integer>> arr = new ArrayList<>();
        arr = sb.inOrderTraversal();
    }

    /*
    * Original :          13                             Final :   13
         *               /  \                                     /  \
         *              10  15                                  6    15
          *            /  \   \                                / \    \
          *           5   11  16                              5  10    16
          *         /  \                                     /   / \
          *        4   6                                    4   7   11
          *             \
          *              7
    *
    *
    * */
    public static void testleftRightRotation() {
        SelfBalancingBST<Integer> sb = new SelfBalancingBST<>();
        sb.insert(13);
        sb.insert(10);
        sb.insert(15);
        sb.insert(16);
        sb.insert(5);
        sb.insert(11);
        sb.insert(4);
        sb.insert(6);

        /*Test left right rotation by inserting 7*/
        sb.insert(7);
    }
}

