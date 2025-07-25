package heaps;

import java.util.PriorityQueue;

public class PQImplementation {
	static class Student implements Comparable<Student>{
		int rank;
		String name;
		Student(String name,int rank){
			this.rank=rank;
			this.name=name;
		}
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return this.rank-o.rank;
		}
	}
	public PQImplementation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Student> pq=new PriorityQueue<>();
		pq.add(new Student("anuj",4)); 
		pq.add(new Student("ram",2)); 
		pq.add(new Student("aman",5)); 
		pq.add(new Student("raj",1)); 

		
		while(!pq.isEmpty()) {
			Student obj=pq.peek();
			System.out.println(obj.name+" : "+ obj.rank);
			pq.remove();
		}
	}

}
