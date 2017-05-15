package hiredintech_topcoder.graphs.binarytree;

import java.util.*;

/**
 * Created by mayank.gupta on 13/05/17.
 */
public class TreeOperations {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public List<ArrayList<Integer>> serialize() {

        List<ArrayList<Integer>> serializableForm = new ArrayList<>();

        /*To serialize any binary tree we need preorder and inorder traversal of it to be able to rebuild it uniquely*/
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();

        preOrder(preOrder,root);
        inOrder(inOrder,root);

        serializableForm.add(preOrder);
        serializableForm.add(inOrder);

        return serializableForm;

    }

    public void preOrder(ArrayList<Integer> list, Node node) {

        if(node == null) {
            return;
        }

        list.add(node.data);
        preOrder(list,node.left);
        preOrder(list,node.right);
    }

    public void inOrder(ArrayList<Integer> list, Node node) {

        if(node == null)
            return;

        preOrder(list,node.left);
        list.add(node.data);
        preOrder(list,node.right);
    }


    public Node constructTree(String[] preOrder) {

        if(preOrder.length == 0)
            return  null;

        int[] index = new int[1];
        index[0] = 0;

        Node root = constructTree(preOrder,index);
        return root;
    }

    public Node constructTree(String[] preOrder,int[] index) {

        /*if index is out of range return null*/
        if(index[0] < 0 || index[0] >= preOrder.length)
            return null;

        if(preOrder[index[0]].equals("#"))
            return null;

        Node node = new Node(Integer.parseInt(preOrder[index[0]]));
        /*Starting from index, 1st number less than or equal to key is left child, 1st num greater than key is right child */

        index[0] = index[0]+1;
        node.left = constructTree(preOrder,index);

        index[0] = index[0] +1;
        node.right = constructTree(preOrder,index);

        return node;

    }

    public String[] serializeLevelOrder(Node root) {
        if(root == null)
            return null;

        /*Mark '#' as null */
        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            Node top = queue.poll();

            if(top == null) {
                sb.append("#,");
            }
            else {
                sb.append(top.data + ",");
                queue.offer(top.left);
                queue.offer(top.right);
            }
        }

        sb.deleteCharAt(sb.length()-1);
        return  sb.toString().split(",");
    }

    public Node deserializeLevelOrder(String[] levelOrder) {
        if(levelOrder.length == 0)
            return  null;

        Node root = new Node(Integer.parseInt(levelOrder[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i=1;

        while(!queue.isEmpty()) {

            Node top = queue.poll();

            if(i < levelOrder.length && !levelOrder[i].equals("#")) {
                top.left = new Node(Integer.parseInt(levelOrder[i]));
                queue.offer(top.left);
            }
            i++;

            if(i < levelOrder.length && !levelOrder[i].equals("#")){
                top.right = new Node(Integer.parseInt(levelOrder[i]));
                queue.offer(top.right);
            }
            i++;
        }
        return root;

    }


    public static void main(String[] args) {
        String[] preOrder = new String[]{"10","5","1","#","#","7","#","#","12","#","14","#","#"};
        String[] levelOrder = new String[]{"10","#","7","1","12","#","14","15"};
        TreeOperations tp = new TreeOperations();

        Node root = tp.constructTree(preOrder);

        tp.root = root;

        Node newRoot = tp.deserializeLevelOrder(levelOrder);
        System.out.println(Arrays.toString(tp.serializeLevelOrder(newRoot)));

    }

}
