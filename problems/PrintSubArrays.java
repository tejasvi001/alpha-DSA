package problems;

import java.util.Scanner;

public class PrintSubArrays {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	public static void main(String[] args) {
		
		System.out.println("Enter no. of elements in the array");
		int n=input.nextInt();
		int data[]=new int[n];
		System.out.println("Enter values for array");
		for(int i=0;i<n;i++) {
			data[i]=input.nextInt();
		}
		for(int i=0;i<n;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int s=0;
				for(int k=i;k<=j;k++)
					s+=data[k];
					//System.out.print(data[k]);
				//System.out.print("   ");
				sum=Math.max(s, sum);
			}
			//System.out.println();
		}
		System.out.println(sum);
	}

}
