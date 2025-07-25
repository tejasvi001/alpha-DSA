package stacks;

import java.util.Stack;

public class StackProblems {
	 
	Stack<Integer> stack;
	StackProblems(){
		stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
	}
	public void addBottom(int n, Stack<Integer> stack) {
		if(stack.isEmpty()) {
			stack.push(n);
			return;
		}
		int x=stack.pop();
		addBottom(n,stack);
		stack.push(x);
	}
	public void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int x=stack.pop();
		reverseStack(stack);
		addBottom(x,stack);
	}
	public String reverse(String s) {
		Stack<Character> s1=new Stack<>();
		for(int i=0;i<s.length();i++) {
			s1.push(s.charAt(i));
		}
		StringBuilder sb=new StringBuilder("");
		while(!s1.isEmpty()) {
			sb.append(s1.pop());
		}
		return sb.toString();
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackProblems s=new StackProblems();
		System.out.println(s.stack);
		s.addBottom(4, s.stack);
		System.out.println(s.stack);
		System.out.println(s.reverse("tejasvi"));
		
		s.reverseStack(s.stack);
		System.out.println(s.stack);
	}

}
