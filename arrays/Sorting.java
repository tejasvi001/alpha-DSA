package arrays;

import java.util.Arrays;

public class Sorting {
	int arr[]= {91,12,34,4};
	public static void bubbleSort(int arr[]) {
		int t,i,j;
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		System.out.println("After Bubble Sort");
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void selectionSort(int arr[]) {
		int t,i,j;
		for(i=0;i<arr.length;i++) {
			for(j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					t=arr[j];
					arr[j]=arr[i];
					arr[i]=t;
				}
			}
		}
		System.out.println("After Selection Sort");
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	} 
	public static void insertionSort(int arr[]) {
		int i,j,t;
		for(i=1;i<arr.length;i++) {
				t=arr[i];
				for(j=i-1;j>=0&&arr[j]>t;j--) {
					arr[j+1]=arr[j];
				}
				arr[j+1]=t;
			
			System.out.println("after iteration :"+i);
			printArr(arr);
		}
	}
	public static void countingSort(int arr[]) {
		int max=Integer.MIN_VALUE;
		for(int i:arr) {
			max=Math.max(max, i);
		}
		int count[]=new int[max+1];
		Arrays.fill(count, 0);
		for(int i:arr) {
			count[i]++;
		}
		int i=0;
		int j=0;
		while(i<count.length) {
			if(count[i]==0) {
				i++;
			}else {
				arr[j]=i;
				j++;
				count[i]=count[i]-1;
			}
		}
		printArr(arr);
	}
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {91,12,34,4};
//		bubbleSort(arr);
//		selectionSort(arr);
//		insertionSort(arr);
		int arr2[]= {1,4,1,3,2,4,3,7};
		countingSort(arr2);
	}

}
