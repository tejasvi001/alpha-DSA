package stacks;

import java.util.Stack;

public class StockSpanProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stocks[]= {100,80,60,70,60,85,100};
		int span[]=new int[stocks.length];
		
		stockspan(stocks,span);
		System.out.println("stocks");
		for(int i=0;i<stocks.length;i++) {
			System.out.print(stocks[i]+" ");
		}
		System.out.println("\n span");
		for(int i=0;i<span.length;i++) {
			System.out.print(span[i]+" ");
		}
	}

	private static void stockspan(int[] stocks, int[] span) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<>();
		span[0]=1;
		stack.add(0);
		for(int i=1;i<stocks.length;i++) {
			int curr=stocks[i];
			while(curr>stocks[stack.peek()]&& !stack.isEmpty()) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				span[i]=i+1;
			}else {
				int prevHigh=stack.peek();
				span[i]=i-prevHigh;
			}
			stack.push(i);
		}
	}

}
