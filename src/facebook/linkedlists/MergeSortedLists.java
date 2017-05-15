package facebook.linkedlists;

/**
 * Created by mayank.gupta on 09/05/17.
 */
public class MergeSortedLists {



        public LinkedListFacebook merge(LinkedListFacebook head1, LinkedListFacebook head2) {

            LinkedListFacebook resultList = new LinkedListFacebook();

            LinkedNode node1 = head1.head;
            LinkedNode node2 = head2.head;

            if(head1.size == 0 && head2.size == 0)
                return null;

            if(head1.size == 0)
                return head2;

            if(head2.size == 0)
                return head1;

            while(node1 != null || node2 != null) {

                if(node1 == null) {
                    resultList.addNode(node2.value);
                    node2 = node2.next;
                    continue;
                }
                if(node2 == null) {
                    resultList.addNode(node1.value);
                    node1 = node1.next;
                    continue;
                }
                if(node1.value <= node2.value) {
                    resultList.addNode(node1.value);
                    node1 = node1.next;
                }else {
                    resultList.addNode(node2.value);
                    node2 = node2.next;
                }
            }

            return resultList;

        }


    public LinkedListFacebook mergeRecursive(LinkedListFacebook head1, LinkedListFacebook head2) {

        LinkedListFacebook resultList = new LinkedListFacebook();

        LinkedNode node1 = head1.head;
        LinkedNode node2 = head2.head;

        if(head1.size == 0 && head2.size == 0)
            return null;

        if(head1.size == 0)
            return head2;

        if(head2.size == 0)
            return head1;

        resultList.addNode(merge(node1, node2));
        return resultList;
    }

    public LinkedNode merge(LinkedNode node1, LinkedNode node2) {
        LinkedNode result = null;
        if(node1 == null)
           return node2;

        if(node2 == null)
            return node1;

        if(node1.value <= node2.value) {
            result = node1;
            result.next = merge(node1.next,node2);
        }else {
            result = node2;
            result.next = merge(node1,node2.next);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedListFacebook head1 = new LinkedListFacebook();
        head1.addNode(10);
        head1.addNode(20);
        head1.addNode(30);
        head1.addNode(40);

        LinkedListFacebook head2 = new LinkedListFacebook();
        head2.addNode(5);
        head2.addNode(15);
        head2.addNode(18);
        head2.addNode(35);
        head2.addNode(45);

        MergeSortedLists mg = new MergeSortedLists();

//        LinkedListFacebook result = mg.merge(head1,head2);
        LinkedListFacebook result = mg.mergeRecursive(head1, head2);
        result.print();

    }

}


    class LinkedNode {

        LinkedNode next;
        int value;

        LinkedNode(int data) {
            this.value = data;
            this.next = null;
        }


    }

    class LinkedListFacebook {

        LinkedNode head;
        int size = 0;

        public void addNode(int data) {

            if(head == null) {
                head = new LinkedNode(data);
                return;
            }

            LinkedNode node = head;
            while(node.next != null) {

                node = node.next;
            }

            node.next = new LinkedNode(data);
            size +=1;
        }

        public void addNode(LinkedNode node) {

            if(head == null) {
                head = node;
                return;
            }

            LinkedNode thisNode = head;
            while(thisNode.next != null) {
                thisNode = thisNode.next;
            }

            thisNode.next = node;
        }

        public void print() {
            LinkedNode node = head;

            while(node!=null) {
                System.out.print(node.value + " ->");
                node = node.next;
            }
        }
    }



