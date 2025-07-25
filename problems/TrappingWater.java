package problems;

import java.util.Scanner;

public class TrappingWater {
	private static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	public static int trap(int[] height) {
		int trappedWater = 0;
		int n=height.length;
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
        leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=0;i<n;i++){
            int wl=Math.min(leftMax[i],rightMax[i]);
            trappedWater+=(wl-height[i]);
        }
        return trappedWater;
	}
	
	public static void main(String[] args) {
		TrappingWater obj=new TrappingWater();
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
		int x=trap(data);
		System.out.println("Trapping Rainwater : "+x);
	}

}
