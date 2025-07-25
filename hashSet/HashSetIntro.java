package hashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<10;i++) {
			set.add(i);
		}
		System.out.println(set);
		System.out.println(set.contains(2));
		System.out.println(set.size());
		System.out.println(set.isEmpty());
		Iterator<Integer> itr=set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		for(Integer i:set) {
			System.out.print(i+" ");
		}
	}

}
