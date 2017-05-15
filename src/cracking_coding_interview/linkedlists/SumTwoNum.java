package cracking_coding_interview.linkedlists;

import java.util.Stack;

/**
 * Created by mayank.gupta on 06/05/17.
 */
public class SumTwoNum {

    public LLNode sum(LLNode node1, LLNode node2) {

        /*Since head is at least significant position*/
        int sumToForward = 0;

        int sumNodeValue = 0;
        LLNode head = null;
        LLNode current = null;

        while(node1 != null || node2 != null) {
            sumNodeValue = (node1.value + node2.value + sumToForward) % 10;
            sumToForward = (node1.value + node2.value + sumToForward) / 10;

            if(head == null) {
                head = new LLNode(sumNodeValue);
                current = head;
            }else {
                current.next = new LLNode(sumNodeValue);
                current = current.next;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LLNode head1 = new LLNode(1);
        LLNode head2 = new LLNode(2);

        head1.next = new LLNode(2);
        head2.next = new LLNode(2);

        head1.next.next = new LLNode(4);
//        head2.next.next = new LLNode(5);

        SumTwoNum s = new SumTwoNum();

        LLNode result = s.sum(head1, head2);
        Stack<Integer> stack = new Stack<>();

        while(result != null) {
            stack.push(result.value);
            result = result.next;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
