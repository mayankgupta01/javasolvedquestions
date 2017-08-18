package grab;

import udemy.practical_ds_algo.linkedlists.Node;

/**
 * Created by mayank.gupta on 30/04/17.
 */
public class NthNode {

    public int find(int nthFromLast, LinkList list) {

        int counter = 0;
        Node nthFromCurrent = null;
        Node top = list.head;

        while(top.getNextNode() != null) {
            counter = counter+1;

            if(counter == nthFromLast) {
                nthFromCurrent = list.head;
            }

            if(counter > nthFromLast) {
                nthFromCurrent = nthFromCurrent.getNextNode();
            }

            top = top.getNextNode();
        }

        return nthFromCurrent == null ? -1 : nthFromCurrent.getValue();

    }

    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.addNode(60);
        list.addNode(70);

        NthNode findNode = new NthNode();

        System.out.println(findNode.find(7,list));
    }
}

class LinkList {
    Node head;

    public void addNode(int value) {
        if(head == null) {
            head = new Node(value);
        }else {
            Node node = new Node(value);
            node.setNextNode(null);
            Node top = head;
            while(top.getNextNode() != null) {
                top = top.getNextNode();
            }

            top.setNextNode(node);
        }
    }

}
