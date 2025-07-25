package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	static class Info implements Comparable<Info>{
		int index;
		int val;
		Info(int index,int val){
			this.index=index;
			this.val=val;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return this.val-o.val;
		}
		
	}
	public SlidingWindowMaximum() {
		// TODO Auto-generated constructor stub
	}
	public static int[] slidingwindowMax(int arr[],int k) {
		int res[]=new int[arr.length-k+1];
		PriorityQueue<Info> pq=new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<k;i++) {
			pq.add(new Info(i,arr[i]));
		}
		res[0]=pq.peek().val;
		for(int i=k;i<arr.length;i++) {
			while(pq.peek().index<=i-k) {
				pq.remove();
			}
			pq.add(new Info(i,arr[i]));
			res[i-k+1]=pq.peek().val;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,-1,-3,5,3,6,7};
		int res[]=slidingwindowMax(arr,3);
		for(int i:res) {
			System.out.print(i+" ");
		}
	}

}
