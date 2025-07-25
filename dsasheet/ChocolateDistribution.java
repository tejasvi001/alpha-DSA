package dsasheet;

import java.util.Arrays;
import java.util.Scanner;

public class ChocolateDistribution {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	private int arr[];
	private int m;
	public void inputArray() {
		System.out.println("Enter the size of the array");
		int n=input.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++) {
		   arr[i]=input.nextInt();
		}
	}
	public int distributeChocolate() {
		System.out.println("Enter the number of students");
		m=input.nextInt();
		Arrays.sort(arr);
		int d=Integer.MAX_VALUE;
		for(int i=0;i<=arr.length-m;i++) {
			d=Math.min(d,arr[i+m-1]-arr[i]);
		}
		return d;
		
	}
	public static void main(String[] args) {
		ChocolateDistribution obj=new ChocolateDistribution();
		obj.inputArray();
		int min_diff=obj.distributeChocolate();
		System.out.println("minimum chocolate difference is "+min_diff);
	}

}
