package divideAndConquer;

public class QuickSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,3,10,5,9,2,4};
		System.out.println("Before Sorting");
		printArr(arr);
		quickSort(arr,0,arr.length-1);
		System.out.println("After Sorting");
		printArr(arr);
	}
	public static void quickSort(int arr[],int si,int ei) {
		if(si>=ei) {
			return;
		}
		int pivot=partition(arr,si,ei);
		quickSort(arr,si,pivot-1);
		quickSort(arr,pivot+1,ei);
		
	}
	public static int partition(int arr[],int si,int ei) {
		int pivot=arr[ei];
		int i=si-1;// to make place for elements smaller than pivot
		for(int j=si;j<ei;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
			
		}
		i++;
		int temp=pivot;
		arr[ei]=arr[i];
		arr[i]=temp;
		return i;
	}
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
