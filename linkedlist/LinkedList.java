package linkedlist;

public class LinkedList {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node head;
	LinkedList(){
		this.head=null;
	}
	public Node addFirst(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}else {
			newNode.next=head;
			head=newNode;
		}
		return head;
	}
	public Node addLast(int data) {
		Node newNode=new Node(data);
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
		return head;
	}
	public Node addMid(int data,int idx) {
		Node temp=head;
		for(int i=0;i<idx;i++) {
			temp=temp.next;
		}
		Node newNode=new Node(data);
		newNode.next=temp.next;
		temp.next=newNode;
		return head;
	}
	public Node removeFirst() {
		head=head.next;
		return head;
	}
	public Node removeLast() {
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		return head;
	}
	public void removeMid(int n) {
		Node temp=head;
		for(int i=0;i<n-1;i++) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
	}
	public void removeFromEnd(int n) {
		removeMid(countNodes()-n+1);
	}
	public void printLinkedList() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("X");
		System.out.println();
	}
	public int countNodes() {
		Node temp=head;
		int c=0;
		while(temp!=null) {
			c++;
			temp=temp.next;
		}
		return c;
	}
	public int iterativeSearch(int val) {
		int i=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.data==val) {
				return i;
			}
			i++;
			temp=temp.next;
		}
		return -1;
	}
	public boolean recursiveSearch(Node node,int val) {
		if(node==null) {
			return false;
		}
		if(node.data==val) {
			return true;
		}
		return recursiveSearch(node.next,val);
	}
	public Node reveseLinkedList() {
		Node prev=null,curr=head,next;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	public Node findMid() {
		Node slow=head,fast=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public boolean checkPalindrome() {
		if(head==null||head.next==null) {
			return true;
		}
		Node midNode=findMid();
		Node prev=null,curr=midNode,next;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		Node right=prev;
		Node left=head;
		while(right!=null) {
			if(left.data!=right.data)
				return false;
			right=right.next;
			left=left.next;
		}
		return true;
	}
	public boolean detectCycle() {
		Node slow=head,fast=head;
		while(fast!=null&&fast.next!=null) {
			
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast) {
				return true;
			}
		}
		return false;
	}
	public void RemoveCycle() {
		boolean cycle=false;
		Node slow=head,fast=head;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				cycle=true;
				break;
			}
		}
		if(cycle==false) {
			return;
		}
		Node prev=null;
		slow=head;
		while(slow!=fast) {
			prev=fast;
			slow=slow.next;
			fast=fast.next;
		}
		prev.next=null;
	}
	public void mergeSortHelper() {
		head=mergeSort(head);
	}
	public Node mergeSort(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node mid=getMid(head);
		Node rightHead=mid.next;
		mid.next=null;
		Node right=mergeSort(rightHead);
		Node left=mergeSort(head);
		head = merge(left,right);
		return head;
		
	}
	private Node getMid(Node head) {
		Node slow=head,fast=head.next;
		while(fast!=null&&fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	private Node merge(Node head2, Node rightHead) {
		// TODO Auto-generated method stub
		Node mergeLL=new Node(-1);
		Node temp=mergeLL;
		while(head2!=null&&rightHead!=null) {
			if(head2.data<=rightHead.data) {
				temp.next=head2;
				head2=head2.next;
			}else {
				temp.next=rightHead;
				rightHead=rightHead.next;
			}
			temp=temp.next;
		}
		while(head2!=null) {
			temp.next=head2;
			head2=head2.next;
			temp=temp.next;
		}
		while(rightHead!=null) {
			temp.next=rightHead;
			rightHead=rightHead.next;
			temp=temp.next;
		}
		return mergeLL.next;
	}
	public void zigag() {
		if(head==null||head.next==null) {
			return ;
		}
		Node midNode=getMid(head);
		Node prev=null,curr=midNode.next,next;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		Node right=prev;
		Node left=head;
		midNode.next=null;
		Node nextLeft,nextRight;	
		while (left!=null&&right!=null) {
			nextLeft=left.next;
			left.next=right;
			nextRight=right.next;
			right.next=nextLeft;
			left=nextLeft;
			right=nextRight;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		ll.addFirst(0);
		ll.printLinkedList();
		ll.addFirst(1);
		ll.printLinkedList();
		ll.addLast(2);
		ll.printLinkedList();
		ll.addMid(3, 1);
		ll.printLinkedList();
		System.out.println(ll.recursiveSearch(ll.head, 4));
		ll.reveseLinkedList();
		ll.printLinkedList();
		System.out.println("---------------------");
		ll.mergeSortHelper();
		ll.printLinkedList();
		System.out.println("ZIGZAG");
		ll.addLast(5);
		ll.zigag();
		ll.printLinkedList();
		ll.printLinkedList();
		ll.removeFirst();
		ll.printLinkedList();
		ll.removeLast();
		ll.printLinkedList();
		System.out.println(ll.iterativeSearch(2));
		System.out.println(ll.findMid());
		
	}

}
