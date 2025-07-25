package binarytrees;

import binarytrees.BuildTreePreorder.Node;

public class QuestionsOnBT {
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
	public QuestionsOnBT() {
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
//	static int c=0;
//	public void count(Node root) {
//		
//		if(root==null) {
//			return;
//		}
//		c++;
//		count(root.left);
//		count(root.right);
//	}
	public int noOfNodes(Node root) {
//		count(root);
		
		class Count{
		int count=0;
		public void count(Node root) {
			if(root==null) {
				return;
			}
			count++;
			count(root.left);
			count(root.right);
		}
		}
		Count c=new Count();
		c.count(root);
		return c.count;
	}
	public static int sumOfNodes(Node root) {
		class Sum{
		int sum=0;
		public void sum(Node root) {
			if(root==null) {
				return;
			}
			sum+=root.data;
			sum(root.left);
			sum(root.right);
		}
		}
		Sum c=new Sum();
		c.sum(root);
		return c.sum;
	}
	public static int minOfNodes(Node root) {
		class Min{
		int min=root.data;
		public void min(Node root) {
			if(root==null) {
				return;
			}
			if(min>root.data) {
				min=root.data;
			}
			min(root.left);
			min(root.right);
		}
		}
		Min c=new Min();
		c.min(root);
		return c.min;
	}
	public static int maxOfNodes(Node root) {
		class Max{
		int max=root.data;
		public void max(Node root) {
			if(root==null) {
				return;
			}
			if(max<root.data) {
				max=root.data;
			}
			max(root.left);
			max(root.right);
		}
		}
		Max c=new Max();
		c.max(root);
		return c.max;
	}
	public int max(Node root) {
		if(root==null) {
			return 0;
		}
		return Math.max(root.data, Math.max(max(root.left),max(root.right)));
	}
	public int height(Node root) {
		if(root==null) {
			return 0;
		}
//		int lh=height(root.left);
//		int rh=height(root.right);
//		int height=Math.max(lh, rh)+1;
//		return height;
		return Math.max(height(root.left),height(root.right))+1;
	}
	public int count(Node root) {
		if(root==null) {
			return 0;
		}
		return count(root.left)+count(root.right)+1;
	}
	public int sum(Node root) {
		if(root==null) {
			return 0;
		}
		return sum(root.left)+sum(root.right)+root.data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuestionsOnBT obj=new QuestionsOnBT();
		  int nums[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		root=obj.add(nums);
		System.out.println("No. of nodes "+ obj.noOfNodes(root));
		System.out.println("Sum of nodes "+obj.sumOfNodes(root));
		System.out.println("Min of nodes "+obj.minOfNodes(root));
		System.out.println("Max of nodes "+obj.maxOfNodes(root));
		System.out.println("Hieght "+obj.height(root));
		System.out.println(" the count is "+obj.count(root));
		System.out.println("Sum is "+obj.sum(root));
		System.out.println("Max is "+obj.max(root));
		Node root =new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		root.left.left=new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right=new Node(7);
		System.out.println("Diameter is "+obj.diameter(root));
		Info obj1=obj.diameter2(root);
		System.out.println(obj1.diam);
		Node subRoot=new Node(2);
		subRoot.left=new Node(4);
		subRoot.right=new Node(5);
		System.out.println(obj.isSymmetric(root, subRoot));
	}
	public boolean isSymmetric(Node root,Node subRoot) {
		if(root==null) {
			return false;
		}
		if(root.data==subRoot.data) {
			if(isIdentical(root,subRoot)) {
				return true;
			}
		}
		return isSymmetric(root.left,subRoot)||isSymmetric(root.right,subRoot);
	}
	private boolean isIdentical(Node root,Node subRoot) {
		if(root==null&&subRoot==null) {
			return true;
		}
		if(root==null||subRoot==null||root.data!=subRoot.data) {
			return false;
		}
		if(!isIdentical(root.left,subRoot.left)){
			return false;
		}
		if(!isIdentical(root.right,subRoot.right)) {
			return false;
		}
		return true;
	}
	public int diameter(Node root) {
		if(root==null)
			return 0;
		int leftdiam=diameter(root.left);
		int leftheight=height(root.left);
		int rightdiam=diameter(root.right);
		int rightheight=height(root.right);
		int selfdiam=leftheight+rightheight+1;
		return Math.max(selfdiam,Math.max(rightdiam, leftdiam));
	}
	public static class Info{
		int diam;
		int ht;
		public Info(int diam,int ht) {
			this.diam=diam;
			this.ht=ht;
		}
	}
	public Info diameter2(Node root) {
		if(root==null)
			return new Info(0,0);
		Info linfo=diameter2(root.left);
		Info rinfo=diameter2(root.right);
		int diam=Math.max((linfo.ht+rinfo.ht+1), Math.max(linfo.diam, rinfo.diam));
		int ht=Math.max(linfo.ht,rinfo.ht)+1;
		return new Info(diam,ht);
	}
}
