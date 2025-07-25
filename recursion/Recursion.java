package recursion;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDecreasing(10);
		printIncreasing(10);
		System.out.println(pow(2,10));
		System.out.println(factorial(5));
		System.out.println(sum(10));
		System.out.println(fibonacci(5));
		int arr[]= {1,2,3,5,4,5};
		System.out.println(isSorted(0,arr));
		System.out.println(firstOccurrence(arr,0,5));
		System.out.println(firstOccurrence(arr,arr.length-1,5));
		System.out.println(powOptimised(2,10));
		AllOccurrence(arr,arr.length-1,5);
	}
	
	public static void printDecreasing(int n) {
		if(n==0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		printDecreasing(n-1);
		
	}
	public static void printIncreasing(int n) {
		if(n==0) {
			System.out.println(n);
			return;
		}
		printIncreasing(n-1);
		System.out.println(n);
	}
	public static int pow(int x, int n) {
		if(n==0) {
			return 1;
		}
		return x*pow(x,n-1);
	}
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	public static int sum(int n) {
		if(n==1) {
			return 1;
		}
		return n+sum(n-1);
	}
	public static int fibonacci(int n) {
		if(n==0||n==1) {
			return n;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static boolean isSorted(int i,int arr[]) {
		if(i+1<arr.length) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		if(i+1>=arr.length) {
			return true;
		}
		return isSorted(i+1,arr);
	}
	public static int firstOccurrence(int arr[],int i,int k) {
		if(arr[i]==k) {
			return i;
		}
		if(i==arr.length-1) {
			return -1;
		}
		return firstOccurrence(arr, i+1,k);
	}
	public static int lastOccurrence(int arr[],int i,int k) {
		if(arr[i]==k) {
			return i;
		}
		if(i==0) {
			return -1;
		}
		return lastOccurrence(arr, i-1,k);
	}
	public static void AllOccurrence(int arr[],int i,int k) {
		if(arr[i]==k) {
			System.out.println(i);
		}
		if(i==0) {
			return ;
		}
		AllOccurrence(arr, i-1,k);
	}
	public static int powOptimised(int x,int n) {
		if(n==0) {
			return 1; 
		}
		int halfPowerSq=powOptimised(x,n/2);
		halfPowerSq*=halfPowerSq;
		if(n%2==1) {
			halfPowerSq*=x;
		}
		return halfPowerSq;
	}
}
