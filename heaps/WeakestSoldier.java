package heaps;

import java.util.PriorityQueue;

import heaps.NearbyCars.Info;

public class WeakestSoldier {
	static class Info implements Comparable<Info>{
		int index;
		int soldiers;
		Info(int index, int soldiers){
			this.index=index;
			this.soldiers= soldiers;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			if(this.soldiers==o.soldiers) {
				return this.index-o.index;
			}
			return this.soldiers-o.soldiers;
		}
	}
	public static void weakestSoldiers(int arr[][],int k) {
		PriorityQueue<Info> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			int s=0;
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==1) {
					s++;
				}
			}
			pq.add(new Info(i,s));
		}
		for(int i=0;i<k;i++) {
			System.out.println(pq.peek().index+" : "+ pq.peek().soldiers);
			pq.remove();
		}
	}
	public WeakestSoldier() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {
				{1,0,0,0},
				{1,1,1,1},
				{1,0,0,0},
				{1,0,0,0}
		};
		weakestSoldiers(arr,2);
	}

}
