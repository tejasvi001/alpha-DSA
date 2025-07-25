package heaps;

import java.util.PriorityQueue;

public class ConnectRopes {

	public ConnectRopes() {
		// TODO Auto-generated constructor stub
	}
	public static int connectRopes(int arr[]) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int totalCost=0;
		for(int i:arr)
			pq.add(i);
		while(pq.size()>1) {
			int min1=pq.remove();
			int min2=pq.remove();
			totalCost+=(min1+min2);
			pq.add(min1+min2);
		}
		return totalCost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4,3,2,6};
		System.out.println(connectRopes(arr));
	}

}
