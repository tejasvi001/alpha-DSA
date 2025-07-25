package stacks;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {100,80,60,70,60,85,100};
		int nge[]=new int[arr.length];
		
		nextGreaterElement(arr,nge);
		System.out.println("Array");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n NGE");
		for(int i=0;i<nge.length;i++) {
			System.out.print(nge[i]+" ");
		}
	}

	private static void nextGreaterElement(int[] arr, int[] nge) {
		// TODO Auto-generated method stub
		int n=arr.length;
		nge[n-1]=-1;
		Stack<Integer> stack =new Stack<>();
		stack.push(arr[n-1]);
		for(int i=n-2;i>=0;i--) {
			while(!stack.isEmpty()&&stack.peek()<=arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				nge[i]=-1;
			}else {
				nge[i]=stack.peek();
			}
			stack.push(arr[i]);
		}
	}

}
