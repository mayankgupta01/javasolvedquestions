package cracking_coding_interview.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mayank.gupta on 06/05/17.
 */
public class RemoveDuplicates {
    LLNode head;

    public void addToTail(int data) {

        if(head == null) {
            head = new LLNode(data);
            return;
        }

        LLNode end = new LLNode(data);
        LLNode cur = head;

        while(cur.next != null) {

            cur = cur.next;
        }

        cur.next = end;

        /*If singly linked list then no previos pointer*/
    }

    public void removeDup() {

        LLNode cur = head;
        LLNode prev = head;
        Set<Integer> uniqueSet = new HashSet<>();

        while(cur != null) {

            if (!uniqueSet.contains(cur.value)) {
                uniqueSet.add(cur.value);
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                cur = cur.next;
            }
        }
    }

    public void printList() {
        LLNode cur = head;

        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println(" ***********************  ");
    }

    public static void main(String[] args) {
        RemoveDuplicates rm = new RemoveDuplicates();

        rm.addToTail(10);
        rm.addToTail(10);
        rm.addToTail(10);
        rm.addToTail(10);
        rm.addToTail(20);
        rm.addToTail(20);
        rm.addToTail(20);
        rm.addToTail(20);
        rm.addToTail(30);
        rm.addToTail(30);
        rm.addToTail(40);
        rm.addToTail(50);
        rm.addToTail(60);

        rm.printList();
        rm.removeDup();
        rm.printList();

    }



}
