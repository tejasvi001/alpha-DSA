package heaps;

import java.util.ArrayList;

public class HeapSort {
	public void heapSort(int arr[]) {
		int n=arr.length;
		//step 1: build maxHeap
		for(int i=n/2;i>=0;i--) {
			heapify(arr,i,n);
		}
		for(int i=n-1;i>0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,0,i);
		}
	}
	public void heapify(int arr[],int i,int size) {
		int left=2*i+1;
		int right=2*i+2;
		int maxIdx=i;
		if(left<size&&arr[maxIdx]<arr[left]) {
			maxIdx=left;
		}
		if(right<size&&arr[maxIdx]<arr[right]) {
			maxIdx=right;
		}
		if(maxIdx!=i) {
			int temp=arr[i];
			arr[i]=arr[maxIdx];
			arr[maxIdx]=temp;
			
			heapify(arr,maxIdx,size);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort obj=new HeapSort();
		int arr[]= {1,4,2,5,3};
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		obj.heapSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}

}
