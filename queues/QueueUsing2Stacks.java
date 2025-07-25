package queues;

import java.util.Stack;

public class QueueUsing2Stacks {
    Stack<Integer> q;

    public QueueUsing2Stacks() {
        q = new Stack<>();
    }

    public void push(int x) {
        q.push(x);
    }

    public int pop() {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.pop());
        }
        int x = stack.pop();
        while (!stack.isEmpty()) {
            q.push(stack.pop());
        }
        return x;
    }

    public int peek() {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.pop());
        }
        int x = stack.peek();
        while (!stack.isEmpty()) {
            q.push(stack.pop());
        }
        return x;
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsing2Stacks queue = new QueueUsing2Stacks();
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Peek: " + queue.peek());  // Output: 10
        System.out.println("Pop: " + queue.pop());    // Output: 10
        System.out.println("Peek: " + queue.peek());  // Output: 20
        System.out.println("Empty: " + queue.empty()); // Output: false
    }
}
