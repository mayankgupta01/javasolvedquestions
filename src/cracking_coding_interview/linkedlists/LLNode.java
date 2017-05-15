package cracking_coding_interview.linkedlists;

/**
 * Created by mayank.gupta on 06/05/17.
 */
public class LLNode {

    int value;

    LLNode next;
    LLNode prev;

    LLNode(int value) {
        this.value = value;
        next = prev = null;
    }
}
