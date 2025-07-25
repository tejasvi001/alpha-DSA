package problems;

public class SubArraySum {
	//BRUTE FORCE
	public static int maxSubArraySum1(int arr[]) {
		int m=Integer.MIN_VALUE;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int x=0;
				for(int k=i;k<=j;k++) {
					x+=arr[k];
				}
				m=Math.max(m, x);
			}
		}
		return m;
	}
	//PREFIX SUM METHOD
	public static int maxSubArraySum2(int arr[]) {
		int m=Integer.MIN_VALUE;
		int n=arr.length;
		int prefix[]=new int[n];
		prefix[0]=arr[0];
		for(int i=1;i<n;i++) {
			prefix[i]=prefix[i-1]+arr[i];
		}
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				m=Math.max(m, prefix[j]-prefix[i]);
			}
		}
		return m;
	}
	//Kadanes Algorithm
	public static int maxSubArraySum3(int arr[]) {
		int m=Integer.MIN_VALUE;
		int n=arr.length;
		int l=0;
		for(int i=0;i<n;i++) {
			l=Math.max(l+arr[i], arr[i]);
			m=Math.max(l, m);
		}
		return m;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,-3,4,-6,};
		System.out.println(maxSubArraySum1(arr));
		System.out.println(maxSubArraySum2(arr));
		System.out.println(maxSubArraySum3(arr));
	}

}
