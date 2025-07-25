package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreePreorder {
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;  
			left=right=null;
		}
	}
	static Node root;
	public BuildTreePreorder() {
		root=null;
	}
	
	static int i=-1;
	public Node add(int value[]) {
		i++;
		if(value[i]==-1) {
			return null;
		}
		Node newNode=new Node(value[i]);
		newNode.left=add(value);
		newNode.right=add(value);
		return newNode;
	}
	public void Preorder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		Preorder(root.left);
		Preorder(root.right);
	}
	public void Postorder(Node root) {
 		if(root==null) {
 			return ;
 		}
 		Postorder(root.left);
 		Postorder(root.right);
 		System.out.print(root.data+" ");
	}
	public void Inorder(Node root) {
		if(root==null) {
 			return ;
 		}
 		Inorder(root.left);
 		System.out.print(root.data+" ");
 		Inorder(root.right);
	}
	public void levelorder(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node currNode=queue.remove();
			if(currNode==null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}
				else {
					queue.add(null);
				}
			}
			else {
				System.out.print(currNode.data+" ");
				if(currNode.left!=null) {
					queue.add(currNode.left);
					
				}
				if(currNode.right!=null) {
					queue.add(currNode.right);
				}
			}
		}
	}
	public static void main(String args[]) {
		BuildTreePreorder obj=new BuildTreePreorder();
		int nums[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		root=obj.add(nums);
		System.out.print("Pre Order Traversal ");
		obj.Preorder(root);
		System.out.println();
		System.out.print("Post Order Traversal ");
		obj.Postorder(root);
		System.out.println();
		System.out.print("In Order Traversal ");
		obj.Inorder(root);
		System.out.println();
		System.out.println("Level Order Traversal ");
		obj.levelorder(root);
	}
}
