package queues;

public class QueueUsingArrays {
	private int queue[];
	QueueUsingArrays(){
		queue=new int[10];
		front=rear=-1;
	}
	private int front,rear;
	public void displayQueue() {
		if(rear==-1) {
			System.out.println("The queue is empty");
			return;
		}
		for(int i=front;i<=rear;i++ ) {
			System.out.print(queue[i]+" ");
		}
		System.out.println();
	}
	public void add(int n) {
		if(rear==queue.length-1) {
			System.out.println("The queue is full we can not insert a new value");
			return;
		}
		if(front==-1) {
			front++;
		}
		rear++;
		queue[rear]=n;
	}
	public int peek() {
		if(front==-1) {
			return -1;
		}
		return queue[front];
	}
	public int delete() {
		if(front==-1) {
			return -1;
		}
		int temp=queue[front];
		for(int i=front;i<=rear;i++) {
			queue[i]=queue[i+1];
		}
		rear--;
		if(rear==-1) {
			front=-1;
		}
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArrays obj=new QueueUsingArrays();
		obj.displayQueue();
		obj.add(1);
		obj.add(2);
		obj.displayQueue();
		System.out.println("The peek is : "+obj.peek());
		obj.delete();
		obj.displayQueue();
	}

}
