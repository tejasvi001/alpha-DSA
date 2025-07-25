package linkedlist;

public class DoublyLL {
	public class Node{
		int data;
		Node prev,next;
		public Node(int data){
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	public DoublyLL() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	public void addFirst(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}else {
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
		size++;
	}
	
	public void printForward() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("X");
	}
	public void printBackward() {
		Node temp=tail;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.prev;
		}
		System.out.println("X");
	}
	public void addLast(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
		}else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
		size++;
	}
	public void removeFirst() {
		if(head==null) {
			return;
		}
		if(head==tail) {
			head=tail=null;
		}else {
			head.next.prev=null;
			head=head.next;
		}
		size--;
	}
	public int size() {
		return size;
	}
	public void removeLast() {
		if(tail==null) {
			return;
		}
		if(head==tail) {
			head=tail=null;
		}else {
			tail.prev.next=null;
			tail=tail.prev;
		}
		size--;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLL ll=new DoublyLL();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(0);
		ll.addLast(5);
		ll.printForward();
		ll.printBackward();
		
		ll.removeFirst();
		ll.printForward();
		ll.printBackward();
		
		
		ll.removeLast();
		ll.printForward();
		ll.printBackward();
		
		System.out.println("Size: -+"+ ll.size());
	}

}
