package udemy.practical_ds_algo.binary_tree;

import udemy.practical_ds_algo.search_algos.BinarySearch;

import java.util.ArrayList;

/**
 * Created by mayank.gupta on 17/03/17.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    /*implement insert operation into the tree*/
    public void insert(T data) {
        root = insert(data, root);
    }

    private Node<T> insert(T data, Node<T> root) {
        if(root == null) {
            return new Node<T>(data);
        }
        if(data.compareTo(root.data) <= 0) {
            root.left = insert(data, root.left);
        }

        if(data.compareTo(root.data) > 0) {
            root.right = insert(data, root.right);
        }
        return root;
    }

    public boolean search(T data) {
        return search(data,root);
    }

    private boolean search(T data, Node<T> root) {
        boolean result = false;
        if(root == null)
            return false;
        if(root.data.compareTo(data) == 0)
            return true;
        if(root.data.compareTo(data) < 0)
            result =  search(data,root.right);
        if(root.data.compareTo(data) > 0)
            result =  search(data,root.left);
        return result;
    }

    public boolean delete(T data) {
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeftChild = false;
        while(current.data.compareTo(data)!= 0) {
            parent = current;
            if(current.data.compareTo(data) < 0) {
                current = current.right;
            }
            if(current.data.compareTo(data) > 0) {
                current = current.left;
            }
            if(current == null) {
                return false;
            }
        }
        if(current == root) {
            if(root.left == null && root.right == null) {
                root = null;
            }
            if(root.left != null && root.right == null) {
                root = root.left;
            }
            if(root.left == null && root.right != null) {
                root = root.right;
            }
            if(root.left != null && root.right != null) {
                Node<T> succcessor = getSuccessor(root);
                succcessor.left = root.left;
                root = succcessor;
            }
            return  true;
        }
        return deleteNode(parent,isLeftChild);
    }

    private boolean deleteNode(Node<T> parent, boolean isLeftChild) {
        Node<T> nodeToDelete = isLeftChild ? parent.left : parent.right;
        /*Case 1 : when node to delete doesnt have any children*/
        if(nodeToDelete.left == null && nodeToDelete.right == null) {
            if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else {
            /*Case 3 : When node has two children*/
            if(nodeToDelete.left != null && nodeToDelete.right != null) {
                Node<T> successor = getSuccessor(nodeToDelete);
                if(isLeftChild) {
                    parent.left = successor;
                }else {
                    parent.right = successor;
                }
                successor.left = nodeToDelete.left;
            }
            /*Case 2 : When node has only one child*/
            else {
                if(nodeToDelete.left != null) {
                    if(isLeftChild)
                        parent.left = nodeToDelete.left;
                    else
                        parent.right = nodeToDelete.left;
                }
                else {
                    if(isLeftChild)
                        parent.left = nodeToDelete.right;
                    else
                        parent.right = nodeToDelete.right;
                }
            }
        }
        return true;
    }

    private Node<T> getSuccessor(Node<T> nodeToDelete) {
        /*Get the smallest node of the right sub-tree of node to be deleted. This will become the successor*/
        Node<T> successorParent = null;
        Node<T> successor = null;
        Node<T> current = nodeToDelete.right;
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        /*If successor has a right child, then put the right child as the left child of successor's parent*/
        if(successor != nodeToDelete.right) {
            successorParent.left = successor.right;
            successor.right = nodeToDelete.right;
        }
        return successor;
    }

    public ArrayList<Node<T>> inOrderTraversal() {
        ArrayList<Node<T>> orderedNodes = new ArrayList<>();
        if(root == null) {
            System.out.println("Binary Tree is empty!");
            return orderedNodes;
        }
        inOrderTraversal(root,orderedNodes);
        return orderedNodes;
    }

    private void inOrderTraversal(Node<T> root, ArrayList<Node<T>> orderedNodes) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, orderedNodes);
        System.out.print(root.data.toString() + ", ");
        orderedNodes.add(root);
        inOrderTraversal(root.right,orderedNodes);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node<T> root) {
        if(root == null)
            return;
        System.out.print(root.data.toString() + ", ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void convertToBalancedBST() {
        ArrayList<Node<T>> orderedNodes = inOrderTraversal();
        int numOfNodes = orderedNodes.size();
        root = convertToBalancedBST(orderedNodes,0,numOfNodes - 1);
    }

    private Node<T> convertToBalancedBST(ArrayList<Node<T>> orderedNodes, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end)/2;
        Node<T> root = orderedNodes.get(mid);
        root.left = convertToBalancedBST(orderedNodes,start,mid -1);
        root.right = convertToBalancedBST(orderedNodes,mid+1,end);
        return root;
    }

    public boolean checkTreeIsBalanced() {
        if (root == null)
            return true;

        return isBalanced(root);
    }


    private boolean isBalanced(Node<T> root) {
        if(root == null)
            return true;

        int leftHeight = calculateLeftSubtreeHeight(root);
        int rightHeight = calculateRightSubtreeHeight(root);
        return ((Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right));
    }

    private int calculateLeftSubtreeHeight(Node<T> root) {
        if(root == null) {
            return -1;
        }
        return 1 + calculateLeftSubtreeHeight(root.left);
    }

    private int calculateRightSubtreeHeight(Node<T> root) {
        if(root == null) {
            return -1;
        }
        return 1 + calculateRightSubtreeHeight(root.right);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root.data.toString() +
                '}';
    }
}

class BinaryTree<T extends Comparable<? super T>> {
    private Node<T> root;

