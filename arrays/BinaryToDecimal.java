package arrays;

import java.util.ArrayList;
import java.util.List;

public class BinaryToDecimal {
	public static  int binaryToDecimal(int arr[]) {
		int val=0;
		for(int i=arr.length-1;i>=0;i--) {
			int x=(int) (arr[i]*Math.pow(2,(arr.length-1)-i));
			val+=x;
		}
		return val;
	}
	public static int decimalToBinary(int val) {
		ArrayList<Integer> arrayList=new ArrayList<>();
		
		while(val!=0) {
			arrayList.add(val%2);
			val/=2;
		}
		int arr[]=new int[arrayList.size()];
		int x=0;
		int s=arrayList.size()-1;
		for(int i=0;i<arr.length;i++) {
			arr[i]=arrayList.get(s);
			s--;
		}
		for(int xy:arr) {
			x=x*10+xy;
		}
		return x;
		
	}
	public static int decimalToBinary2(int val) {
		
		int x=0;
		int p=0;
		while(val!=0) {
			x=(int) (val%2*Math.pow(10,p)+x);
			p++;
			val/=2;
		}
		return x;
		
	}
	public static List fibonacii(int n) {
		ArrayList<Integer> arrayList=new ArrayList<>();
		arrayList.add(0);
		arrayList.add(1);
		for(int i=2;i<=n;i++) {
			arrayList.add(arrayList.get(i-1)+arrayList.get(i-2));
		}
		//System.out.println(arrayList);
		return arrayList;
	}
	public static int binaryToDecimal(int val) {
		int bin=0;
		int i=0;
		while(val!=0) {
			int x=(val%10==1)?(int) ((val%10)*Math.pow(2,i)):0;
			i++;
			val/=10;
			bin=bin+x;
		}
		return bin;
	}
	public static void main(String[] args) {
		int arr[]= {1,0,1,0};
		System.out.println(binaryToDecimal(arr));
		System.out.println(binaryToDecimal(1111));
		System.out.println(decimalToBinary(10));
		System.out.println(decimalToBinary2(15));
		fibonacii(11);
		
	}

}
