package divideAndConquer;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,10,5,9,2,4};
		System.out.println("Before Sorting");
		printArr(arr);
		mergeSort(arr,0,arr.length-1);
		System.out.println("After Sorting");
		printArr(arr);
	}
	public static void mergeSort(int arr[],int si,int ei) {
		if(si>=ei) {
			return;
		}
		int mid=si+(ei-si)/2;
		mergeSort(arr,si,mid);
		mergeSort(arr,mid+1,ei);
		merge(arr,si,mid,ei);
	}
	public static void merge(int arr[],int si,int mid, int ei) {
		int i=si,j=mid+1;
		int temp[]=new int[(ei-si)+1];
		int idx=0;
		while(i<=mid&&j<=ei) {
			if(arr[i]<=arr[j]) {
				temp[idx++]=arr[i++];
			}
			else {
				temp[idx++]=arr[j++];
			}
		}
		while(i<=mid) {
			temp[idx++]=arr[i++];
		}
		while(j<=ei) {
			temp[idx++]=arr[j++];
		}
		for(i=0,j=si;j<=ei;j++,i++) {
			arr[j]=temp[i];
		}
		printArr(arr);
		
	}
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
