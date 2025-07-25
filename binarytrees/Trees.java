package binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import binarytrees.BuildTreePreorder.Node;
/*
 * Build Tree PreOrder
 * PreOrder Traversal - DFS
 * InOrder Traversal-DFS
 * PostOrder Traversal - DFS
 * Level Order TRaversal - BFS
 * Max
 * Min
 * Count Nodes
 * Hieght
 * Sum Of Nodes
 * Diameter of tree - 2 approaches
 * IS subtree
 * isIdentical
 * top view of binary tree
 * 
 */
public class Trees {
	public class Node{
		int data;
		Node left,right;
		public Node(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	private Node root;
	public Trees() {
		this.root=null;
	}
	static int idx=-1;
		
	public Node buildTree(int values[]) {
			idx++;
			if(values[idx]==-1) 
				return null;
			Node newNode=new Node(values[idx]);
			newNode.left=buildTree(values);
			newNode.right=buildTree(values);
			return newNode;
	}
	
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	public void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	public int countNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return countNodes(root.left)+countNodes(root.right)+1;
	}
	public int sumNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return sumNodes(root.left)+sumNodes(root.right)+root.data;
	}
	public int max(Node root) {
		if(root==null) {
			return 0;
		}
		return Math.max(root.data, Math.max(max(root.left),max(root.right)));
	}
	public int min(Node root) {
		if(root==null) {
			return 0;
		}
		return Math.min(root.data, Math.min(min(root.left),min(root.right)));
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
	public int height(Node root) {
		if(root==null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}
	public int diameter1(Node root) {
		if(root==null) {
			return 0;
		}
		int d=height(root.left)+height(root.right)+1;
		int leftDiam=diameter1(root.left);
		int rightDiam=diameter1(root.right);
		return Math.max(d,Math.max(leftDiam, rightDiam));
	}
	class Info {
	    int height;
	    int diameter;
	    
	    Info(int height, int diameter) {
	        this.height = height;
	        this.diameter = diameter;
	    }
	}

	public int diameter2(Node root) {
	    return diameter(root).diameter;
	}

	private Info diameter(Node root) {
	    if (root == null) {
	        return new Info(0, 0);
	    }

	    Info left = diameter(root.left);
	    Info right = diameter(root.right);

	    int height = Math.max(left.height, right.height) + 1;
	    int diaThroughRoot = left.height + right.height + 1;
	    int diameter = Math.max(Math.max(left.diameter, right.diameter), diaThroughRoot);

	    return new Info(height, diameter);
	}
	public boolean isSubTree(Node root,Node subRoot) {
		if(root==null) {
			return false;
		}
		if(root.data==subRoot.data) {
			if(isIdentical(root,subRoot)) {
				return true;
			}
		}
		return isSubTree(root.left,subRoot)||isSubTree(root.right,subRoot);
	}
	public boolean isIdentical(Node root, Node subRoot) {
		if(root==null&&subRoot==null) {
			return true;
		}
		else if(root==null||subRoot==null||root.data!=subRoot.data)
				return false;
		if(!isIdentical(root.left,subRoot.left)) {
			return false;
		}
		if(!isIdentical(root.right,subRoot.right)) {
			return false;
		}
		return true;
		
	}
	class Information{
		Node node;
		int hd;
		public Information(Node node,int hd) {
			this.node=node;
			this.hd=hd;
		}
	}
	public void topView(Node root) {
		if(root==null) {
			System.out.println("The tree is empty");
			return;
		}
		Queue<Information> queue =new LinkedList<>();
		queue.add(new Information(root,0));
		queue.add(null);
		HashMap<Integer,Integer> map=new HashMap<>();
		int min=0,max=0;
		while(!queue.isEmpty()) {
			Information info=queue.remove();
			if(info==null) {
				if(queue.isEmpty()) {
					break; 
				}
				queue.add(null);
			}else {
				if(!map.containsKey(info.hd)) {
					map.put(info.hd,info.node.data);
					min=Math.min(min,info.hd);
					max=Math.max(max, info.hd);
				}
				if(info.node.left!=null) {
					queue.add(new Information(info.node.left,info.hd-1));
				}
				if(info.node.right!=null) {
					queue.add(new Information(info.node.right,info.hd+1));
				}	
			}
		}
		while(min<=max) {
			System.out.print(map.get(min++)+" ");
		}
	}
	public void kthLevelIterative(int k,Node root) {
		Queue<Node> queue=new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node node=queue.remove();
			if(node==null) {
				if(queue.isEmpty()) {
					break;
				}
				k--;
				if(k==1) {
					break;
				}
				queue.add(null);
			}else {
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
		}
		while(!queue.isEmpty()) {
			Node node=queue.remove();
			System.out.print(node.data+" ");
		}
		System.out.println();
	}
	public void kthLevelRecursive(Node root,int k,int currLevel) {
		if(root==null) {
			return;
		}
		if(currLevel==k) {
			System.out.print(root.data+" ");
			return;
		}
		kthLevelRecursive(root.left,k,currLevel+1);
		kthLevelRecursive(root.right,k,currLevel+1);
	}
	public int lca(Node root,int n1,int n2) {
		ArrayList<Node> path1=new ArrayList<>();
		ArrayList<Node> path2=new ArrayList<>();
		getPath(root,n1,path1);
		getPath(root,n2,path2);
		
		//lca
		int i=0;
		for( i=0;i<path1.size()&&i<path2.size();i++) {
			if(path1.get(i).data!=path2.get(i).data) {
				break;
			}
		}
		return path1.get(i-1).data;
	}
	public boolean getPath(Node root,int nodeToSearch, ArrayList<Node> path) {
		if(root==null) {
			return false;
		}
		path.add(root);
		if(root.data==nodeToSearch) {
			return true;
		}
		boolean foundLeft=getPath(root.left,nodeToSearch,path);
		boolean foundRight=getPath(root.right,nodeToSearch,path);
		if(foundLeft||foundRight) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
		
		
	}
	public Node lca2(Node root,int n1,int n2) {
		if(root==null) {
			return null;
		}
		if(root.data==n1||root.data==n2) {
			return root;
		}
		Node leftLca=lca2(root.left,n1,n2);
		Node rightLca=lca2(root.right,n1,n2);
		if(leftLca==null) {
			return rightLca;
		}
		if(rightLca==null) {
			return leftLca;
		}
		return root;
	}
	public int minDist(Node root,int n1,int n2) {
		Node lca=lca2(root,n1,n2);
		return getDist(lca,n2)+getDist(lca,n1);
	}
	public int getDist(Node root,int n) {
		if(root==null) {
			return -1;
		}
		if(root.data==n) {
			return 0;
		}
		int left=getDist(root.left,n);
		int right=getDist(root.right,n);
		if(left==-1&&right==-1) {
			return -1;
		}else if(left==-1) {
			return right+1;
		}else {
			return left+1;
		}
	}
	private int kthAncestor(Node root,int n1,int  k) {
		
		ArrayList<Node> list=new ArrayList<>();
		getPath(root,n1,list);
		return list.get(list.size() - k-1).data;
	}
	public int kthAncestor2(Node root,int n,int k) {
		if(root==null) {
			return -1;
		}
		if(root.data==n) {
			return 0;
		}
		int left=kthAncestor2(root.left,n,k);
		int right=kthAncestor2(root.right,n,k);
		if(left==-1&&right==-1) {
			return -1;
		}else if(left==-1) {
			if(right+1==k) {
				System.out.println("kth ancestor is "+ root.data);
			}
			return right+1;
		}else {
			if(left+1==k) {
				System.out.println("kth ancestor is "+ root.data);
			}
			return left+1;
		}
	}
	public int sumTree(Node root) {
		if(root==null) {
			return 0;
		}
		int leftSum=sumTree(root.left);
		int rightSum=sumTree(root.right);
		int temp=root.data;
		root.data=leftSum+rightSum;
		return root.data+temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trees tree=new Trees();
		int nums[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		tree.root=tree.buildTree(nums);
		tree.preOrder(tree.root);
		
		int sumTree=tree.sumTree(tree.root);
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("kth ancestor  :-> "+tree.kthAncestor2(tree.root, 4,1));

		System.out.println("LCA :-> "+tree.lca2(tree.root, 4, 6).data);
		System.out.println("kth ancestor  :-> "+tree.kthAncestor(tree.root, 4,1));
		System.out.println("Min distt :-> "+tree.minDist(tree.root, 4, 6));
		System.out.println(tree.countNodes(tree.root));
		tree.kthLevelIterative(3, tree.root);
		
		tree.kthLevelRecursive(tree.root,3,1);
		System.out.println();
		System.out.println(tree.sumNodes(tree.root));
		
		
		System.out.println(tree.max(tree.root));
		
		tree.levelorder(tree.root);
		
		System.out.println(tree.height(tree.root));
		
		System.out.println(tree.diameter1(tree.root));
		
		
		System.out.println(tree.diameter2(tree.root));
		
		tree.topView(tree.root);
	}

}
