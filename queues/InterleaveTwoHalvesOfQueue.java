package queues;

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveTwoHalvesOfQueue {
	
	public static Queue<Integer> interleave(Queue<Integer> queue){
		Queue<Integer> q2=new LinkedList<>();
		int size=queue.size()/2;
		for(int i=0;i<size;i++) {
			q2.add(queue.remove());
		}
		while(!q2.isEmpty()) {
			queue.add(q2.remove());
			queue.add(queue.remove());
		}
		return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=10;i++) {
			q.add(i);
		}
		q=interleave(q);
		System.out.println(q);
	}

}