    public BinaryTree(T data) {
        this.root = new Node<>(data);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insertLeft(T data, Node<T> node) {
        node.left = new Node<>(data);
    }

    public void insertRight(T data, Node<T> node) {
        node.right = new Node<>(data);
    }

    public boolean isBST(T min, T max) {
        return isBST(root, min, max);
    }

    public boolean isBST(Node<T> root, T min, T max) {
        if(root == null)
            return true;

        if (root.data.compareTo(min) <= 0 || root.data.compareTo(max) >= 0)
            return false;

        return (isBST(root.left,min,root.data) && isBST(root.right,root.data,max));
    }
}
/*Important point here : Read in detail : http://stackoverflow.com/questions/20793082/java-comparing-generic-types
*
* class Node<t> implements Comparable<t> Vs class Node <T extends Comparable<? super T>>
*
* We need Comparable cebause without it, we will not be able to compare nodes' data to determine where nodes should be
    * inserted. As data variable is generic, we cannot use >,<, operators, these can be used only on primitive types.
    * Hence, we need some way to be able to compare node values. Thus, the statement in insert method if (data <= root.data)
    * will throw compile error "Operator <= cannot be applied to T"
    * One way is to implement Comparable interface, the problem with that, is we have to implement compareTo method for
    * generic T below. This we won't be able to do , as we don't know what T is.
    * Another way is to extend Comparable interface to T, that means, anyone using our code should use T as a data type
    * which implements Comparable and hence should already have an implemented compareTo method.
    *
    * After this, we can use if (data.compareTo(root.data))
    *
    *
    * Meaning of  <? super T>
    *     public class SortedList< T extends Comparable< ? super T> > extends LinkedList< T >
    *     super in Generics is the opposite of extends. Instead of saying the comparable's generic type has to be a subclass of T,
    *     it is saying it has to be a superclass of T. The distinction is important because extends tells you what you
    *     can get out of a class (you get at least this, perhaps a subclass). super tells you what you can put into the
    *     class (at most this, perhaps a superclass).
    *     In this specific case, what it is saying is that the type has to implement comparable of itself or
    *     its superclass. So consider java.util.Date. It implements Comparable<Date>. But what about java.sql.Date? It implements Comparable<java.util.Date> as well.
    *     Without the super signature, SortedList would not be able accept the type of java.sql.Date, because it doesn't implement a Comparable of itself, but rather of a super class of itself.
    *
    *     GOOD READ : BST Balancing and height -
    *     http://stackoverflow.com/questions/8015630/definition-of-a-balanced-tree
    *
    *     Balance a Tree: http://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
    *
    *     Determine if Tree is balanced: http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
    *
    *     Handling duplicates in BST : http://stackoverflow.com/questions/300935/are-duplicate-keys-allowed-in-the-definition-of-binary-search-trees
    *     Best way to handle duplicates is to use a list or use a counter for number of duplicates at the node level and represent all duplicates in the same node
    *     Otherwise, if we use different nodes to store same values, using left child <= parent, we will run into problems
    *     when balancing the tree.
    *
* */
class Node<T>  {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        this.data = value;
        left = right = null;
    }

    public Node() {
        this.data = null;
        left = right = null;
    }
}

class TestBinaryTree<T extends Comparable<? super T>> {
    public static void main(String[] args) {

        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        TestBinaryTree<Integer> testBinaryTree = new TestBinaryTree<>();
//        testBinaryTree.testIfTreeIsBalanced();
//        testBinaryTree.testInOrderTraversal(btree);
        testBinaryTree.testTreeBalancing();

        /*Test Delete node*/
//        System.out.println("Able to delete 200 from BST? :" + btree.delete(200));
//        System.out.println(("************ In Order *********"));
//        btree.inOrderTraversal();

        /*Search for value in BST*/
//        int value = 105;
//        if(btree.search(value))
//            System.out.println("Value is present in BST :" + value);
//        else
//            System.out.println("Value is not present in BST : " + value);

        /*Test is tree is Binary Search Tree or not*/
        /*Test if tree is BST*/
//        BinaryTree<Integer> binaryTree = new BinaryTree<>(100);
//        binaryTree.insertLeft(100,binaryTree.getRoot());
//        binaryTree.insertRight(200, binaryTree.getRoot());
//        System.out.println();
//        System.out.println("Tree is BST ? " + binaryTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE));
//        Node<Integer> root = btree.getRoot();
//        System.out.println("BinarySearchTree is BST ? " + binaryTree.isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    public void testInOrderTraversal(BinarySearchTree<Integer> btree) {
        btree.insert(100);
        btree.insert(200);
        btree.insert(50);
        btree.insert(90);
        btree.insert(250);
        btree.insert(180);
        System.out.println(btree.toString());
        System.out.println(("************ In Order *********"));
        btree.inOrderTraversal();
        System.out.println();
        System.out.println("************ Pre Order: Root, left, right *********");
        btree.preOrderTraversal();
        System.out.println();
    }

    public void testTreeBalancing() {
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(100);
        btree.insert(200);
        btree.insert(300);
        btree.insert(400);
        btree.insert(500);
        btree.insert(600);
        btree.insert(700);
        btree.insert(800);
        btree.convertToBalancedBST();
        /*
        * Post Balanced structure
        *
        *                                400
        *                              /      \
        *                             200      600
        *                            /  \      /  \
        *                         100   300  500  700
        *                                           \
        *                                           800
        *
        *
        * */
        System.out.println("Post balancing the tree is now balanced? : " + btree.checkTreeIsBalanced());
        btree.inOrderTraversal();
    }

    public void testIfTreeIsBalanced() {
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(100);
        btree.insert(200);
        btree.insert(300);
        btree.insert(400);
        btree.insert(500);
        btree.insert(600);
        btree.insert(700);
        btree.insert(800);
        boolean result = btree.checkTreeIsBalanced();
        System.out.println("The tree is balanced. This statement is : " + result);
    }
}
