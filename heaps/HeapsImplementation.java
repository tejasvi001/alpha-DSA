package heaps;

import java.util.ArrayList;

public class HeapsImplementation {
	private ArrayList<Integer> heap;
	public HeapsImplementation() {
		// TODO Auto-generated constructor stub
		heap=new ArrayList<>();
	}
	public void add(int x) {
		//adding at last
		heap.add(heap.size(),x);
		//calculating parent and child indexes
		int child=heap.size()-1;
		int parent=(child-1)/2;
		while(heap.get(child)<heap.get(parent)) {
			//swap
			int temp=heap.get(child);
			heap.set(child, heap.get(parent));
			heap.set(parent, temp);
			//updation in parent and child idx after iteration
			child=parent;
			parent=(child-1)/2;
		}
	}
	public int peek() {
		return heap.size()>0?heap.get(0):-1;
	}
	private void heapify(int i) {
		int left=2*i+1;
		int right=2*i+2;
		int minIdx=i;
	
		//comparing with left
		if(left<heap.size()&&heap.get(minIdx)>heap.get(left)) {
			minIdx=left;
		}
		//comparing with right
		if(right<heap.size()&&heap.get(minIdx)>heap.get(right)) {
			minIdx=right;
		}
		//swapping 
		if(minIdx!=i) {
			int temp=heap.get(i);
			heap.set(i, heap.get(minIdx));
			heap.set(minIdx, temp);
			heapify(minIdx);
		}
	}
	public int remove() {
		//checking for empty heap
		if(heap.size()==0) 	return -1;
		//getting the value at first index
		int x=heap.get(0);
		//SWAP first and last element
		heap.set(0, heap.get(heap.size()-1));
		heap.set(heap.size()-1, x);
		//delete the last index value
		heap.remove(heap.size()-1);
		//heapify
		heapify(0);
		//returning the value
		return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapsImplementation obj=new HeapsImplementation();
		System.out.println(obj.peek());
		int arr[]= {2,3,4,5,10};
		for(int i:arr) {
			obj.add(i);
		}
		System.out.println(obj.heap);
		obj.add(1);
		System.out.println(obj.heap);
		System.out.println(obj.peek());
		
		System.out.println(obj.remove());
		System.out.println(obj.heap);
	}

}
