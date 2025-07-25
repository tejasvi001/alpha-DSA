package queues;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
	private Deque<Integer> stack;
	StackUsingDeque(){
		stack=new LinkedList<>();
	}
	public int peek() {
		return stack.getLast();
	}
	public int pop() {
		return stack.removeLast();
	}
	public void push(int x) {
		stack.addLast(x);
	}
	public boolean empty() {
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingDeque obj=new StackUsingDeque();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.stack);
		System.out.println("peek "+obj.peek());
		System.out.println("pop "+obj.pop());
		System.out.println(obj.stack);		
	}

}
