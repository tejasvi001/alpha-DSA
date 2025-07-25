package hashSet;

import java.util.HashMap;

public class SubArrayWithKSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3};
		System.out.println(subArraysWithKSum(arr,3));
	}
	public static int subArraysWithKSum(int arr[],int k) {
		int sum=0,count=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0, 1);
		for(int i=0;i<arr.length;i++) {
		    sum+=arr[i];
			if(map.containsKey(sum-k)) {
				count+=map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}

}
