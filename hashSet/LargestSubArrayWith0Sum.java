package hashSet;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {15,-2,2,-8,1,7,10,23};
		System.out.println(largest0Sum(arr));
	}
	public static int largest0Sum(int arr[]) {
        int maxLength=0;
		int sum=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
		    sum+=arr[i];
			if(map.containsKey(sum)) {
				maxLength=Math.max(maxLength, i-map.get(sum));
			}else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}
}
