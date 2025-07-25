package queues;

public class CircularQueueUsingArrays {
	private int queue[];
	private int front,rear;
	CircularQueueUsingArrays(){
		queue=new int[10];
		front=-1;
		rear=-1;
	}
	public boolean isEmpty() {
		if(front==-1&&rear==-1) {
			return true;
		}
		return false;
	}
	public boolean isFull() {
		return (rear+1)%queue.length==front;
	}
	public void display() {
	    if (isEmpty()) {
	        System.out.println("The queue is empty");
	        return;
	    }

	    System.out.print("Queue: ");
	    int i = front;
	    while (true) {
	        System.out.print(queue[i] + " ");
	        if (i == rear) break;
	        i = (i + 1) % queue.length;
	    }
	    System.out.println();
	}

	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return queue[front];
	}
	public void add(int n ) {
		if(isFull()) {
			System.out.println("The queue is full");
			return;
		}
		if(front==-1) {
			front++;
		}
		rear=(rear+1)%queue.length;
		queue[rear]=n;
	}
	public int remove() {
		if(isEmpty()) {
			return -1;
		}
		int temp=queue[front];
		if(front==rear) {
			front=rear=-1;
		}else {
			front=(front+1)%queue.length;
		}
		return temp;
	}
	public static void main(String[] args) {
	    CircularQueueUsingArrays cq = new CircularQueueUsingArrays();

	    // Adding elements
	    System.out.println("Adding elements:");
	    for (int i = 1; i <= 10; i++) {
	        cq.add(i * 10);
	    }
	    cq.display(); // Should show 10 20 30 ... 100

	    // Attempt to add to full queue
	    cq.add(110); // Should print "The queue is full"

	    // Remove a few elements
	    System.out.println("\nRemoving elements:");
	    System.out.println("Removed: " + cq.remove()); // 10
	    System.out.println("Removed: " + cq.remove()); // 20
	    cq.display(); // Should show 30 40 50 ... 100

	    // Add more elements to wrap around
	    System.out.println("\nAdding after removal:");
	    cq.add(110);
	    cq.add(120);
	    cq.display(); // Should show 30 40 ... 100 110 120

	    // Peek at the front element
	    System.out.println("\nPeek: " + cq.peek()); // Should be 30

	    // Remove all elements
	    System.out.println("\nRemoving all:");
	    while (!cq.isEmpty()) {
	        System.out.print(cq.remove() + " ");
	    }
	    System.out.println();

	    // Final state
	    cq.display(); // Should show "The queue is empty"
	}


}
