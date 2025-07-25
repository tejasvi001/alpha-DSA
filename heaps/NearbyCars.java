package heaps;

import java.util.PriorityQueue;

public class NearbyCars {
	static class Info implements Comparable<Info>{
		int distance;
		int index;
		Info(int index,int distance){
			this.index=index;
			this.distance=distance;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return this.distance-o.distance;
		}
	}
	public NearbyCars() {
		// TODO Auto-generated constructor stub
	}
	public static void getNearbyCars(int arr[][],int k) {
		PriorityQueue<Info> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			int dist=(arr[i][0]*arr[i][0])+(arr[i][1]*arr[i][1]);
			pq.add(new Info(i,dist));
		}
		for(int i=0;i<k;i++) {
			System.out.println(pq.peek().index+" : "+ pq.peek().distance);
			pq.remove();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {{3,3},{5,-1},{-2,4}};
		getNearbyCars(arr,2);
	}

}
