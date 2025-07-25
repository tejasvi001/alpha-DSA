package queues;

import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
	Deque<Integer> queue;
	public QueueUsingDeque() {
		// TODO Auto-generated constructor stub
		queue=new LinkedList<>();
	}
	public void add(int x) {
		queue.addLast(x);
	}
	public int peek() {
		return queue.getFirst();
	}
	public int remove() {
		return queue.removeFirst();
	}
	public boolean empty() {
		return queue.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingDeque obj=new QueueUsingDeque();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		System.out.println(obj.queue);
		System.out.println("PEEK "+obj.peek());
		System.out.println("Remove "+obj.remove());
		System.out.println(obj.queue);
	}

}
