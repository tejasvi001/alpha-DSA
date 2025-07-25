package dynamicProgramming;

public class IntroToDP {
	public int fibonacii(int n) {
		if(n==1||n==0) {
			return n;
		}
		return fibonacii(n-1)+fibonacii(n-2);
	}
	public static int fib(int n,int f[]) {
		if(n==0||n==1) {
			return n;
		}
		if(f[n]!=0) {
			return f[n];
		}
		f[n]=fib(n-1,f)+fib(n-2,f);
		return f[n];
	}
	public static int fibTabulation(int n) {
		if(n<=1) {
			return n;
		}
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int fib[]=new int[n+1];
		System.out.println(fib(n,fib));
		System.out.println(fibTabulation(5));
	}

}
