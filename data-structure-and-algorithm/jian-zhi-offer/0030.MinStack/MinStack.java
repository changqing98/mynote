import java.util.*;
public class MinStack {
    Stack<Integer> resultStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(final int x) {
        resultStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int num = resultStack.pop();
        if(minStack.peek() == num){
            minStack.pop();
        }
    }

    public int top() {
        return resultStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
