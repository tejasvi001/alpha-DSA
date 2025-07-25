package bst;

import java.util.ArrayList;

import binarytrees.BuildTreePreorder.Node;

public class Bst {
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
	public Bst() {
		root=null;
	}
	public Node add(int data,Node root) {
		if(root==null) {
			root=new Node(data);
			return root;
		}
		if(root.data>data) {
			root.left=add(data,root.left);
		}
		else {
			root.right=add(data,root.right);
		}
		return root;
	}
	public void Inorder(Node root) {
		if(root==null) {
 			return ;
 		}
 		Inorder(root.left);
 		System.out.print(root.data+" ");
 		Inorder(root.right);
	}
	public boolean search(int data,Node root) {
		if(root==null)
			return false;
		if(root.data==data)
			return true;
		if(data<root.data) {
			return search(data,root.left);
		}else {
			return search(data,root.right);
		}
	}
	private Node deleteNode(Node current, int value) {
		if(current==null) {
			return null;
		}
		if(value==current.data) {
			if(current.left==null&&current.right==null) {
				return null;
			}
			if(current.right==null) {
				return current.left;
			}
			if(current.left==null) {
				return current.right;
			}
			int smallestValue=findsmallestvalue(current.right);
			current.data=smallestValue;
			
			current.right=deleteNode(current.right,smallestValue);
			return current;
		}
		//System.out.println("> "+current.data);
		if(value<current.data) {
			current.left=deleteNode(current.left,value);
			return current;
		}
		current.right=deleteNode(current.right,value);
		return current;
	}
	public void printInRange(Node root,int i,int j) {
		if(root==null) {
			return;
		}
		printInRange(root.left,i,j);
		if(root.data>=i&&root.data<=j) {
			System.out.print(root.data+" ");
		}
		printInRange(root.right,i,j);
	}
	public int findsmallestvalue(Node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root.data;
	}
	public Node mirror(Node root) {
		if(root==null) {
			return null;
		}
		Node left=mirror(root.left);
		Node right=mirror(root.right);
		root.left=right;
		root.right=left;
		return root;
	}
	public void printRootToLeaf(Node root,ArrayList<Integer> path) {
		if(root==null) {
			return ;
		}
		path.add(root.data);
		if(root.left==null&&root.right==null) {
				System.out.println(path);
		}
		printRootToLeaf(root.left,path);
		printRootToLeaf(root.right,path);
		path.remove(path.size()-1);
	}
	public boolean isValidBST(Node root,Node min,Node max) {
		if(root==null) {
			return true;
		}
		if(min!=null&&root.data<=min.data) {
			return false;
		}else if(max!=null&&root.data>=max.data) {
			return false;
		}
		return isValidBST(root.left,min,root)
				&&isValidBST(root.right,root,max);
				
	}
	public static void main(String[] args) {
		Bst obj=new Bst();
		System.out.println("Binary Search Tree");
		int values[]= {4,2,1,3,5,6};
		for(int i=0;i<values.length;i++) {
			root=obj.add(values[i], root);
		}
		obj.Inorder(root);
		System.out.println("\n"+obj.search(7, root));
		obj.deleteNode(root,2);
		obj.Inorder(root);
		System.out.println();
		obj.printInRange(root, 5, 12);
		System.out.println();
		obj.mirror(root);
		obj.Inorder(root);
		System.out.println();
		obj.mirror(root);
		obj.Inorder(root);
		
		obj.printRootToLeaf(root, new ArrayList<Integer>());
	}

}
