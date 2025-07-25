package problems;

import java.util.Scanner;

public class ContainerWithMostWater {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	public int bruteForce(int arr[]) {
		int max=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int width=j-i;
				int height=Math.max(arr[i], arr[j]);
				max=Math.max(max, height*width);
			}
		}
		return max;
	}
	public int twopointers(int height[]) {
		int max=Integer.MIN_VALUE;
		int lp=0;
		int rp=height.length-1;
		while(lp<rp) {
			int w=rp-lp;
			int h=Math.min(height[rp], height[lp]);
			max=Math.max(max, h*w);
			if(height[lp]<height[rp]) {
				lp++;
			}
			else {
				rp--;
			}
		}
		return max;
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
		int max=0;
		for(int i=0;i<data.length;i++) {
			for(int j=i+1;j<n;j++) {
				int height=Math.min(data[i], data[j]);
				int width=j-i;
				int water=height*width;
				max=Math.max(max, water);
			}
		}
		System.out.println("max water container can store "+max+" litres of water");
	}

}
