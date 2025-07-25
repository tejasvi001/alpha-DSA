package avl_Trees;

import bst.BstProblems.Node;

public class AVLTrees {
	public static class Node{
		int data;
		int height;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.height=1;
			this.left=this.right=null;
		}
	}
	static Node root;
	public AVLTrees() {
		// TODO Auto-generated constructor stub
		root=null;
	}
	public int height(Node root) {
		if(root==null) return 0;
		return root.height;
	}
	public Node rightRotate(Node y) {
		Node x=y.left;
		Node T2= x.right;
		x.right=y;
		y.left=T2;
		y.height=Math.max(height(y.left), height(y.right))+1;
		x.height=Math.max(height(x.left), height(x.right))+1;
		return x;
	}
	public Node leftRotate(Node x) {
		Node y=x.right;
		Node T2= y.left;
		x.right=T2;
		y.left=x;
		y.height=Math.max(height(y.left), height(y.right))+1;
		x.height=Math.max(height(x.left), height(x.right))+1;
		return y;
	}
	public Node insert(Node root,int key) {
		if(root==null) {
			return new Node(key);
		}
		if(key<root.data) {
			root.left=insert(root.left,key);
		}
		else if(key>root.data) {
			root.right=insert(root.right,key);
		}
		else {
			return root;
		}
		root.height=Math.max(height(root.left), height(root.right))+1;
		int bf=balanceFactor(root);
		//left left
		if(bf>1&&key<root.left.data) {
			return rightRotate(root);
		}
		//right rotate
		if(bf<-1&& key>root.right.data) {
			return leftRotate(root);
		}
		//left right case
		if(bf>1 &&key>root.left.data) {
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}
		//right left case
		if(bf>1&&key<root.right.data) {
			root.right=rightRotate(root.right);
			return rightRotate(root);
		}
		return root;
	}
	public int balanceFactor(Node root) {
		if(root==null) return 0;
		return height(root.left)-height(root.right);
	}
	public void preOrder(Node root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTrees tree=new AVLTrees();
		root=tree.insert(root,10);
		root=tree.insert(root,20);
		root=tree.insert(root,30);
		root=tree.insert(root,40);
		root=tree.insert(root,50);
		root=tree.insert(root,25);
		tree.preOrder(root);
	}
}
