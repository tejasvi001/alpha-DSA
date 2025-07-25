package bst;

import bst.Bst.Node;

public class BstProblems {
	public static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	public BstProblems() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	public void Inorder(Node root) {
		if(root==null) {
 			return ;
 		}
 		Inorder(root.left);
 		System.out.print(root.data+" ");
 		Inorder(root.right);
	}
	public void createBST(int arr[]) {
		root=createBST( arr, 0,arr.length-1);
	}
	private Node createBST( int[] arr, int si, int ei) {
		if(si>ei) {
			return null;
		}
		int mid=si+(ei-si)/2;
		Node newNode=new Node(arr[mid]);
		newNode.left=createBST(arr,si,mid-1);
		newNode.right=createBST(arr,mid+1,ei);
		return newNode;
		
	}
	public static class Info{
		boolean isBST;
		int size;
		int min;
		int max;
		public Info(boolean isBST,int size,int min,int max){
			this.isBST=isBST;
			this.size=size;
			this.min=min;
			this.max=max;
		}
	}
	static int maxValue=0;
	public Info maxBST(Node root) {
		if(root==null) {
			return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		Info left=maxBST(root.left);
		Info right=maxBST(root.right);
		int size=left.size+right.size+1;
		int min=Math.min(root.data,Math.min(left.min,right.min));
		int max=Math.max(root.data,Math.max(left.max, right.max));
		if(root.data<=left.max||root.data>=right.min) {
				return new Info(false,size,min,max);
		}
		if(left.isBST&&right.isBST) {
			maxValue=Math.max(maxValue, size);
			return new Info(true,size,min,max);
		}
		
		return new Info(false,size,min,max);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BstProblems obj=new BstProblems();
		int arr[]= {3,5,6,8,10,11,12};
		obj.createBST(arr);
		obj.Inorder(root);
		obj.maxBST(root);
		System.out.println();
		System.out.println(maxValue);
	}

}
