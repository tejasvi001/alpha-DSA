package divideAndConquer;

public class SearchInRotatedSortedArray {
	public static int searchIterative(int arr[],int target) {
		int mid, si=0,ei=arr.length-1;
		while(si<=ei) {
			mid=si+(ei-si)/2;
			if(arr[mid]==target) {
				return mid;
			}
			//line 1
			if(arr[mid]>=arr[si]) {
				if(arr[si]<=target&&target<=arr[mid]) {
					ei=mid-1;
				}else {
					si=mid+1;
				}
			}else {
				if(arr[ei]>=target&&target>=arr[mid]) {
					si=mid+1;
				}
				else {
					ei=mid-1;
				}
			}
		}
		return -1;
	}
	public static int searchRecursive(int arr[],int target,int si,int ei) {
		if(si>ei) {
			return -1;
		}
		int mid=si+(ei-si)/2;
		if(arr[mid]==target) {
			return mid;
		}
			//line 1
		if(arr[mid]>=arr[si]) {
			if(arr[si]<=target&&target<=arr[mid]) {
				return searchRecursive(arr,target,si,mid-1);
			}else {
				return searchRecursive(arr,target,mid+1,ei);
			}
		}else {
			if(arr[ei]>=target&&target>=arr[mid]) {
				return searchRecursive(arr,target,mid+1,ei);
			}
			else {
				return searchRecursive(arr,target,si,mid-1);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4,5,6,7,0,1,2};
		System.out.println(searchIterative(arr,0));
		System.out.println(searchRecursive(arr,0,0,arr.length-1));

	}

}
