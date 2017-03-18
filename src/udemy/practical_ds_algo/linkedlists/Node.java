package udemy.practical_ds_algo.linkedlists;

/**
 * Created by mayank.gupta on 12/02/17.
 * Basic DS for creating a linked list. We are going to use recursive Data structure. A node will have a variable pointing to another
 * node object
 */
public class Node {

    private int value;
    private Node nextNode = null;

    public Node(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public int getValue() {
        return value;
    }
}

class testLinkedList {
    public static void main(String[] args) {
        Node nodeA = new Node(10);
        Node nodeB = new Node(20);
        Node nodeC = new Node(30);
        Node nodeD = new Node(40);

        nodeA.setNextNode(nodeB);
        nodeB.setNextNode(nodeC);
        nodeC.setNextNode(nodeD);

        System.out.println(listLength(nodeA));
        System.out.println(listLength(nodeC));
        System.out.println(listLength(nodeD));
    }

    public static int listLength(Node node) {
        int counter = 1;
        while(node.getNextNode()!=null) {
            counter++;
            node = node.getNextNode();
        }
        return  counter;
    }
}