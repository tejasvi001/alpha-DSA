package linkedlist;
/*
 * add first
 * add last
 * add mid 
 * remove first
 * remove last
 * remove mid 
 * display
 * size
 */
public class Train {
	class Coach{
		String coach_name;
		Coach next;
		public Coach(String coach_name) {
			this.coach_name=coach_name;
			this.next=null;
		}
	}
	Coach head;
	public Train() {
		this.head=null;
	}
    public Coach addFirst(String coach_name) {
    	Coach newcoach=new Coach(coach_name);
    	newcoach.next=head;
    	head=newcoach;
    	return head;
    }
    public Coach addMid(String coach_name,int n) {
    	if(n<1||n>size()) {
    		System.out.println("Cannot insert : location not found");
    		return null;
    	}
    	Coach newcoach=new Coach(coach_name);
    	Coach temp=head;
    	while(n-->0) {
    		temp=temp.next;
    	}
    	newcoach.next=temp.next;
    	temp.next=newcoach;
    	return head;
    }
    public Coach addLast(String coach_name) {
    	Coach newcoach=new Coach(coach_name);
    	Coach temp=head;
    	while(temp.next!=null) {
    		temp=temp.next;
    	}
    	temp.next=newcoach;
    	newcoach.next=null;
    	return head;
    }
    public void deleteFirst() {
    	
    }
    public int size() {
    	int size=0;
    	Coach temp=head;
    	while(temp!=null) {
    		temp=temp.next;
    		size++;
    	}
    	return size;
    }
    public void display() {
    	Coach temp=head;
    	while(temp!=null) {
    		System.out.print(temp.coach_name+"-");
    		temp=temp.next;
    	}
    	System.out.println("null");
    }
	public static void main(String[] args) {
		Train train=new Train();
		train.addFirst("A1");
		train.addFirst("A2");
		train.display();
		train.addLast("<Engine>");
		train.display();
		train.addMid("Pantry", 1);
		train.display();
	}

}
