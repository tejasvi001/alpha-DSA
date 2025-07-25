package queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {
	public void firstNonRepeatingChar(String s) {
		int freq[]=new int[26];
		Queue<Character> queue=new LinkedList<>();
		for(char a:s.toCharArray()) {
			queue.add(a);
			freq[a-'a']++;
			while(!queue.isEmpty()&&(freq[queue.peek()-'a']>1)) {
				queue.remove();
			}
			if(queue.isEmpty()) {
				System.out.print("-1 ");
			}else {
				System.out.print(queue.peek()+" ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNonRepeatingChar obj=new FirstNonRepeatingChar();
		obj.firstNonRepeatingChar("aabccxb");
	}

}
