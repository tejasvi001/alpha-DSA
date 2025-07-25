package arrays;

import java.util.Arrays;

public class Arrayyys {
	public static void pairPrint() {
		int arr[]= {1,2,3,4,5};
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				System.out.print(arr[i]+","+arr[j]+" ");
			}
			System.out.println();
		}
	}
	public static void pairPrintMaxSum() {
		int arr[]= {1,2,3,4,5};
		int s=Integer.MIN_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				s=Math.max(s, arr[i]+arr[j]);
			}
		}
		System.out.println("Max Pair Sum"+s);
	}
	public static void pairPrintMinSum() {
		int arr[]= {1,2,3,4,5};
		int s=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				s=Math.min(s, arr[i]+arr[j]);
			}
		
		}
		System.out.println("Min Pair Sum"+s);
	}
	public static void pairSumEqualsToTarget(int t) {
		int arr[]= {1,2,3,4,5};
		int s;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				s=arr[i]+arr[j];
				if(s==t) {
					System.out.println(arr[i]+","+arr[j]);
				}
			}
		}
	}
	public static int maxSumPrefix(int arr[]) {
		int prefix[]=new int[arr.length];
		prefix[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			prefix[i]=prefix[i-1]+arr[i];
		}
		int currSum=0;
		int maxSum=Integer.MIN_VALUE;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				currSum=prefix[j]-prefix[i];
				maxSum=Math.max(currSum,maxSum);
			}
		}
		return maxSum;
	}
	public static void pairSumEqualsToTarget2(int t) {
		int arr[]= {5,6,4,2,10};
		Arrays.sort(arr);
		int n=0;
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			if(arr[i]+arr[j]==t) {
				n++;
				i++;
				j--;
			}else if(arr[i]+arr[j]>t) {
				j--;
			}else {
				i++;
			}
		}
		System.out.println(n);
	}
	public static int maxProfit(int arr[]) {
		int maxProfit=0;
		int sp,bp=Integer.MAX_VALUE;
		for(int i=1;i<arr.length;i++) {
			bp=Math.min(arr[i-1], bp);
			sp=arr[i];
			int profit=sp-bp;
			maxProfit=Math.max(maxProfit, profit);
			}
		return maxProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pairPrint();
		pairPrintMaxSum();
		pairPrintMinSum();
		pairSumEqualsToTarget(6);
		pairSumEqualsToTarget2(6);
		int arr[]= {1,-2,6,-1,3};
		System.out.println(maxSumPrefix(arr));
		int data[]= {7,1,5,3,6,4};
		System.out.println("MaxProfit=" +maxProfit(data));
	}
}
