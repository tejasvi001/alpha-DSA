package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversalUsingStack {
	public static Queue<Integer> reverse(Queue<Integer> q){
		Stack<Integer> s=new Stack<>();
		while(!q.isEmpty()) {
			s.push(q.remove());
		}
		while(!s.isEmpty()) {
			q.add(s.pop());
		}
		return q;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=10;i++) {
			q.add(i);
		}
		q=reverse(q);
		System.out.println(q);
	}

}
