package cracking_coding_interview.stacks_queues;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by mayank.gupta on 07/05/17.
 *
 * 3.3
 */
public class SetOfStacks {


    private Stack<Stack<Integer>> stackSet;
    private int threshold;
    private int currentSize;

    SetOfStacks(int threshold) {
        if(threshold <=0)
            throw new IllegalArgumentException("Threshold should be greater than zero");

        this.threshold = threshold;
        stackSet = new Stack<>();
        currentSize = 0;
    }

    public void push(int n) {

        if(stackSet.isEmpty() || currentSize >= threshold) {
            Stack<Integer> stack = new Stack<>();
            stack.push(n);
            stackSet.push(stack);
            currentSize = 1;
        }else {
            Stack<Integer> stack = stackSet.peek();
            stack.push(n);
            currentSize += 1;
        }
    }

    public int pop() {
        if(stackSet.isEmpty())
            throw new EmptyStackException();

        Stack<Integer> stack = stackSet.peek();
        int top = stack.pop();

        if(stack.isEmpty()) {
            stackSet.pop();
            currentSize = threshold;
        }else {
            currentSize = currentSize -1;
        }

        return top;
    }

    public boolean isEmpty() {
        return stackSet.isEmpty();
    }

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(3);

        setOfStacks.push(10);
        setOfStacks.push(20);
        setOfStacks.push(30);
        setOfStacks.push(40);
        setOfStacks.push(50);
        setOfStacks.push(60);
        setOfStacks.push(70);
        setOfStacks.push(80);
        setOfStacks.push(90);
        setOfStacks.push(100);

        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());
        System.out.println("Poppingaaa : " + setOfStacks.pop());

    }

}
