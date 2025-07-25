package problems;

import java.util.HashSet;

public class RepeatAndMissingNumber {
	public static int[] repeatAndMissingNumber(int arr[]) {
		HashSet<Integer> set=new HashSet<>();
		int result[]=new int[2];
		for(int i:arr) {
			if(set.contains(i)) {
				result[0]=i;
			}else {
				set.add(i);
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
