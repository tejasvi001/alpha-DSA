package linkedlist;

import java.util.Scanner;

public class Sort012 {
	static Scanner input;
	static {
		input=new Scanner(System.in);
	}
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	} 
	Node head=null;
	public Node addFirst(int data) {
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
		return head;
	}
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println("NULL");
	}
	public void sort() {
		int n0=0,n1=0,n2=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.data==0) n0++;
			else if(temp.data==1) n1++;
			else n2++;
			temp=temp.next;
		}
		temp=head;
		while(n0!=0) {
			temp.data=0;
			temp=temp.next;
			n0--;
		}
		while(n1!=0) {
			temp.data=1;
			temp=temp.next;
			n1--;
		}
		while(n2!=0) {
			temp.data=2;
			temp=temp.next;
			n2--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sort012 obj=new Sort012();
        obj.addFirst(1);
        obj.addFirst(1);
        obj.addFirst(2);
        obj.addFirst(0);
        obj.addFirst(2);
        obj.addFirst(0);
        obj.addFirst(1);
        obj.display();
        obj.sort();
        System.out.println();
        obj.display();
	}

}
