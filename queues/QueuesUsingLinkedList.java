package queues;

public class QueuesUsingLinkedList {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node head,tail;
	QueuesUsingLinkedList(){
		this.head=null;
		this.tail=null;
	}
	public void addNode(int data) {
		Node newNode=new Node(data);
		if(tail==null) {
			head=tail=newNode;
		}else {
			tail.next=newNode;
			tail=newNode;
		}
	}
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public int remove() {
		if(head==null) {
			return -1;
		}
		int temp=head.data;
		if(head==tail)
			head=tail=null;
		else
			head=head.next;
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueuesUsingLinkedList q=new QueuesUsingLinkedList();
		q.addNode(1);
		q.addNode(2);
		q.addNode(3);
		q.display();
		System.out.println(q.remove());
		q.display();
	}

}
