package hashSet;

import java.util.HashSet;

public class UnionAndIntersectionOf2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {1,2,3,4,5};
		int arr2[]= {4,5,6,7,8};
		HashSet<Integer> union=new HashSet<>();
		HashSet<Integer> intersection= new HashSet<>();
		for(int i:arr1) {
			union.add(i);
		}
		for(int i:arr2) {
			if(union.contains(i)) {
				intersection.add(i);
			}else {
				union.add(i);
			}
		}
		System.out.println("Union "+ union);
		System.out.println("Intersection "+ intersection);
	}

}
